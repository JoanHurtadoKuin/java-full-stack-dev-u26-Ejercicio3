package com.team02.u26.ejercicio3.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.team02.u26.ejercicio3.dto.Productos;

public interface IProductosDAO extends JpaRepository<Productos, Integer>{

}
