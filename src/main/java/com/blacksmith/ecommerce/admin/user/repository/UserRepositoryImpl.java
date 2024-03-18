package com.blacksmith.ecommerce.admin.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<UserDTO> getUserList() {
        return sqlSessionTemplate.selectList("mapper.userMapper.getUserList");
    }
    
    @Override
    public void delete(int id) {
		sqlSessionTemplate.delete("mapper.userMapper.delete", id);
	}
    
    @Override
    public UserDTO getOne(int id) {
		return sqlSessionTemplate.selectOne("mapper.userMapper.getOne", id);
	}
    
    @Override
    public int update(UserDTO userDTO) {
	    return sqlSessionTemplate.update("mapper.userMapper.update", userDTO);
	}
}

