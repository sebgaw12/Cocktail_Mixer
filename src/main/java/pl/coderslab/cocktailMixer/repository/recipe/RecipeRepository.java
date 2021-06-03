package pl.coderslab.cocktailMixer.repository.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.cocktailMixer.model.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findById(long id);

}
