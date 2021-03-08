package com.admin.admin.service.impl;

import com.admin.admin.dto.AdminLoginDTO;
import com.admin.admin.dto.AdminLoginResponseDTO;
import com.admin.admin.entity.Admin;
import com.admin.admin.entity.Sessions;
import com.admin.admin.repository.AdminRepository;
import com.admin.admin.repository.SessionRepository;
import com.admin.admin.service.AdminService;
import com.admin.admin.utils.CustomHash;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AdminServiceIMPL implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public void insertLogin(AdminLoginDTO adminLoginDTO){
        Admin login = new Admin();
        BeanUtils.copyProperties(adminLoginDTO,login);
        String hashedpassword = DigestUtils.sha256Hex(adminLoginDTO.getPassword());
        hashedpassword = DigestUtils.sha256Hex(hashedpassword);
        login.setPassword(hashedpassword);
        adminRepository.save(login);
    }


    @Override
    public AdminLoginResponseDTO adminService(AdminLoginDTO adminLoginDTO){
        AdminLoginResponseDTO responseDTO = new AdminLoginResponseDTO();
        Optional<Admin> optional= adminRepository.findById(adminLoginDTO.getUserName());
        if(optional.isPresent()){
            String hashedpassword = DigestUtils.sha256Hex(adminLoginDTO.getPassword());
            hashedpassword = DigestUtils.sha256Hex(hashedpassword);

            boolean ans = (optional.get().getPassword().equals(hashedpassword));
            if(ans){
                Sessions sessions = new Sessions();

                String sessionID = adminLoginDTO.getUserName() + java.time.LocalDate.now().toString() + java.time.LocalTime.now().toString();
                System.out.println("jsut before hashing "+sessionID);
                int randomNum = ThreadLocalRandom.current().nextInt(1, 6);
                for (int i = 0; i < randomNum; i++) {
                    sessionID = CustomHash.hashString(sessionID);
                }

                sessions.setSessionID(sessionID);
                sessions.setIsLoggedIn("true");
                sessions.setUserName(adminLoginDTO.getUserName());
                sessionRepository.save(sessions);

               // clientService.setSessionInBookAndSearch(requestDTO.getUserName(),sessionID,"true");
                responseDTO.setMessage("SUCCESS");
                responseDTO.setSessionID(sessionID);
                responseDTO.setIsAdmin("true");
                return responseDTO;
            }
            else{
                responseDTO.setMessage("FAILED");
                responseDTO.setSessionID("");
            }
        }
        responseDTO.setMessage("FAILED");
        responseDTO.setSessionID("");
        return responseDTO;
    }
}
