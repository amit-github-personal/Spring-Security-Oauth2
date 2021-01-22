package com.springcoders.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class GrantedAuthorityConverter implements Converter<Jwt, Collection<GrantedAuthority>>{

	@Override
	public Collection<GrantedAuthority> convert(Jwt source) {
		List<GrantedAuthority> roles_and_authority = new ArrayList<>();
		Map<String, Object> realmJson = (Map<String, Object>) source.getClaims().get("realm_access");
		List<String> roles = (List<String>) realmJson.get("roles");
		roles.forEach(role -> roles_and_authority.add(new SimpleGrantedAuthority(role)));
		return roles_and_authority;
	}

}
