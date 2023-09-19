package com.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sts.model.signup;
public interface Userrepo extends JpaRepository<signup, Integer>{
	@Query ("select count(*) from signup s where s.email= :email and s.name= :name")
	long isfound(String email, String name);
	@Query ("select count(*) from signup s where s.email= :email")
	long login(String email);
	@Query ("select s.password from signup s where s.email= :email")
	String retpass(String email);
	
//	public Optional<Signup> findSignupByEmail(String email);
}
	