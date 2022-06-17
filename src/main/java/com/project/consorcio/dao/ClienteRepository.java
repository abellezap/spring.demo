package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	//select *from tb_cliente where pat_cli like 'a%'
	@Query("select c from Cliente c where c.paterno like ?1")
	public List<Cliente> listAllByApellido(String paterno); //paterno= a%
}
