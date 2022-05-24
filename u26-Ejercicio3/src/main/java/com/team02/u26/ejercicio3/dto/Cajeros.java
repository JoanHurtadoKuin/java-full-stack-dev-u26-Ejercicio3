package com.team02.u26.ejercicio3.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name= "cajeros")
public class Cajeros {
	
	//Atributos de entidad Cajeros
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name = "nom_apels")
	private String nomApels;

	
    @OneToMany
    @JoinColumn(name="codigo")
    private List<Venta> venta;

	public Cajeros() {

	}
    
	public Cajeros(int codigo, String nomApels) {
		this.codigo = codigo;
		this.nomApels = nomApels;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomApels() {
		return nomApels;
	}

	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}

	
	@JsonIgnore //ignoramos la generacion del JSON para evitar bucles
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Cajeros [codigo=" + codigo + ", nomApels=" + nomApels + "]";
	}

}
