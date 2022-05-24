package com.team02.u26.ejercicio3.service;

import java.util.List;

import com.team02.u26.ejercicio3.dto.MaquinasRegistradoras;

public interface IMaquinasRegistradorasService {
	
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras();

	public MaquinasRegistradoras guardarMaquinasRegistradoras(MaquinasRegistradoras maquinasRegistradoras);

	public MaquinasRegistradoras MaquinasRegistradorasXID(int codigo);

	public MaquinasRegistradoras actualizarMaquinasRegistradoras(MaquinasRegistradoras maquinasRegistradoras);

	public void eliminarMaquinasRegistradoras(int codigo);

}
