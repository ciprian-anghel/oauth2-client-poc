package com.mizu.mizucore.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String defaultPage(OAuth2AuthenticationToken token) {
		
		OAuth2User user = token.getPrincipal();
		System.out.println(user.getName());
		
		return "index.html";
	}

}
