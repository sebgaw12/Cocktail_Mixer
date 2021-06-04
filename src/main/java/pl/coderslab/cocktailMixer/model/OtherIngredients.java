package pl.coderslab.cocktailMixer.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "other_ingredients")
public class OtherIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "należy wypełnić wszystkie pola")
    private String name, description;

}
