package com.blacksmith.ecommerce.member.login.repository;

import com.blacksmith.ecommerce.admin.user.domain.UserDTO;

public interface MemberLoginRepository {

	void register(UserDTO userDTO);

	UserDTO memberLogin(String userEmail);

}
