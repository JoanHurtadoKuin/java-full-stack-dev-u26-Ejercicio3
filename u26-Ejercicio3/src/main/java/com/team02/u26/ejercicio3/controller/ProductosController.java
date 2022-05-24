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

import com.team02.u26.ejercicio3.dto.Productos;
import com.team02.u26.ejercicio3.service.ProductosServiceImpl;

@RestController
@RequestMapping("/productos")
public class ProductosController {
	
	@Autowired
	ProductosServiceImpl productosServiceImpl;
	
	@GetMapping("/")
	public List<Productos> listarProductos(){
		return productosServiceImpl.listarProductos();
	}

	@PostMapping("/")
	public Productos salvarProductos(@RequestBody Productos Productos) {
		return productosServiceImpl.guardarProductos(Productos);
	}
	
	@GetMapping("/{codigo}")
	public Productos productosXID(@PathVariable(name="codigo") int codigo) {
		Productos productos_xid = new Productos();
		productos_xid = productosServiceImpl.ProductosXID(codigo);
		
		return productos_xid;
	}
	
	@PutMapping("/{codigo}")
	public Productos actualizarProductos(@PathVariable(name="codigo")int codigo,@RequestBody Productos Productos) {
		
		Productos productos_seleccionado= new Productos();
		Productos productos_actualizado= new Productos();
		
		productos_seleccionado= productosServiceImpl.ProductosXID(codigo);
		
		productos_seleccionado.setNombre(Productos.getNombre());
		productos_seleccionado.setPrecio(Productos.getPrecio());


		productos_actualizado = productosServiceImpl.actualizarProductos(productos_seleccionado);
		
		return productos_actualizado;
	}
	
	@DeleteMapping("/{codigo}")
	public void eliminarProductos(@PathVariable(name="codigo") int codigo) {
		productosServiceImpl.eliminarProductos(codigo);
	}
	
}
