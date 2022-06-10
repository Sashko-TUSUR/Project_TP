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
    private String name;

    private Boolean approved=false;

   //@Lob
   //private byte[] image;

    private String filename;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_typeFood")
    private TypeFood typeFood;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "recipes_comment",joinColumns = @JoinColumn(name = "id_recipes"),
            inverseJoinColumns = @JoinColumn(name = "id_comment"))

    private List<Comment> comments;


    @ManyToMany
    @JoinTable(name = "recipes_ingredients", joinColumns = @JoinColumn(name = "id_recipes"),
            inverseJoinColumns = @JoinColumn(name = "id_ingredient"))
            private List<Ingredient> ingredients;

    public Recipes(String recipes, String name, Boolean approved, Byte[] image, User user, TypeFood typeFood, List<Ingredient> ingredients) {
        this.recipes = recipes;
        this.name = name;
        this.approved = approved;
        this.user = user;
        this.typeFood = typeFood;
        this.ingredients = ingredients;
    }

}
