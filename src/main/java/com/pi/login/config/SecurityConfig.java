package com.pi.login.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.pi.login.config.auth.PrincipalDetailService;





@Configuration
@EnableWebSecurity//시큐리티 필터 추가=스프링 시큐리티가 활성화가 되어있는데 어떤 설정을 해당 파일에서 하겠다.
@EnableGlobalMethodSecurity(prePostEnabled = true)//특정 주소로 접근을 하면 권한및 인증을 미리 체크하겠다는 뜻.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}

	@Bean
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
			}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		    .csrf().disable()
			.authorizeRequests()
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**","/scss/**","/vendor/**","/images/**").permitAll()
				/* .antMatchers("/facAdmin").hasRole("FACADMIN") */
				.anyRequest()
				.authenticated()
			 .and()			 
			  .formLogin()
			  .loginPage("/auth/loginForm")			  
			  .loginProcessingUrl("/auth/loginProc");			
//	          .failureUrl("faill");
		
	}
}
