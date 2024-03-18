package com.blacksmith.ecommerce.admin.login.domain;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private LocalDateTime createdAt;
}