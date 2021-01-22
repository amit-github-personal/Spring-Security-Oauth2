package com.springcoders;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/user/status/check")
	public String getStatus() {
		return "Server is up";
	}
	
	@GetMapping("/user/current")
	public Jwt getAuthenticatedPrincipal(@AuthenticationPrincipal Jwt principal) {
		return principal;
	}
}
