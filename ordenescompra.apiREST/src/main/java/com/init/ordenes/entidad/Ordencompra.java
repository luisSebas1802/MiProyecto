package com.init.ordenes.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ordencompra")
public class Ordencompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idordencompra;
	
	private Date fcompra;
	private String moneda;
	
	
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date createAt;

	 private String status;
	
	 //Producto
     private Long idproducto;
	 private String nomproducto;
	 private String categproducto;
	 private Double precio;
 
	 //Proveedor
	 private Long idproveedor;
	 private String nomproveedor;
	public Long getIdordencompra() {
		return idordencompra;
	}
	public void setIdordencompra(Long idordencompra) {
		this.idordencompra = idordencompra;
	}
	public Date getFcompra() {
		return fcompra;
	}
	public void setFcompra(Date fcompra) {
		this.fcompra = fcompra;
	}
	public String getMoneda() {
		return moneda;
	}
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}
	public String getNomproducto() {
		return nomproducto;
	}
	public void setNomproducto(String nomproducto) {
		this.nomproducto = nomproducto;
	}
	public String getCategproducto() {
		return categproducto;
	}
	public void setCategproducto(String categproducto) {
		this.categproducto = categproducto;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Long getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(Long idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getNomproveedor() {
		return nomproveedor;
	}
	public void setNomproveedor(String nomproveedor) {
		this.nomproveedor = nomproveedor;
	}
	 
	 

}
