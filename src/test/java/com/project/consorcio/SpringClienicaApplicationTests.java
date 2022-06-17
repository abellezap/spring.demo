package com.project.consorcio;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.consorcio.entity.Enlace;
import com.project.consorcio.services.UsuarioService;

@SpringBootTest
class SpringClienicaApplicationTests {

	@Autowired
	//private BCryptPasswordEncoder encoder;
	private UsuarioService service;
	
	
	@Test
	void contextLoads() {
		//String clave;
		//clave=encoder.encode("123");
		//System.out.println("Valor : "+clave);
		List<Enlace> lista=service.listaEnlacesDelUsuario(2);
		for(Enlace e:lista)
			System.out.println(e.getCodigo()+"---"+e.getDescripcion()+"---"+e.getRuta());
	}

}
