package com.citi.cfg;

import org.springframework.data.jpa.repository.JpaRepository;

import com.citi.cfg.bean.UserSpring;

public interface UserRepository extends JpaRepository<UserSpring, Long> 
{
	UserSpring findByUsername(String username);
}
