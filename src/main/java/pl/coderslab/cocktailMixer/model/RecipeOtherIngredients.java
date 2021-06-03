package pl.coderslab.cocktailMixer.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "recipe_otherIngredients")
public class RecipeOtherIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float volumeAdd;
    private String type;
    @OneToOne
    private OtherIngredients otherIngredient;
    @ManyToOne
    private Recipe recipe;
}
