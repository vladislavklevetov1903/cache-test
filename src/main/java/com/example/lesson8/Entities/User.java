package com.example.lesson8.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Message> messages;

    public User(String name, String email, String gender) {
        this.name = name;
        this.email = email;
        this.gender = "мужчина";
    }
}
