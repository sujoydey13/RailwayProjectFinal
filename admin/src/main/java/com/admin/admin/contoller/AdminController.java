package com.admin.admin.contoller;

import com.admin.admin.dto.AdminLoginDTO;
import com.admin.admin.dto.AdminLoginResponseDTO;
import com.admin.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public void insertLogin (@RequestBody AdminLoginDTO adminLoginDTO){
        adminService.insertLogin(adminLoginDTO);
    }

    @PostMapping("")
    public AdminLoginResponseDTO adminService(@RequestBody AdminLoginDTO adminLoginDTO){
        //Cookie cookies[] = request.getCookies();
        //System.out.println(cookies[0].getName());
        return adminService.adminService(adminLoginDTO);
    }

}
