package com.team02.u26.ejercicio3.service;

import java.util.List;

import com.team02.u26.ejercicio3.dto.Cajeros;



public interface ICajerosService {
	// Metodos del CRUD
	public List<Cajeros> listarCajeros();

	public Cajeros guardarCajeros(Cajeros cajeros);

	public Cajeros cajerosXID(int codigo);

	public Cajeros actualizarCajeros(Cajeros cajeros);

	public void eliminarCajeros(int codigo);

}
