package com.cole.asciiapp.model;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends SecurityProperties.User {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;

    @Column(name = "password")
    private long user_password;

    @OneToMany
    @JoinColumn(name = "ASCII_ID", foreignKey = @ForeignKey(name = "FK_ASCII_ID"))
    private List<Ascii> asciiList;
}
