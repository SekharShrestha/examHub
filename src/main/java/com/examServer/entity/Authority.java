package com.examServer.entity;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {
	
	private String auth;
	
	public Authority(String auth) {
		super();
		this.auth = auth;
	}

	@Override
	public String getAuthority() {
		return this.auth;
	}

}
