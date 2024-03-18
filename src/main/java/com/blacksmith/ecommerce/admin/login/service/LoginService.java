package com.blacksmith.ecommerce.admin.login.service;

import com.blacksmith.ecommerce.admin.login.domain.MemberDTO;

public interface LoginService {
	public boolean login(MemberDTO memberDTO);
}
