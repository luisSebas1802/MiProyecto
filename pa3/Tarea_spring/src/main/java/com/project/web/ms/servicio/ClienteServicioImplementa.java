package com.project.web.ms.servicio;

import java.util.*;


import org.springframework.stereotype.Service;

import com.project.web.ms.modelo.Cliente;
import com.project.web.ms.repositorio.ClienteRepositorio;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClienteServicioImplementa implements ClienteServicio {
	
	public final ClienteRepositorio clienteRepositorio;
	
	@Override
	public Cliente createClient(Cliente cliente) {
		cliente.setEstado("creado");
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente updateClient(Cliente cliente) {
		Cliente sUpdate = getClient(cliente.getIdcliente());
		
		if(sUpdate == null) {
			return null;
		}
		
		sUpdate.setTipocliente(cliente.getTipocliente());
		sUpdate.setNombre(cliente.getNombre());
		sUpdate.setTipo_documento(cliente.getTipo_documento());
		sUpdate.setNum_documento(cliente.getNum_documento());
		sUpdate.setDireccion(cliente.getDireccion());
		sUpdate.setTelefono(cliente.getTelefono());
		sUpdate.setEmail(cliente.getEmail());
		sUpdate.setEstado(cliente.getEstado());
	
		
		return clienteRepositorio.save(sUpdate);
	}
	
	@Override
	public List<Cliente> ListAllClient() {
		return clienteRepositorio.findAll();
	}	

	@Override
	public Cliente deleteClient(Long id) {
		Cliente clienteDelete = getClient(id);
		if(clienteDelete == null) {
			return null;
		}
		
		clienteDelete.setEstado("Eliminado");
		
		return clienteRepositorio.save(clienteDelete);
	}


	@Override
	public Cliente getClient(Long id) {
		return clienteRepositorio.findById(id).orElse(null);
	}
	
}
	

	
		
		
		


	
	


