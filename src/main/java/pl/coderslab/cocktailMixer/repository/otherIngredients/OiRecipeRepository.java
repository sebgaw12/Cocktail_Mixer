package pl.coderslab.cocktailMixer.repository.otherIngredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.cocktailMixer.model.RecipeOtherIngredients;

@Repository
public interface OiRecipeRepository extends JpaRepository<RecipeOtherIngredients, Long> {

}
