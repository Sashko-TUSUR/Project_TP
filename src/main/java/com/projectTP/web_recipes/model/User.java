package com.projectTP.web_recipes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
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



}
