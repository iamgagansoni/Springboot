package com.sts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sts.repository.*;
import com.sts.model.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@CrossOrigin(origins = "*",maxAge = 3600)
@RequestMapping("/api")
public class maincontroller {
	@Autowired
	private Userrepo userrepo;
	@Autowired
	private Productrepo productrepo;
	@Autowired
	private BCryptPasswordEncoder encode;
	
	@PostMapping("/signup")
	public String signup(@RequestBody signup sg)
	{

		if(userrepo.isfound(sg.getEmail(), sg.getName())>0)
		{
            return "User Already exist";
		}
		String pass=sg.getPassword();

		String hash= encode.encode(pass);

		sg.setPassword(hash);
		userrepo.save(sg);
		System.out.println(sg);
		return "Signed up";
	}
	@PostMapping("/login")
	public String login(@RequestBody signup sg)
	{
		if(userrepo.login(sg.getEmail())>0 && encode.matches( sg.getPassword(),userrepo.retpass(sg.getEmail())))
		{
            return "login";
		}
		return "Please Enter Correct Credentials";
	}
	
	
	@PostMapping("/products")
	public List<String> Product(@RequestBody Products pd) {
		if(!productrepo.getbyclas(pd.getClas()).isEmpty())
		{
			return productrepo.getbyclas(pd.getClas());
		}
		return null;
		
	}
}

