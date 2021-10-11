package com.project.web.ms.modelo;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "cliente")
public class Cliente {

	

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idcliente;
		
		@NotEmpty(message = "El nombre no debe ser vacío")
		private String tipocliente ;
		private String nombre ;
		private String tipo_documento;
		private String num_documento;
		private String direccion ;
		private String telefono;
		private String  email;
		private String  estado;
		
		
		
		
		
		
		
		
		
		
	}



