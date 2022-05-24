package com.team02.u26.ejercicio3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team02.u26.ejercicio3.dao.IProductosDAO;
import com.team02.u26.ejercicio3.dto.Productos;

@Service
public class ProductosServiceImpl implements IProductosService {

	@Autowired
	IProductosDAO iProductosDAO;

	@Override
	public List<Productos> listarProductos() {
		return iProductosDAO.findAll();
	}

	@Override
	public Productos guardarProductos(Productos productos) {
		return iProductosDAO.save(productos);
	}

	@Override
	public Productos ProductosXID(int codigo) {
		return iProductosDAO.findById(codigo).get();
	}

	@Override
	public Productos actualizarProductos(Productos productos) {
		return iProductosDAO.save(productos);
	}

	@Override
	public void eliminarProductos(int codigo) {
		iProductosDAO.deleteById(codigo);
	}

}
