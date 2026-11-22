package com.demo.first.app.model;


// POJO --> Plain  Old Java Objects ,,,,      ----> koi ak aisi class hai simple class hai jo kisi framework se related interface ya implements nahi karti hai
public class User {
    private int  id;
    private String name;
    private  String email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public String getEmail() {
        return email;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
