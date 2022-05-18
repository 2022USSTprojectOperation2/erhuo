package com.usst.erhuo.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String userName;
    private String password;
    private String phone;
    private String headImgPath;
    private int exp;
    private String introduction;
    private String grade;
    private String major;
    private String address;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", headImgPath='" + headImgPath + '\'' +
                ", exp=" + exp +
                ", introduction='" + introduction + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
