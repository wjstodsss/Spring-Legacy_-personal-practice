package com.blacksmith.ecommerce.admin.user.service;

import java.util.List;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;

public interface UserService {
	public List<UserDTO> getUserList();
	public void delete(int id);
	public UserDTO getOne(int id);
	public int update(UserDTO userDTO);

}
