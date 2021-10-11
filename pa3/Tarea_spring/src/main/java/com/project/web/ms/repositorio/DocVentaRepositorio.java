package com.project.web.ms.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.web.ms.modelo.Cliente;
import com.project.web.ms.modelo.Deuda;
import com.project.web.ms.modelo.DocVenta;
import com.project.web.ms.modelo.Empleado;


public interface DocVentaRepositorio {

	
	@Repository
	public interface ProductoRepositorio extends JpaRepository<DocVenta, Long> {

		public List<DocVenta> findByCliente(Cliente cliente);
		public List<DocVenta> findByEmpleado(Empleado empleado);
		public List<DocVenta> findByDeuda(Deuda Deuda);
	}
}
