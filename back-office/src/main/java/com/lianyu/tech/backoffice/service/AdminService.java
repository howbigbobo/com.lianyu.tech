package com.lianyu.tech.backoffice.service;

import com.lianyu.tech.core.util.DigestUtils;
import com.lianyu.tech.backoffice.web.vo.ValidLoginResultView;
import com.lianyu.tech.common.domain.Admin;
import com.lianyu.tech.common.repository.AdminRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

@Service
public class AdminService {
    private static final String NOT_ADMIN_ERROR = "帐号不存在!";
    private static final String ADMIN_FORBIDDEN_ERROR = "帐号已经禁用!";
    private static final String PASSWORD_INCORRECT_ERROR = "密码不正确!";
    @Inject
    private AdminRepository adminRepository;

    @Transactional
    public ValidLoginResultView validLogin(String name, String pwd, boolean isSecure) {
        ValidLoginResultView validLoginResultView = new ValidLoginResultView();
        Admin admin = adminRepository.adminUnique(name);
        if (admin == null) {
            validLoginResultView.setAdminId(null);
            validLoginResultView.setErrRefer(ValidLoginResultView.ErrRefer.Name);
            validLoginResultView.setErrMsg(NOT_ADMIN_ERROR);
        } else {
            validAdmin(admin, pwd, isSecure, validLoginResultView);
        }

        return validLoginResultView;
    }

    private void validAdmin(Admin admin, String pwd, boolean isSecure, ValidLoginResultView validLoginResultView) {
        if (admin.getStatus() != Admin.AdminStatus.ACTIVE) {
            validLoginResultView.setAdminId(admin.getAdminId());
            validLoginResultView.setErrRefer(ValidLoginResultView.ErrRefer.Name);
            validLoginResultView.setErrMsg(ADMIN_FORBIDDEN_ERROR);
        } else {
            String securePwd;
            if (isSecure)
                securePwd = pwd;
            else
                securePwd = DigestUtils.sha512(pwd);
            if (securePwd.equals(admin.getPassword())) {
                admin.setLastLoginTime(new Date());
                update(admin);
                validLoginResultView.setAdminId(admin.getAdminId());
            } else {
                validLoginResultView.setAdminId(admin.getAdminId());
                validLoginResultView.setErrRefer(ValidLoginResultView.ErrRefer.Password);
                validLoginResultView.setErrMsg(PASSWORD_INCORRECT_ERROR);
            }
        }
    }


    @Transactional
    public void update(Admin admin) {
        adminRepository.update(admin);
    }

    @Transactional
    public Integer save(String name, String pwd) {
        Admin admin = new Admin();
        admin.setAdminName(name);
        String password = DigestUtils.sha512(pwd);
        admin.setPassword(password);
        admin.setLastLoginTime(new Date());
        return adminRepository.save(admin);
    }


    @Transactional
    public Integer save(Admin admin) {
        return adminRepository.save(admin);
    }

    public Admin adminUnique(String adminName) {
        return adminRepository.adminUnique(adminName);
    }
}
