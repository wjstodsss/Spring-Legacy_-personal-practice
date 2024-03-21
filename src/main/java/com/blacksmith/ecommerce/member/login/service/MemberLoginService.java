package com.blacksmith.ecommerce.member.login.service;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;

public interface MemberLoginService {

	void register(UserDTO userDTO);

	UserDTO memberLogin(String userEmail);

}
