package com.geekaca.testdb.pojo;

public class User {
    //id, name, pwd, age, tel, deleted, version
    private Integer id;
    private String userName;
    private String userPwd;
    private Integer userAge;
    private String userTel;
    private Integer userDeleted;
    private Integer userVersion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(Integer userDeleted) {
        this.userDeleted = userDeleted;
    }

    public Integer getUserVersion() {
        return userVersion;
    }

    public void setUserVersion(Integer userVersion) {
        this.userVersion = userVersion;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userAge=" + userAge +
                ", userTel='" + userTel + '\'' +
                ", userDeleted=" + userDeleted +
                ", userVersion=" + userVersion +
                '}';
    }
}
