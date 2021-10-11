package com.init.ordenes.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.init.ordenes.entidad.Ordencompra;

public interface OrdenesDAO  extends JpaRepository<Ordencompra, Long>{

}
