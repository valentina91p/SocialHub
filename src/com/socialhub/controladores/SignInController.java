package com.socialhub.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignInController {
	@RequestMapping(value="/signin", method=RequestMethod.GET)
	public String signin(){
		return "signin";
	}
}
