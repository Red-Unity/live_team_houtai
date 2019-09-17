package com.live.liveteam.entity;

import java.io.Serializable;
import java.util.Date;

public class Administrator implements Serializable {
    private Integer adminId;

    private String adminNickname;

    private String adminPassword;

    private String adminRealName;

    private String adminIdCard;

    private String adminPower;

    private Date adminLastLog;

    private String adminPhone;

    private Long adminCreateTime;

    private String adminSex;

    private String adminAge;

    private Integer adminStatus;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname == null ? null : adminNickname.trim();
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword == null ? null : adminPassword.trim();
    }

    public String getAdminRealName() {
        return adminRealName;
    }

    public void setAdminRealName(String adminRealName) {
        this.adminRealName = adminRealName == null ? null : adminRealName.trim();
    }

    public String getAdminIdCard() {
        return adminIdCard;
    }

    public void setAdminIdCard(String adminIdCard) {
        this.adminIdCard = adminIdCard == null ? null : adminIdCard.trim();
    }

    public String getAdminPower() {
        return adminPower;
    }

    public void setAdminPower(String adminPower) {
        this.adminPower = adminPower == null ? null : adminPower.trim();
    }

    public Date getAdminLastLog() {
        return adminLastLog;
    }

    public void setAdminLastLog(Date adminLastLog) {
        this.adminLastLog = adminLastLog;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone == null ? null : adminPhone.trim();
    }

    public Long getAdminCreateTime() {
        return adminCreateTime;
    }

    public void setAdminCreateTime(Long adminCreateTime) {
        this.adminCreateTime = adminCreateTime;
    }

    public String getAdminSex() {
        return adminSex;
    }

    public void setAdminSex(String adminSex) {
        this.adminSex = adminSex == null ? null : adminSex.trim();
    }

    public String getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(String adminAge) {
        this.adminAge = adminAge == null ? null : adminAge.trim();
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }
}