package com.itheima.exception;

public class sysException extends Exception {
    private String massage;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public sysException(String massage) {
        this.massage = massage;
    }
}
