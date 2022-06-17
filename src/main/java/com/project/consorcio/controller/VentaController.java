package com.project.consorcio.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.consorcio.entity.Boleta;
import com.project.consorcio.entity.Cliente;
import com.project.consorcio.entity.Detalle;
import com.project.consorcio.entity.Medicamento;
import com.project.consorcio.entity.MedicamentoHasBoleta;
import com.project.consorcio.entity.Usuario;
import com.project.consorcio.services.BoletaService;
import com.project.consorcio.services.ClienteService;
import com.project.consorcio.services.MedicamentoService;

@Controller
@RequestMapping("/ventas")
public class VentaController {
	@Autowired
	private MedicamentoService medServicio;
	
	@Autowired
	private ClienteService cliServicio;
	
	@Autowired
	private BoletaService bolServicio;
	
	
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("medicamentos",medServicio.listarTodos());	
		return "boleta";
	}
	
	@RequestMapping("/consultaCliente")
	@ResponseBody
	public List<Cliente> consultaCliente(@RequestParam("apellido") String ape){
		return cliServicio.listarClientesPorApellido(ape+"%");
	}
	
	@RequestMapping("/adicionar")
	@ResponseBody
	public List<Detalle> adicionar(@RequestParam("codigo") int cod,@RequestParam("nombre") String nom,
						  @RequestParam("cantidad") int can,
						  @RequestParam("precio") double pre,HttpSession session) {
		//declarar arreglo de objetos de la clase Detalle
		List<Detalle> lista=null;
		//validar si existe el atributo "detalle" dentro de session
		if(session.getAttribute("detalle")==null)//no existe atributo detalle dentro de session
			lista=new ArrayList<Detalle>();
		else
			//recuperarel atributo "detalle" y guardarlo en el arreglo "lista"
			lista=(List<Detalle>) session.getAttribute("detalle");
		
		//crear objeto de la clase Detalle
		Detalle det=new Detalle();
		//asignar valor a los atributos adel objeto "det"
		det.setCodigo(cod);
		det.setNombre(nom);
		det.setCantidad(can);
		det.setPrecio(pre);
		//adicionar objeto "det" dentro del arreglo "lista"
		lista.add(det);
		//crear atributo detalle
		session.setAttribute("detalle", lista);
		
		return lista;
	}
	@RequestMapping("/eliminar")
	@ResponseBody
	public List<Detalle> eliminar(@RequestParam("codigo")int cod, HttpSession session) {
		//recuperar el atributo "detalle" y guardarlo en el arreglo "lista"
		List<Detalle> lista=(List<Detalle>) session.getAttribute("detalle");
		//bucle
		for(Detalle det:lista) {
			if(det.getCodigo()==cod) {
				lista.remove(det);
				break;
			}
		}
		
		return lista;
	}
	
	
	@RequestMapping("/grabar")
	public String grabar(@RequestParam("codigoCliente") int codCli,@RequestParam("fecha") String fec,
						 HttpSession session,@SessionAttribute("CODIGOUSUARIO") int codUsuario,
						 @RequestParam("total") double totalPagar,RedirectAttributes redirect) {
		try {
			Boleta bol=new Boleta();
			bol.setFechaEmision(LocalDate.parse(fec));
			bol.setCliente(new Cliente(codCli));
			bol.setUsuario(new Usuario(codUsuario));
			bol.setMonto(totalPagar);
			//recuperar atributo detalle
			List<Detalle> lista=(List<Detalle>) session.getAttribute("detalle");
			//crear un arreglo de la clase MedicamentoHasBoleta
			List<MedicamentoHasBoleta> data=new ArrayList<MedicamentoHasBoleta>();
			//bucle
			for(Detalle d:lista) {
				MedicamentoHasBoleta mhb=new MedicamentoHasBoleta();
				mhb.setMedicamento(new Medicamento(d.getCodigo()));
				mhb.setCantidad(d.getCantidad());
				mhb.setPrecio(d.getPrecio());
				data.add(mhb);
				
			}
			
			bol.setListaMedicamentoHasBoleta(data);
			bolServicio.grabarBoleta(bol);
			//limpiar detalle
			lista.clear();
			session.setAttribute("detalle", lista);
			//
			redirect.addFlashAttribute("MENSAJE","Boleta registrada");
			
		} catch (Exception e) {
			e.printStackTrace();
			redirect.addFlashAttribute("MENSAJE","Error en la boleta");
		}
		return "redirect:/ventas/";
	}
	
	
}












