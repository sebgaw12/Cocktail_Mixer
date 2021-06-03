package pl.coderslab.cocktailMixer.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Email(message = "niepoprawny format email")
    @NotBlank(message = "należy podać email")
    @Column(unique = true)
    private String email;
    @NotBlank(message = "należy wypełnić wszystkie pola")
    private String password;
    @NotBlank(message = "należy wypełnić wszystkie pola")
    @Column(unique = true)
    private String username;
    @OneToMany(mappedBy = "user")
    private List<Recipe> recipes;
    private int enabled;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Role> roles;
}
