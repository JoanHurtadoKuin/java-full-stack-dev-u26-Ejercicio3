package com.team02.u26.ejercicio3.service;

import java.util.List;

import com.team02.u26.ejercicio3.dto.Venta;

public interface IVentaService {

	public List<Venta> listarVenta();

	public Venta guardarVenta(Venta venta);

	public Venta ventaXID(int codigo);

	public Venta actualizarVenta(Venta venta);

	public void eliminarVenta(int codigo);
}
