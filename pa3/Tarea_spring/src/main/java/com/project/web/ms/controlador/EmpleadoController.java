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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.web.ms.modelo.Cliente;
import com.project.web.ms.modelo.Empleado;
import com.project.web.ms.servicio.ClienteServicio;
import com.project.web.ms.servicio.EmpleadoServicio;



@RestController
@RequestMapping(value = "/empleado")
public class EmpleadoController {

	
	@Autowired
	EmpleadoServicio empleadoServicio;
	
	//@GetMapping("/")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Empleado>> ListarEmpleado() {
		
		List<Empleado> empleado = new ArrayList<>();
		
		 {
			empleado= empleadoServicio.ListAllEmpl();
			if(empleado.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		
			if(empleado.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
		}
		
		return ResponseEntity.ok(empleado);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Empleado> getEmpl(@PathVariable("id") Long id){
		
		Empleado empleado = empleadoServicio.getEmpl(id);
		if(empleado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empleado);
	}
	
	//@RequestMapping(value = "/",method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Empleado> CrearEmpleado(@Valid @RequestBody Empleado empleado,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Empleado empleadoCreado = empleadoServicio.createEmpl(empleado);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoCreado);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Empleado> actualizarEmpl(@PathVariable("id") Long id,
			@RequestBody Empleado empleado){
		empleado.setIdempleado(id);
		
		Empleado empleadoEncontrado = empleadoServicio.updateEmpl(empleado);
		
		if(empleadoEncontrado == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(empleadoEncontrado);
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



