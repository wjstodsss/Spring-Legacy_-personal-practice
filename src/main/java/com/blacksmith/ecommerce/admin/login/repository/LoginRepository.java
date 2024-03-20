package com.blacksmith.ecommerce.admin.login.repository;

import com.blacksmith.ecommerce.admin.login.domain.MemberDTO;

public interface LoginRepository {

	public MemberDTO login(MemberDTO memberDTO);

}
