package com.project.web.ms.repositorio;

//import java.util.*;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.project.web.ms.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

	
}
