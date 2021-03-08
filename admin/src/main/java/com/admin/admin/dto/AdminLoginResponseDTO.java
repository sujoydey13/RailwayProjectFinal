package com.admin.admin.dto;

import lombok.Data;

@Data
public class AdminLoginResponseDTO {
    private String message;
    private String sessionID;
    private String isAdmin;
}
