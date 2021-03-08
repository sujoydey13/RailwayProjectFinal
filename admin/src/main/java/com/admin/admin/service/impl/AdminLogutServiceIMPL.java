package com.admin.admin.service.impl;

import com.admin.admin.dto.AdminLogoutDTO;
import com.admin.admin.repository.SessionRepository;
import com.admin.admin.service.AdminLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AdminLogutServiceIMPL implements AdminLogoutService {
    @Autowired
    private SessionRepository sessionRepository;
    @Override
    @Transactional
    public void logoutAdmin(AdminLogoutDTO adminLogoutDTO){
        String optional= sessionRepository.findbysessionid(adminLogoutDTO.getSessionId());
        if(optional!=null){
            try{
                sessionRepository.deleteSession(adminLogoutDTO.getSessionId());

            }
            catch (Exception e){
                // e.printStackTrace();
            }

            }

        }
    }

