package com.project.web.ms.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "empleado")


public class Empleado {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idempleado;
	
	@NotEmpty(message = "El nombre no debe ser vacío")
	private String nombre;
	private String num_documento;
	
	private String direccion;
	private String telefono;
	private String  email;
	private String  estado;
	
	
	
	
	
	
	
}


