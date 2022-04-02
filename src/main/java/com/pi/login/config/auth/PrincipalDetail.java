package com.pi.login.config.auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.pi.login.dto.UserDto;
import com.pi.login.model.User;

import lombok.Getter;

@Getter

public class PrincipalDetail implements UserDetails {

	private User user;
	@Autowired
	private UserDto userDto;
	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * Set<GrantedAuthority> roles = new HashSet<>(); for (String role :
	 * auth.split(",")) { roles.add(new SimpleGrantedAuthority(role)); } return
	 * roles; }
	 */

	  @Override
	  public Collection<? extends GrantedAuthority> getAuthorities() {
	    Set<GrantedAuthority> roles = new HashSet<>();
	    for (String role : user.getRole().split(",")) {
	      roles.add(new SimpleGrantedAuthority(role));
	    }
	    return roles;
	  }
}
