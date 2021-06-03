package pl.coderslab.cocktailMixer.repository.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.cocktailMixer.model.RecipeAlcohol;

@Repository
public interface AlcoholRecipeRepository extends JpaRepository<RecipeAlcohol, Long> {

    RecipeAlcohol findByRecipeId(long id);

}
