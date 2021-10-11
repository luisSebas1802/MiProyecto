package com.project.web.ms.servicio;

import java.util.List;

import com.project.web.ms.modelo.Cliente;

public interface ClienteServicio {

	
	public List<Cliente> ListAllClient();
	public Cliente getClient(Long id);
	
	public Cliente createClient(Cliente cliente);
	public Cliente updateClient(Cliente cliente);
	public Cliente deleteClient(Long id);
	
	
	
	

}
