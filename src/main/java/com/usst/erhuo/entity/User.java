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



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
