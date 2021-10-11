package com.init.ordenes.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.init.ordenes.DAO.OrdenesDAO;
import com.init.ordenes.entidad.Ordencompra;

@RestController
@RequestMapping("/")
public class OrdencompraREST {
	@Autowired
	private OrdenesDAO ordenesDAO;
	
	
	@RequestMapping(value = "ordencompra",method = RequestMethod.GET)
	public ResponseEntity<List<Ordencompra>> getOrdencompra(){
		
		List<Ordencompra> ordenescompra = ordenesDAO.findAll();
		return ResponseEntity.ok(ordenescompra);
	}
	
	@RequestMapping(value = "ordencompra/{ordencompraid}",method = RequestMethod.GET)
	public ResponseEntity<Ordencompra> getOrdencompraById(@PathVariable("ordencompraid") Long idordencompra){
		
		Optional<Ordencompra> optionalOrdencompra = ordenesDAO.findById(idordencompra);
		
		if(optionalOrdencompra.isPresent()) {
			return ResponseEntity.ok(optionalOrdencompra.get());
		}else {
			return ResponseEntity.noContent().build();
		}

	}
	
	@PostMapping
	@RequestMapping(value = "ordencompra",method = RequestMethod.POST)
	public ResponseEntity<Ordencompra> crearOrdencompra(@RequestBody Ordencompra ordencompra){
		Ordencompra nuevaOrden = ordenesDAO.save(ordencompra);
		return ResponseEntity.ok(nuevaOrden);
	}
	
	
	@PostMapping
	@RequestMapping(value = "ordencompra/{ordencompraId}",method = RequestMethod.DELETE)
	public ResponseEntity<Ordencompra> borrarOrdencompra(@PathVariable("ordencompraId") Long ordencompraId){
		ordenesDAO.deleteById(ordencompraId);
		return ResponseEntity.ok(null);
	}	
	
	@PutMapping
	@RequestMapping(value = "ordencompra",method = RequestMethod.PUT)
	public ResponseEntity<Ordencompra> actualizarOrden(@RequestBody Ordencompra ordencompra){
		
		Optional<Ordencompra> optionalOrdencompra = ordenesDAO.findById(ordencompra.getIdordencompra());
		
		if(optionalOrdencompra.isPresent()) {
			Ordencompra actualizarOrden = optionalOrdencompra.get();
			actualizarOrden.setIdordencompra(ordencompra.getIdordencompra());
			actualizarOrden.setFcompra(ordencompra.getFcompra());
			actualizarOrden.setMoneda(ordencompra.getMoneda());
			
			ordenesDAO.save(actualizarOrden);
			return ResponseEntity.ok(actualizarOrden);
		}else {
			return ResponseEntity.noContent().build();
		}

	}	

}
