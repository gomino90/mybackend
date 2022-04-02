package com.pi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
	

	@Autowired
	private AuthenticationManager authenticationManager;



	
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
		
	}

	@GetMapping("/auth/loginForm")
	public String loinForm() {
		
		return "user/loginForm";
		
	}
	@GetMapping("/user/deleteForm")
	public String deleteForm() {
		
		return "user/deleteForm";
		
	}
	@GetMapping("/user/updateForm")
	public String updateForm() {
		
		return "user/updateForm";
		
	}
	@GetMapping("/admin/changePassword")
	public String adminchangePassword() {
		return "admin/changePassword";
	}
	@GetMapping("/admin/updateForm")
	public String adminupdateForm() {
		
		return "admin/updateForm";
	}
	
	@GetMapping("/admin")
	public String admin() {
		
		return "admin/main";
	}
	
	@GetMapping("/admin/mangement")
	public String adminmangement() {
		
		return "admin/mangement";
	
	}
	@GetMapping("/admin/bbs")
	public String adminbbs() {
		
		return "admin/bbs";
	
	}
	@GetMapping("/admin/table")
	public String admintable() {
		
		return "admin/table";
	
	}
	@GetMapping("/admin/write")
	public String adminwrite() {
		
		return "admin/write";
	
	}
	
	
	/*
	 * @GetMapping("/auth/kakao/callback") public String kakaoCallback(String code)
	 * {
	 * 
	 * RestTemplate rt = new RestTemplate();
	 * 
	 * org.springframework.http.HttpHeaders headers= new
	 * org.springframework.http.HttpHeaders();
	 * headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8")
	 * ;
	 * 
	 * MultiValueMap<String,String>params=new LinkedMultiValueMap<>();
	 * params.add("grant_type","authorization_code");
	 * params.add("client_id","b29649527cd86bf17ae7e595f7ef8f70");
	 * params.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
	 * params.add("code", code);
	 * 
	 * HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest= new
	 * HttpEntity<>(params,headers);
	 * 
	 * ResponseEntity<String>response = rt.exchange(
	 * "https://kauth.kakao.com/oauth/token", HttpMethod.POST, kakaoTokenRequest,
	 * String.class
	 * 
	 * );
	 * 
	 * 
	 * ObjectMapper objectMapper = new ObjectMapper(); OAuthToken oauthToken = null;
	 * try { oauthToken =
	 * objectMapper.readValue(response.getBody(),OAuthToken.class); } catch
	 * (JsonMappingException e) { e.printStackTrace(); } catch
	 * (JsonProcessingException e) { e.printStackTrace(); }
	 * 
	 * 
	 * System.out.println("zzkdkfs"+oauthToken.getAccess_token());
	 * 
	 * RestTemplate rt2 = new RestTemplate(); org.springframework.http.HttpHeaders
	 * headers2= new org.springframework.http.HttpHeaders();
	 * headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
	 * headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8"
	 * );
	 * 
	 * 
	 * HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest2= new
	 * HttpEntity<>(headers2);
	 * 
	 * ResponseEntity <String>response2 = rt2.exchange(
	 * "https://kapi.kakao.com/v2/user/me", HttpMethod.POST, kakaoProfileRequest2,
	 * String.class
	 * 
	 * );
	 * 
	 * ObjectMapper objectMapper2 = new ObjectMapper(); KakaProfile kakaProfile =
	 * null; try { kakaProfile =
	 * objectMapper2.readValue(response2.getBody(),KakaProfile.class); } catch
	 * (JsonMappingException e) { e.printStackTrace(); } catch
	 * (JsonProcessingException e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * User kakaoUser =User.builder()
	 * .username(kakaProfile.getKakao_account().getEmail()+"_"+kakaProfile.getId())
	 * .password(cosKey) .email(kakaProfile.getKakao_account().getEmail())
	 * .oauth("kakao") .build();
	 * 
	 * System.out.println(kakaoUser.getUsername()); User originuser =
	 * userService.회원찾기(kakaoUser.getUsername()); if(originuser.getUsername()==null)
	 * { System.out.println("기존회원이 아니기에 자동회원가입을 진행합니다.");
	 * userService.회원가입(kakaoUser); }
	 * 
	 * Authentication authentication = authenticationManager.authenticate(new
	 * UsernamePasswordAuthenticationToken(kakaoUser.getUsername(),cosKey));
	 * SecurityContextHolder.getContext().setAuthentication(authentication);
	 * 
	 * return "redirect:/";
	 * 
	 * }
	 */
		

}