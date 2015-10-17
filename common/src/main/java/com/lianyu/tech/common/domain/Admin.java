package com.lianyu.tech.common.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "wx_admin")
public class Admin {
    @Id
    @GeneratedValue
    @Column(name = "admin_id")
    private Integer adminId;
    @Column(name = "admin_name")
    private String adminName;
    @Column(name = "password")
    private String password;
    @Column(name = "last_login_time")
    private Date lastLoginTime;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private AdminStatus status;

    public Admin() {
        status = AdminStatus.ACTIVE;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public AdminStatus getStatus() {
        return status;
    }

    public void setStatus(AdminStatus status) {
        this.status = status;
    }

    public enum AdminStatus {
        ACTIVE, INACTIVE
    }
}
