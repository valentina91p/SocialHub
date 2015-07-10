package com.socialhub.controladores;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.socialhub.modelos.Usuario;
import com.socialhub.servicios.UsuarioService;

@Controller
@RequestMapping(value="/")
public class FeedController {
	@Inject
	private Facebook facebook;
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "feed"}, method = RequestMethod.GET)
	public String consultarUsuarios(Principal principal, Model model){
		//return usuarioService.listUsuarios();
		if(facebook.isAuthorized()){
			model.addAttribute("fbFeed", facebook.feedOperations().getHomeFeed());
			model.addAttribute("perfil", facebook.userOperations().getUserProfile());
		}
		
		model.addAttribute("usuario", usuarioService.loadUsuarioByUsername(principal.getName()));
		return "feed";
	}
	
	@RequestMapping(value="/config", method=RequestMethod.GET)
	public String configurarCuentas(){
		return "config";
	}
}
