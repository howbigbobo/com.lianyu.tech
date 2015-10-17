package com.lianyu.tech.backoffice.web.vo;

public class ValidLoginResultView {
    Integer adminId;
    String errMsg;
    ErrRefer errRefer;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public ErrRefer getErrRefer() {
        return errRefer;
    }

    public void setErrRefer(ErrRefer errRefer) {
        this.errRefer = errRefer;
    }

    public enum ErrRefer {
        Name, Password;

        public static ErrRefer fromString(String value) {
            for (ErrRefer errRefer : ErrRefer.values()) {
                if (errRefer.toString().equalsIgnoreCase(value))
                    return errRefer;
            }
            throw new IllegalArgumentException("can not find string '" + value + "' in ErrRefer " + ErrRefer.class.getName());
        }
    }
}


