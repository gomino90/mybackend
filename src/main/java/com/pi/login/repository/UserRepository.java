package com.pi.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.pi.login.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByUsername(String username);
	User findByUserId(String username);
	
	  @Modifying
	  @Transactional
	  @Query(value ="update User u set u.password=?1 where u.username=?2",nativeQuery = true)
	 public void updatePwdNative(String fpwd,String username);
	 
	
}



