package com.demo.first.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;


    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(          // hme ak nqayi table bnane ke liye iska use karna padega
            name  = "post_tags",
            joinColumns =  @JoinColumn(name = "post_id"),        // JoinColumn--> ye current jo ye entity hai usme post_id aur other side hai uske liye tag_id
            inverseJoinColumns = @JoinColumn(name = "tag_id")     // other side ke liye inverseJoinColumns ka use karte hai
    )
    private List<Tag> tags;

    public Post() {
    }

    public Post( String title, String content) {
        this.title = title;
        this.content = content;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
















