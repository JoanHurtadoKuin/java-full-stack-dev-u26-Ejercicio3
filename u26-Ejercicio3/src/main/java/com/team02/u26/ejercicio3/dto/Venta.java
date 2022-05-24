package com.team02.u26.ejercicio3.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "venta")
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(name = "cajero")
	private Cajeros cajero;
	
	@ManyToOne
	@JoinColumn(name = "maquina")
	private MaquinasRegistradoras maquina;
	
	@ManyToOne
	@JoinColumn(name = "producto")
	private Productos producto;

	public Venta() {
	}
	
	public Venta(int codigo, Cajeros cajero, MaquinasRegistradoras maquina, Productos producto) {
		this.codigo = codigo;
		this.cajero = cajero;
		this.maquina = maquina;
		this.producto = producto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cajeros getCajero() {
		return cajero;
	}

	public void setCajero(Cajeros cajero) {
		this.cajero = cajero;
	}

	public MaquinasRegistradoras getMaquina() {
		return maquina;
	}

	public void setMaquina(MaquinasRegistradoras maquina) {
		this.maquina = maquina;
	}

	public Productos getProducto() {
		return producto;
	}

	public void setProducto(Productos producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Venta [codigo=" + codigo + ", cajero=" + cajero + ", maquina=" + maquina + ", producto=" + producto
				+ "]";
	}
	
}
