package pl.coderslab.cocktailMixer.repository.otherIngredients;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.cocktailMixer.model.OtherIngredients;

@Repository
public interface OtherIngredientsRepository extends JpaRepository<OtherIngredients, Long> {

}
