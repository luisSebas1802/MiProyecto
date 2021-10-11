package com.project.web.ms.servicio;

import java.util.List;


import com.project.web.ms.modelo.Producto;

public interface PedidoInternoServicio {

	
	public List<Producto> ListAllProduct();
	public Producto getProduct(Long id);
	
	public Producto createProducto(Producto producto);
	public Producto updateProduct(Producto producto);
	public Producto deleteProducto(Long id);
	
	
	
	public Producto updateStock(Long id, Double quantity);
}

