package com.citi.cfg;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.citi.cfg.bean.UserSpring;

public class UserDetailsImpl implements UserDetails {

	private UserSpring userSpring;
	
	public UserDetailsImpl(UserSpring userSpring) {
		super();
		this.userSpring = userSpring;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		This method is used to tell that jar user ni enter kela asel application madhe
//		tar tyala grant de, ie authority de
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	@Override
	public String getPassword() {
		return userSpring.getPassword();
	}

	@Override
	public String getUsername() {
		return userSpring.getUsername();
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

}
