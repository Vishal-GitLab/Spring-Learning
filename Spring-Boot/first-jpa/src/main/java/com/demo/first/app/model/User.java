package com.demo.first.app.model;


import jakarta.persistence.*;

import java.util.List;

// POJO --> Plain  Old Java Objects ,,,,      ----> koi ak aisi class hai simple class hai jo kisi framework se related interface ya implements nahi karti hai
@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // ye auto generate value hai
    private int  id;
    private String name;
    private  String email;


    public User() {          // kyunki jpa ak object already bna leta hai
    }
    // mai add karunga profile relation ke liye

    // mapped by ka  matlab hme isme key nahi chahiye "user" me nahi chaiye .... CascadeType -- jo bhi operation ho vo Cascade ho
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)   // ham chahe jo User  operation kare  vo sab Profile me hoga                // kyunki ak user ki ak hi profile ho sakti h
    private Profile profile;



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    // ye jo post hai sab ye jo nayi table banegi usko hta dega
    private List<Post> posts;      // isko list me isliye likhenge kyunki ak post multiple source perform kar sakta hai


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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
