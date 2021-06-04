package pl.coderslab.cocktailMixer.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "recipe_alcohol")
public class RecipeAlcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float volumeAdd;
    private String type;
    @OneToOne
    private Alcohol alcohol;
    @ManyToOne
    private Recipe recipe;
}
