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

import com.team02.u26.ejercicio3.dto.Cajeros;
import com.team02.u26.ejercicio3.service.CajerosServiceImpl;

@RestController
@RequestMapping("/cajeros")
public class CajerosController {
	
	@Autowired
	CajerosServiceImpl cajerosServiceImpl;
	
	@GetMapping("/")//Endpoint para listar los cajeros
	public List<Cajeros> listarCajeros(){
		return cajerosServiceImpl.listarCajeros();
	}

	@PostMapping("/")//Endpoint para insrtar cajeros
	public Cajeros salvarCajeros(@RequestBody Cajeros cajeros) {
		return cajerosServiceImpl.guardarCajeros(cajeros);
	}
	
	@GetMapping("/{codigo}")//Endpoint para filtrar cajeros pasandole un codigo 
	public Cajeros cajerosXID(@PathVariable(name="codigo") int codigo) {
		Cajeros cajero_xid = new Cajeros();
		cajero_xid = cajerosServiceImpl.cajerosXID(codigo);
		
		return cajero_xid;
	}
	
	@PutMapping("/{codigo}")//Endpoint para actualizar cajero pasandole un codigo
	public Cajeros actualizarCajeros(@PathVariable(name="codigo")int codigo,@RequestBody Cajeros cajeros) {
		
		Cajeros cajeros_seleccionado= new Cajeros();
		Cajeros cajeros_actualizado= new Cajeros();
		
		cajeros_seleccionado= cajerosServiceImpl.cajerosXID(codigo);
		
		cajeros_seleccionado.setNomApels(cajeros.getNomApels());


		cajeros_actualizado = cajerosServiceImpl.actualizarCajeros(cajeros_seleccionado);
		
		return cajeros_actualizado;
	}
	
	@DeleteMapping("/{codigo}")//Endpoint para borrar cajeros pasadole el codigo
	public void eliminarCajeros(@PathVariable(name="codigo") int codigo) {
		cajerosServiceImpl.eliminarCajeros(codigo);
	}
	
}
