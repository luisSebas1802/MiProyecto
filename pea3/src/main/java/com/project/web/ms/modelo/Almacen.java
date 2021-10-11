package com.project.web.ms.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "almancen")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Almacen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "La direccion no deve ser vacia")
	private String direccion;
	private String nomalmacen;
	private String nroalmacen;
	
}
