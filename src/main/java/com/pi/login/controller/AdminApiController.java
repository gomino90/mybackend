package com.pi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pi.login.config.auth.PrincipalDetail;
import com.pi.login.service.UserService;

public class AdminApiController {

	@Autowired
	private UserService userService;
	
	  @PostMapping("/updatpwd") 
	  public boolean updatePwd(@AuthenticationPrincipal PrincipalDetail principalDetail,
			  @RequestParam(value ="pwd")String pwd,
			  @RequestParam(value ="npwd")String npwd,
			  @RequestParam(value ="fpwd")String fpwd) {
		  
		  
	 System.out.println(principalDetail.getUsername());
	 System.out.println(principalDetail.getPassword());

	 //return userService.updataPwd(principalDetail, pwd, npwd, fpwd) != null;
		  return false;
	
    }
	  
}
