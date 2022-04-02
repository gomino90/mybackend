package com.pi.login.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;

import com.pi.login.config.SecurityConfig;
import com.pi.login.config.auth.PrincipalDetail;
import com.pi.login.dto.UserDto;
import com.pi.login.model.User;
import com.pi.login.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SecurityConfig security;

	private UserDto userDto;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)//정합성(같은데이터)
	public User 회원찾기(String username){
		User user= userRepository.findByUsername(username).orElseGet(()->{
			return new User();
		});
		return user;
	}
	@org.springframework.transaction.annotation.Transactional
	public void 회원탈퇴 (int id) {
	 userRepository.deleteById(id);
			
	}
	@org.springframework.transaction.annotation.Transactional
	public List<User> 회원다찾자(){
		return userRepository.findAll();
	}
	@org.springframework.transaction.annotation.Transactional
	public User 회원찾자(@PathVariable int id){
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
		@Override
		public IllegalArgumentException get() {
		return new IllegalArgumentException("해당 유저는 없습니다.");
		}});
		return user;
	}
	@org.springframework.transaction.annotation.Transactional
	public User 회원가입(UserDto userDto) {
		String rawPassword = userDto.getPassword();
		String encPassword = encoder.encode(rawPassword);
		userDto.setPassword(encPassword);
		return userRepository.save(
				User.builder()
				.username(userDto.getUsername())
				.userId(userDto.getUserId())
				.password(userDto.getPassword())
				.email(userDto.getEmail())
				.phone(userDto.getPhone())
				.role(userDto.getRole())
				.build());
		
		}
	@org.springframework.transaction.annotation.Transactional
	public void 회원수정(User user) {
		User persistance = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원찾기 실패");
		});
		
		if(persistance.getOauth()==null||persistance.getOauth().equals("")) {
			String rawPassword = user.getPassword();
			String encPassword = encoder.encode(rawPassword);
			persistance.setPassword(encPassword);
		}
		persistance.setPhone(user.getPhone());
		persistance.setEmail(user.getEmail());
		
		
	}
	@Validated
	public String updataPwd(@AuthenticationPrincipal PrincipalDetail principalDetail,String pwd,String npwd,String fpwd){
		try {
		
			
		    User userdto=userRepository.findByUserId(principalDetail.getUsername());
			BCryptPasswordEncoder bCryptPasswordEncoder = security.encodePWD();
			if(bCryptPasswordEncoder.matches(pwd, userDto.getPassword())) {
				if(npwd.equals(fpwd)) {
					String haspwd=bCryptPasswordEncoder.encode(fpwd);
					userRepository.updatePwdNative(haspwd, userDto.getUsername());
					principalDetail.getUser().setPassword(haspwd);
					return "yes";
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
	}
		return "no";
	
	} 	 
				/*
				 * BCryptPasswordEncoder bCryptPasswordEncoder=security.pwdEncoder()를 이용해서
				 * 
				 * bCryptPasswordEncoder.matches()를 사용한다
				 * 
				 * 이게 뭐냐면 해시되어있는 비밀번호를
				 * 
				 * 열어서 해시되어있지 않는 비밀번 와 일치한 지
				 * 
				 * 검사해주는 기능이다
				 * 
				 * 이렇게 현재 비밀번호가 맞는지 검증을 하고
				 * 
				 * String hashpwd=bCryptPasswordEncoder.encode(npwd2);
				 * 
				 * userdao.updatePwdNative(hashpwd,uservo.getEmail());
				 * 
				 * principaldetail.getUservo().setPwd(hashpwd);
				 * 
				 * 맞다면 다시 해시를 해서
				 * 
				 * db를 수정한 후 현재 시큐리티 세션에 pwd값을 변경해준다
				 */
				/*
				 * } }catch (Exception e) { e.printStackTrace(); } return "성공"; }
				 */

		
		/*
		 * User user1 = userRepository.getById(user1.getUserId()).orElseThrow(()->{
		 * return new IllegalArgumentException("회원찾기 실패"); });
		 */
		
//		if(persistance.getOauth()==null||persistance.getOauth().equals("")) {
//			String rawPassword = user.getPassword();
//			String encPassword = encoder.encode(rawPassword);
//			persistance.setPassword(encPassword);
//			 persistance.setUsername(user.getUsername());
//			 persistance.setUserId(user.getUserId());
//			 persistance.setEmail(user.getEmail());
//		}
}

