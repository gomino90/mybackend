package com.pi.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pi.login.dto.ResponseDto;
import com.pi.login.dto.UserDto;
import com.pi.login.model.User;
import com.pi.login.service.UserService;



@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private BCryptPasswordEncoder encode;
	
	/*
	 * 회원전체목록
	 * @param
	 * @return
	 */
	@GetMapping("/auth/userAll")
	public List<User> 회원다찾자(){
		return userService.회원다찾자();
	}
	
	@GetMapping("/auth/user/{id}")
	public User 회원찾자(@PathVariable int id){
		User user = userService.회원찾자(id);
		return user;
	}
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody UserDto userDto) {	
	userService.회원가입(userDto);
			return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PostMapping("/auth/delete/{id}")
	public void deleteById( @PathVariable int id){
		userService.회원탈퇴(id);
		
	}
		
	@PostMapping("/auth/user")
	public ResponseDto<Integer>update(@RequestBody User user){
		userService.회원수정(user);
	
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
		
	}
	/*
	 * @PostMapping("/updatepwd") public boolean updatePwd(@AuthenticationPrincipal
	 * PrincipalDetail principalDetail,@RequestParam("pwd")String
	 * pwd,@RequestParam("npwd")String npwd,@RequestParam("npwd2")String npwd2) {
	 * 
	 * return false; }
	 */
	
}