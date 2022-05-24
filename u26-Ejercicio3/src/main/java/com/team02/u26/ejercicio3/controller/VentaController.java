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

import com.team02.u26.ejercicio3.dto.Venta;
import com.team02.u26.ejercicio3.service.VentaServiceImpl;

@RestController
@RequestMapping("/venta")
public class VentaController {
	
	@Autowired
	VentaServiceImpl ventaServiceImpl;
	
	@GetMapping("/")//Endpoint para listar los venta
	public List<Venta> listarventa(){
		return ventaServiceImpl.listarVenta();
	}

	@PostMapping("/")//Endpoint para insertar venta
	public Venta salvarventa(@RequestBody Venta venta) {
		return ventaServiceImpl.guardarVenta(venta);
	}
	
	@GetMapping("/{codigo}")//Endpoint para filtrar venta pasandole un codigo 
	public Venta ventaXID(@PathVariable(name="codigo") int codigo) {
		Venta venta_xid = new Venta();
		venta_xid = ventaServiceImpl.ventaXID(codigo);
		
		return venta_xid;
	}
	
	@PutMapping("/{codigo}")//Endpoint para actualizar venta pasandole un codigo
	public Venta actualizarventa(@PathVariable(name="codigo")int codigo,@RequestBody Venta venta) {
		
		Venta venta_seleccionado= new Venta();
		Venta venta_actualizado= new Venta();
		
		venta_seleccionado= ventaServiceImpl.ventaXID(codigo);
		
		venta_seleccionado.setCajero(venta.getCajero());
		venta_seleccionado.setProducto(venta.getProducto());
		venta_seleccionado.setMaquina(venta.getMaquina());

		venta_actualizado = ventaServiceImpl.actualizarVenta(venta_seleccionado);
		
		return venta_actualizado;
	}
	
	@DeleteMapping("/{codigo}")//Endpoint para borrar venta pasadole el codigo
	public void eliminarventa(@PathVariable(name="codigo") int codigo) {
		ventaServiceImpl.eliminarVenta(codigo);
	}
	
}
