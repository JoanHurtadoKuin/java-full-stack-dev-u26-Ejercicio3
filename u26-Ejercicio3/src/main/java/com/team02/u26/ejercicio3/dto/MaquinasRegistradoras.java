package com.team02.u26.ejercicio3.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@Entity
@Table(name = "maquinas_registradoras")
public class MaquinasRegistradoras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "piso")
	private int piso;

	@OneToMany
	@JoinColumn(name = "codigo")
	private List<Venta> venta;

	public MaquinasRegistradoras() {
	}

	public MaquinasRegistradoras(int codigo, int piso) {
		this.codigo = codigo;
		this.piso = piso;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	@Override
	public String toString() {
		return "MaquinasRegistradoras [codigo=" + codigo + ", piso=" + piso + "]";
	}
	
}
