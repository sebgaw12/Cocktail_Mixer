package pl.coderslab.cocktailMixer.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "należy wypełnić wszystkie pola")
    private String description, name;
    @NotNull(message = "należy wypełnić wszystkie pola")
    private float volume;
    @ManyToOne
    private User user;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeAlcohol> recipeAlcohols;
    @OneToMany(mappedBy = "recipe")
    private List<RecipeOtherIngredients> recipeOtherIngredients;
}
