package com.projectTP.web_recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_recipes;

    @Lob
    private String recipes;
    private String     name, comment;

    private Boolean approved=false;
    
    @Lob
    private Byte[] image;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;


    @ManyToOne
    @JoinColumn(name = "id_typeFood")
    private TypeFood typeFood;

    @ManyToMany
    @JoinTable(name = "recipes_ingredients", joinColumns = @JoinColumn(name = "id_recipes"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
            private List<Ingredient> ingredients;


    public Recipes(String name) {

        this.name = name;

    }



}
