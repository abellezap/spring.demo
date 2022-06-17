package com.project.consorcio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.consorcio.entity.Enlace;
import com.project.consorcio.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	//select *from tb_usuario where login='ana' where clave='123'
	//select *from tb_usuario where login='ana'
	@Query("select u from Usuario u where u.login=?1")
	public Usuario iniciarSesion(String usuario);
	
	//select re.idrol,e.descripcion,e.ruta from tb_rol_enlace re join 
	//tb_enlace e on re.idenlace=e.idenlace where re.idrol=2;
	@Query("select e from RolEnlace re join re.enlace e where re.rol.codigo=?1")
	public List<Enlace> traerEnlacesDelUsuario(int codRol);
}
