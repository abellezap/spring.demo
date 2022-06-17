package com.project.consorcio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.consorcio.entity.Enlace;
import com.project.consorcio.entity.Usuario;
import com.project.consorcio.services.UsuarioService;

//crear un atributo de tipo sesión
@SessionAttributes({"ENLACES","DATOS","CODIGOUSUARIO"})
@Controller
public class UsuarioController {
	@Autowired UsuarioService usuarioService;
	
	
	
	@RequestMapping("/login")
	public String index(){
		
		return "sesion";
	}
	
	@RequestMapping("/intranet")
	public String intranet(Authentication auth,Model model){
		//obtener nombre de usuario que inicio sesión
		String nomUsuario=auth.getName();
		//invocar al método iniciaSesion
		Usuario u=usuarioService.iniciaSesion(nomUsuario);
		//invocar al método listaEnlacesDelUsuario
		List<Enlace> lista=usuarioService.listaEnlacesDelUsuario(u.getRol().getCodigo());
		//crear un atributo con el valor del arreglo lista
		model.addAttribute("CODIGOUSUARIO",u.getCodigo());
		model.addAttribute("ENLACES",lista);
		model.addAttribute("DATOS",u.getApellido()+" "+u.getNombre());
		return "intranet";
	}
	
}
