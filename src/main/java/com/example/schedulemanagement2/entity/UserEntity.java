package com.example.schedulemanagement2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public abstract class UserEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false,unique = true)
    private String password;

    @Column(nullable = false,unique = true)
    private String email;
}
