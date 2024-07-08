package com.example.lesson8.Entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@ToString
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name="sender_id")
    @JsonBackReference
    private User sender;

    public Message(String text, User sender) {
        this.text = text;
        this.sender = sender;
    }


}
