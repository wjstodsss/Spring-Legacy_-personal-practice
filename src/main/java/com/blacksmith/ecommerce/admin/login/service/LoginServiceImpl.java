package com.blacksmith.ecommerce.admin.login.service;

import org.springframework.stereotype.Service;

import com.blacksmith.ecommerce.admin.login.domain.MemberDTO;
import com.blacksmith.ecommerce.admin.login.repository.LoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
	private final LoginRepository loginRepository;
	
	@Override
	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = loginRepository.login(memberDTO);
		
		if(loginMember != null) {
			return true;
		}
		return false;	  
	}
}