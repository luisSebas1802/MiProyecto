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
@Table(name = "PedidoInterno")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PedidoInterno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpedido;
	private Long idproducto;
	private Long cantidad;
}
