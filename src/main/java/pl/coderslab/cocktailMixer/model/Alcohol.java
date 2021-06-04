package pl.coderslab.cocktailMixer.model;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "alcohols")
public class Alcohol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "należy podać nazwę")
    @Column(unique = true)
    private String name;
    @NotNull(message = "należy wpisać wartość max 80")
    @Max(80)
    private float abv;
    private String description;
}
