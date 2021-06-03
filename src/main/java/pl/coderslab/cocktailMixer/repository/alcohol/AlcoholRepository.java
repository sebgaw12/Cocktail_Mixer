package pl.coderslab.cocktailMixer.repository.alcohol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.cocktailMixer.model.Alcohol;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

}
