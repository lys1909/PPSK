package com.example.demo.Vo;

public class UserVO {
    private String userName;
    private String date;
    private String descreption;
    private String IP;

    public UserVO(String userName) {
        this.userName = userName;
    }

    public UserVO(String userName, String date, String descreption, String IP) {
        this.userName = userName;
        this.date = date;
        this.descreption = descreption;
        this.IP = IP;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }
}
