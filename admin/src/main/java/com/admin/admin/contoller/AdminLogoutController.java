package com.admin.admin.contoller;

import com.admin.admin.dto.AdminLogoutDTO;
import com.admin.admin.service.AdminLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/logout")
public class AdminLogoutController {
    @Autowired
    private AdminLogoutService adminLogoutService;
    @PostMapping("")
    public void logoutAdmin(@RequestBody AdminLogoutDTO adminLogoutDTO){
        adminLogoutService.logoutAdmin(adminLogoutDTO);
    }
}
