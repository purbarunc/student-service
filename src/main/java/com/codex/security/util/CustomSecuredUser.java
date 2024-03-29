package com.codex.security.util;

import org.springframework.security.core.userdetails.UserDetails;

import com.codex.security.domain.User;

public class CustomSecuredUser extends User implements UserDetails {
	private static final long serialVersionUID = 8887160972677058176L;

	public CustomSecuredUser() {
	}

	public CustomSecuredUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setName(user.getName());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
