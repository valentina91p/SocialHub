package com.socialhub.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialhub.modelos.Usuario;
import com.socialhub.servicios.UsuarioService;

@Controller("/signup")
public class SignUpController {
	@Inject
	private UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String signUpForm(){
		return "signup";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String crearUsuario(HttpServletRequest request){
		Usuario u = new Usuario();
		u.setEmail(request.getParameter("email"));
		u.setNombre(request.getParameter("nombre"));
		u.setContrasena(request.getParameter("contrasena"));
		usuarioService.addUsuario(u);
		return "redirect:/signin";
	}
}
