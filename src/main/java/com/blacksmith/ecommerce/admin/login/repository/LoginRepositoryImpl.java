package com.blacksmith.ecommerce.admin.login.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blacksmith.ecommerce.admin.login.domain.MemberDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginRepositoryImpl implements LoginRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public MemberDTO login(MemberDTO memberDTO) {
        return sqlSessionTemplate.selectOne("mapper.loginMapper.login", memberDTO);
    }
}

