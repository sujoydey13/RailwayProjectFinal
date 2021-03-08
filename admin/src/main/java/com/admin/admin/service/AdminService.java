package com.admin.admin.service;

import com.admin.admin.dto.AdminLoginDTO;
import com.admin.admin.dto.AdminLoginResponseDTO;

public interface AdminService {
     AdminLoginResponseDTO adminService(AdminLoginDTO adminLoginDTO);
    void insertLogin(AdminLoginDTO adminLoginDTO);
}
