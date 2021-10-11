package com.project.web.ms.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "DocVenta")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DocVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDoc;
	private Long idcliente ;
	private Long idempleado;
	private Long idDeuda;
	private String tipoDoc;
	private String observacion;
}
