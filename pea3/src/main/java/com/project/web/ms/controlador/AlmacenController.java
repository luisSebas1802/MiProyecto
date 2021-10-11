package com.project.web.ms.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.project.web.ms.modelo.Almacen;
import com.project.web.ms.servicio.AlmacenServicio;

@RestController
@RequestMapping(value = "/movimientos")
public class AlmacenController {

	@Autowired
	AlmacenServicio almacenServicio;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Almacen> getalmacen(@PathVariable("id") Integer id){
		
		Almacen almacen = almacenServicio.getAlmacen(id);
		if(almacen == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(almacen);
	}
	
	//@RequestMapping(value = "/",method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Almacen> CrearSugerencia(@Valid @RequestBody Almacen almacen,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Almacen AlmacenCreado = almacenServicio.createS(almacen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(AlmacenCreado);
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Almacen> actualizarAlmacen(@PathVariable("id") Integer id,
			@RequestBody Almacen almacen){
		
		almacen.setId(id);
		Almacen almacenEncontrada = almacenServicio.updateS(almacen);
		
		if(almacenEncontrada == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(almacenEncontrada);
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
}
