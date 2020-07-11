package com.nvntback.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pedidos")
public class PedidoDAO {
	public PedidoDAO(String nombre , String precio, String descuento) {
		this.nombre = nombre; 
		this.precio = precio;
		this.descuento = descuento;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idPedido;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column( name = "precio" )
	private String precio;
	
	@Column(name = "descuento")
	private String descuento;

	
	public String getName() {
		return nombre;
	}

	public void setName(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrice(String precio) {
		this.precio = precio;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public String getDiscount() {
		return descuento;
	}

	public void setDiscount(String descuento) {
		this.descuento = descuento;
	}
	
	
}
