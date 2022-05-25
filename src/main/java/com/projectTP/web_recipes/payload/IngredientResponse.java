package com.projectTP.web_recipes.payload;

import com.projectTP.web_recipes.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientResponse {
   List<Ingredient> name;

}
