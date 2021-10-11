package com.project.web.ms.servicio;

import java.util.List;

import com.project.web.ms.modelo.*;

public interface AlmacenServicio {

	public List<Almacen> ListAll();
	public Almacen getAlmacen(Integer id);
	

	public Almacen createS(Almacen almacen);
	public Almacen updateS(Almacen almacen);
	public Almacen deleteS(Integer id);
}
