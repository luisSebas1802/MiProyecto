package com.project.web.ms.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.web.ms.modelo.PedidoInterno;
import com.project.web.ms.modelo.Producto;


public interface PedidoInternoRepositorio {

	
	@Repository
	public interface ProductoRepositorio extends JpaRepository<PedidoInterno, Long> {

		public List<PedidoInterno> findByProducto(Producto producto);
	}
}
