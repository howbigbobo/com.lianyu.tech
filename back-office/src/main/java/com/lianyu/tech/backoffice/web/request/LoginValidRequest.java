package com.lianyu.tech.backoffice.web.request;

public class LoginValidRequest {
    String name;
    String pwd;
    String rememberMe;
    String isLoginOut;
    String isSecure;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(String rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getIsLoginOut() {
        return isLoginOut;
    }

    public void setIsLoginOut(String isLoginOut) {
        this.isLoginOut = isLoginOut;
    }

    public String getIsSecure() {
        return isSecure;
    }

    public void setIsSecure(String isSecure) {
        this.isSecure = isSecure;
    }
}
