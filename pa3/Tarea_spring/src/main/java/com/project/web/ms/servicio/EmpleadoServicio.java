package com.project.web.ms.servicio;

import java.util.List;


import com.project.web.ms.modelo.Empleado;

public interface EmpleadoServicio {
	

	public List<Empleado> ListAllEmpl();
	public Empleado getEmpl(Long id);
	
	public Empleado createEmpl(Empleado empleado);
	public Empleado updateEmpl(Empleado empleado);
	public Empleado deleteEmpl(Long id);
	
	

}
