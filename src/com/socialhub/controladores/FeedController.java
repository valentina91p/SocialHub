package com.socialhub.controladores;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialhub.servicios.UsuarioService;

@Controller
@RequestMapping(value="/")
public class FeedController {
	@Inject
	private Facebook facebook;
	@Inject
	private Twitter twitter;
	@Inject
	private ConnectionRepository connectionRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value={"/", "feed"}, method = RequestMethod.GET)
	public String llenarFeed(Principal principal, Model model){
		boolean emptyFeed = true;
		if(facebook != null){
				if( facebook.isAuthorized()){
					model.addAttribute("fbFeed", facebook.feedOperations().getHomeFeed());
					model.addAttribute("perfil", facebook.userOperations().getUserProfile());
					emptyFeed = false;
				}
		}
		if (twitter != null && twitter.isAuthorized()) {
			model.addAttribute("timeline", twitter.timelineOperations().getHomeTimeline());
			emptyFeed = false;
        }
		model.addAttribute("usuario", usuarioService.loadUsuarioByUsername(principal.getName()));
		return "feed";
	}
	
	@RequestMapping(value="/config", method=RequestMethod.GET)
	public String configurarCuentas(){
		return "config";
	}
}
