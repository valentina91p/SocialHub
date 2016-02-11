package com.socialhub.controladores;

import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.PagingParameters;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.socialhub.modelos.Feed;
import com.socialhub.modelos.Usuario;
import com.socialhub.servicios.RedSocialService;
import com.socialhub.servicios.UsuarioService;

@Controller
public class FeedController {
	@Inject
	private Facebook facebook;
	@Inject
	private Twitter twitter;
	@Inject
	private Feed feed;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private RedSocialService redService;
	
	@RequestMapping(value={"/feed"}, method = RequestMethod.GET)
	public String llenarFeed(Principal principal, Model model){
		Usuario u = usuarioService.loadUsuarioByUsername(principal.getName());
		if(redService.isConnectedTo("facebook")){	
			if( facebook.isAuthorized()){
				feed.add(facebook.feedOperations().getHomeFeed().toArray());
				model.addAttribute("perfil", facebook.userOperations().getUserProfile());
			}
		}
		if(redService.isConnectedTo("twitter")){
			if ( twitter.isAuthorized()) {
				feed.add(twitter.timelineOperations().getHomeTimeline().toArray());
	        }
		}
		model.addAttribute("feed", feed.getPosts());
		model.addAttribute("usuario", u);
		return "feed";
	}
	
	@RequestMapping(value="/config", method=RequestMethod.GET)
	public String configurarCuentas(){
		return "config";
	}
}
