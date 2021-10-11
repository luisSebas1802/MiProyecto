package com.project.web.ms.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.web.ms.modelo.Cliente;
import com.project.web.ms.servicio.ClienteServicio;



@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

	@Autowired
	ClienteServicio clienteServicio;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> ListarCliente(@RequestParam(name = "clienteId",
	required = false) Long Id) {
		
		List<Cliente> cliente = new ArrayList<>();			
		
		cliente = clienteServicio.ListAllClient();
			
		return ResponseEntity.ok(cliente);
	}

	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Cliente> getClient(@PathVariable("id") Long id){
		
		Cliente cliente = clienteServicio.getClient(id);
		if(cliente == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(cliente);
	}
	
	//@RequestMapping(value = "/",method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Cliente> CrearCliente(@Valid @RequestBody Cliente cliente,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Cliente clienteCreado = clienteServicio.createClient(cliente);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Cliente> actualizarCliente(@PathVariable("id") Long id,
			@RequestBody Cliente cliente){
		
		cliente.setIdcliente(id);
		Cliente clienteEncontrada = clienteServicio.updateClient(cliente);
		
		if(clienteEncontrada == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(clienteEncontrada);
	}
	
	
    private String formatMessage( BindingResult result){
        List<Map<String,String>> errors = result.getFieldErrors().stream()
                .map(err ->{
                    Map<String,String>  error =  new HashMap<>();
                    error.put(err.getField(), err.getDefaultMessage());
                    return error;

                }).collect(Collectors.toList());
        ErrorMessage errorMessage = ErrorMessage.builder()
                .code("01")
                .messages(errors).build();
        ObjectMapper mapper = new ObjectMapper();
        String jsonString="";
        try {
            jsonString = mapper.writeValueAsString(errorMessage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }	
    
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") long id){
    	Cliente clienteDelete=clienteServicio.deleteClient(id);
    	if(clienteDelete==null){
    		return ResponseEntity.notFound().build();
    	}
    	return ResponseEntity.ok(clienteDelete);
    	
    }
}