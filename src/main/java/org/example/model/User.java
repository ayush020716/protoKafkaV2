package org.example.model;

public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private String password;
    private String address;
    private String phone;
    private String bio;
    public String toJSON(){
        return "{" +
                "\"id\": \"" + id + '\"' +
                ", \"firstName\": \"" + firstName + '\"' +
                ", \"lastName\": \"" + lastName + '\"' +
                ", \"email\": \"" + email + '\"' +
                ", \"age\": \"" + age + '\"' +
                ", \"password\": \"" + password + '\"' +
                ", \"address\": \"" + address + '\"' +
                ", \"phone\": \"" + phone + '\"' +
                ", \"bio\": \"" + bio + '\"' +
                '}';
    }
}
