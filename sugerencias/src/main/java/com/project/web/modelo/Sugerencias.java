package com.project.web.modelo;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Sugerencias")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Sugerencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "El nombre no debe ser vacÃ­o")
	private String suger;
	private String nompersona;
	
	private String area;

	@Column(name="fecsuger")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecsuger;
	
	
	
}
