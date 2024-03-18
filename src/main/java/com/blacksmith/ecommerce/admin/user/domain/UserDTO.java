package com.blacksmith.ecommerce.admin.user.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private Timestamp createdAt;

}
