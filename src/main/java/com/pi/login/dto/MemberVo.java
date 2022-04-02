package com.pi.login.dto;


import java.sql.Timestamp;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter

public class MemberVo {
	
	@NonNull 
	private String username,userId,password,email,phone,role,pwdCheck;
	
	@NonNull	
	private Timestamp indate;

	public boolean isPassCheck() {
		if(this.password.equals(this.pwdCheck)) {
			return false;
		
	}
		return true;
}
}