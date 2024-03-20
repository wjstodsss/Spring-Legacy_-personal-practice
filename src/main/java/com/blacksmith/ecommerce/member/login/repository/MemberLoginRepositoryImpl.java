package com.blacksmith.ecommerce.member.login.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberLoginRepositoryImpl implements MemberLoginRepository {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void register(UserDTO userDTO){
		sqlSessionTemplate.selectOne("mapper.memberMapper.register",userDTO);
	}
	
	@Override
	public UserDTO memberLogin(String userEmail) {
		return sqlSessionTemplate.selectOne("mapper.memberMapper.memberLogin", userEmail);
	}
}
