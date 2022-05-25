package com.projectTP.web_recipes.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, type;

    @OneToMany(mappedBy = "ingredient")
    private List<Recipes> recipes;

}
