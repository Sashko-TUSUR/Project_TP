package com.projectTP.web_recipes.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length=32, unique=false)
    @Length(min =2,max =32)
    private String Log;

    @Column(length=32, unique=false)
    @Length(min = 6,max =32)
    private String  Pass;

    private String Mail;

    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return Log;
    }

    public void setLog(String log) {
        Log = log;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
