package com.project.web.ms.servicio;

import java.util.List;

import org.springframework.stereotype.Service;


import com.project.web.ms.modelo.Almacen;
import com.project.web.ms.repositorio.AlmacenRepositorio;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlmacenServicioImplementa implements AlmacenServicio {
	public final AlmacenRepositorio almacenRepositorio;
	
	@Override
	public List<Almacen> ListAll() {
		// TODO Auto-generated method stub
		return almacenRepositorio.findAll();
	}

	@Override
	public Almacen getAlmacen(Integer id) {
		// TODO Auto-generated method stub
		return almacenRepositorio.findById(id).orElse(null);
	}

	@Override
	public Almacen createS(Almacen almacen) {
		// TODO Auto-generated method stub
		
		return almacenRepositorio.save(almacen);
	}

	@Override
	public Almacen updateS(Almacen almacen) {
		// TODO Auto-generated method stub
		Almacen sUpdate = getAlmacen(almacen.getId());
		if(sUpdate == null) {
			return null;
		}
		
		sUpdate.setDireccion(almacen.getDireccion());
		sUpdate.setNomalmacen(almacen.getNomalmacen());
		sUpdate.setNroalmacen(almacen.getNroalmacen());
		
		return almacenRepositorio.save(sUpdate);	
	
	}

	@Override
	public Almacen deleteS(Integer id) {
		Almacen sdelete = getAlmacen(id);
		if(sdelete == null) {
			return null;
		}
		
		
		
		return almacenRepositorio.save(sdelete);
	}

}
