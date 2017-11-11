package com.dat.easyresumebackend.dto;

/**
 * Created by Pham Tien Dat on 08/11/2017.
 */
public class VerificationAccountEmailDto {
    private String verificationPath;
    private String userName;

    public String getVerificationPath() {
        return verificationPath;
    }

    public void setVerificationPath(String verificationPath) {
        this.verificationPath = verificationPath;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
