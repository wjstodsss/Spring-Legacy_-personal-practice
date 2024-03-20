package com.blacksmith.ecommerce.member.login.service;

import org.springframework.stereotype.Service;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;
import com.blacksmith.ecommerce.member.login.repository.MemberLoginRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberLoginServiceImpl implements MemberLoginService {
	private final MemberLoginRepository memberLoginRepository;
	
	@Override
	public void register(UserDTO userDTO) {
		memberLoginRepository.register(userDTO);
	}
	
	@Override
	public UserDTO memberLogin(String userEmail) {
		return memberLoginRepository.memberLogin(userEmail);
	}
}
