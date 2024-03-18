package com.blacksmith.ecommerce.admin.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;
import com.blacksmith.ecommerce.admin.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	public List<UserDTO> getUserList() {
		return (List<UserDTO>) userRepository.getUserList();
	};
	
	public void delete(int id) {
		userRepository.delete(id);
	}
	
	public UserDTO getOne(int id) {
		return userRepository.getOne(id);
	}
	
	public int update(UserDTO userDTO) {
		return userRepository.update(userDTO);
	}
}
