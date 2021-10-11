package com.project.web.ms.servicio;

import java.util.*;

import org.springframework.stereotype.Service;

import com.project.web.ms.servicio.*;
import com.project.web.ms.modelo.Empleado;

import com.project.web.ms.repositorio.EmpleadoRepositorio;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmpleadoServicioImplementa implements EmpleadoServicio{

public final EmpleadoRepositorio empleadoRepositorio;
	
	@Override
	public List<Empleado> ListAllEmpl() {
		return empleadoRepositorio.findAll();
	}

	@Override
	public Empleado getEmpl(Long id) {
		return empleadoRepositorio.findById(id).orElse(null);
	}

	
	@Override
	public Empleado updateEmpl(Empleado empleado) {
		Empleado empleadoUpdate = getEmpl(empleado.getIdempleado());
	
		if(empleadoUpdate == null) {
			return null;
		}
		empleadoUpdate.setNombre(empleado.getNombre());
		empleadoUpdate.setNum_documento(empleado.getNum_documento());
		empleadoUpdate.setDireccion(empleado.getDireccion());
		empleadoUpdate.setTelefono(empleado.getNum_documento());
		empleadoUpdate.setEmail (empleado.getEmail ());
		

		return empleadoRepositorio.save(empleadoUpdate);
	
	}

	@Override
	public Empleado deleteEmpl(Long id) {
		Empleado empleadoDelete = getEmpl(id);
		
		if(empleadoDelete == null) {
			return null;
		}
		
		empleadoDelete.setEstado("ELIMINADO");
		
		return empleadoRepositorio.save(empleadoDelete);
	}

	@Override
	public Empleado createEmpl(Empleado empleado) {
		
		empleado.setEstado("CREADO");
	
		return empleadoRepositorio.save(empleado);
	}


	

}
