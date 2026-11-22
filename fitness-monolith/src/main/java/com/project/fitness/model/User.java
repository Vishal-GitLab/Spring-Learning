package com.project.fitness.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// realtion define karne ke liye hamse jpa ko define karna padta hai
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "fitness_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)         // iska use ham isliye kar rhe hai taki jo hmari user aur email hai vo unique haii isliye
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    // ab hme roll ki information add karni hai
    @Enumerated(EnumType.STRING)      // enum value use karne ke liye ham iska use karte hai.. STRING ka use isiliye karte hai ki database me string type ho
    @Builder.Default
    private UserRole role = UserRole.USER;       // koi user create hoga to vo bydefault use user hoga uska  user ke liye karenge ,, aur ham user ko use ko modify karke ham database me use bhi kae sakte hai

    @CreationTimestamp       //  private LocalDateTime createdAt --- isme jo creation time hai usko automatically save kiya jaye aur time kab generate hoga .. jab entity ko data base me pahli bar save kiya jayega
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // user me hame ak link bnani hai Activity ke liye aur ak bnani hai recommendation ke liye
    // this is one to many relation hai

    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL, orphanRemoval = true)   // cascade ka mtlb hai  jo bhi operation karenge to  vo sab operation activiy user par hongi
   // orphanRemoval iska matlab jo faltu activites rhengi usko delete kar dega
    @JsonIgnore
    @Builder.Default
    private List<Activity> activities = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade =  CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @Builder.Default
    private List<Recommendation> recommendations = new ArrayList<>();



}








