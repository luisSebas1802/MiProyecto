package com.project.web.controlador;


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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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

import com.project.web.modelo.Sugerencias;
import com.project.web.servicio.SugerenciasServicio;

@RestController
@RequestMapping(value = "/sugerencias")
public class SugerenciaController {
	@Autowired
	SugerenciasServicio sugerenciasServicio;
	

	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Sugerencias> getSugerencias(@PathVariable("id") Integer id){
		
		Sugerencias sugerencias = sugerenciasServicio.getSugerencias(id);
		if(sugerencias == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(sugerencias);
	}
	
	//@RequestMapping(value = "/",method = RequestMethod.POST)
	@PostMapping
	public ResponseEntity<Sugerencias> CrearSugerencia(@Valid @RequestBody Sugerencias sugerencias,BindingResult result){
		
		if(result.hasErrors()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,this.formatMessage(result));
		}

		Sugerencias sugerenciasCreado = sugerenciasServicio.createS(sugerencias);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(sugerenciasCreado);
	}
	
	
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Sugerencias> actualizarSugerencia(@PathVariable("id") Integer id,
			@RequestBody Sugerencias sugerencias){
		
		sugerencias.setId(id);
		Sugerencias sugerenciaEncontrada = sugerenciasServicio.updateS(sugerencias);
		
		if(sugerenciaEncontrada == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(sugerenciaEncontrada);
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
