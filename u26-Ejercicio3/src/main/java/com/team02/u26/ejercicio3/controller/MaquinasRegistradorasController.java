package com.team02.u26.ejercicio3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team02.u26.ejercicio3.dto.MaquinasRegistradoras;
import com.team02.u26.ejercicio3.service.MaquinasRegistradorasServiceImpl;

@RestController
@RequestMapping("/maquinas_registradoras")
public class MaquinasRegistradorasController {
	
	@Autowired
	MaquinasRegistradorasServiceImpl maquinasRegistradorasServiceImpl;
	
	@GetMapping("/")//Endpoint para listar los maquinas registradoras
	public List<MaquinasRegistradoras> listarMaquinasRegistradoras(){
		return maquinasRegistradorasServiceImpl.listarMaquinasRegistradoras();
	}

	@PostMapping("/")//Endpoint para insrtar maquinas registradoras
	public MaquinasRegistradoras salvarMaquinasRegistradoras(@RequestBody MaquinasRegistradoras maquinasRegistradoras) {
		return maquinasRegistradorasServiceImpl.guardarMaquinasRegistradoras(maquinasRegistradoras);
	}
	
	@GetMapping("/{codigo}")//Endpoint para filtrar maquinas registradoras pasandole un codigo
	public MaquinasRegistradoras MaquinasRegistradorasXID(@PathVariable(name="codigo") int codigo) {
		MaquinasRegistradoras maquinaRegistradora_xid = new MaquinasRegistradoras();
		maquinaRegistradora_xid = maquinasRegistradorasServiceImpl.MaquinasRegistradorasXID(codigo);
		
		return maquinaRegistradora_xid;
	}
	
	@PutMapping("/{codigo}")//Endpoint para actualizar maquinas registradoras pasandole un codigo
	public MaquinasRegistradoras actualizarMaquinasRegistradoras(@PathVariable(name="codigo")int codigo,@RequestBody MaquinasRegistradoras MaquinasRegistradoras) {
		
		MaquinasRegistradoras maquinasRegistradoras_seleccionado= new MaquinasRegistradoras();
		MaquinasRegistradoras maquinasRegistradoras_actualizado= new MaquinasRegistradoras();
		
		maquinasRegistradoras_seleccionado= maquinasRegistradorasServiceImpl.MaquinasRegistradorasXID(codigo);
		
		maquinasRegistradoras_seleccionado.setPiso(MaquinasRegistradoras.getPiso());


		maquinasRegistradoras_actualizado = maquinasRegistradorasServiceImpl.actualizarMaquinasRegistradoras(maquinasRegistradoras_seleccionado);
		
		return maquinasRegistradoras_actualizado;
	}
	
	@DeleteMapping("/{codigo}")//Endpoint para borrar maquinas registradoras pasadole el codigo
	public void eliminarMaquinasRegistradoras(@PathVariable(name="codigo") int codigo) {
		maquinasRegistradorasServiceImpl.eliminarMaquinasRegistradoras(codigo);
	}
	
}
