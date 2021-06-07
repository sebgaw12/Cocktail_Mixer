package pl.coderslab.cocktailMixer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.cocktailMixer.model.Recipe;
import pl.coderslab.cocktailMixer.model.RecipeAlcohol;
import pl.coderslab.cocktailMixer.model.RecipeOtherIngredients;
import pl.coderslab.cocktailMixer.repository.alcohol.AlcoholRecipeRepository;
import pl.coderslab.cocktailMixer.repository.alcohol.AlcoholRepository;
import pl.coderslab.cocktailMixer.repository.otherIngredients.OiRecipeRepository;
import pl.coderslab.cocktailMixer.repository.recipe.RecipeRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final AlcoholRepository alcoholRepository;
    private final AlcoholRecipeRepository alcoholRecipeRepository;
    private final OiRecipeRepository oiRecipeRepository;

    @GetMapping("/list")
    public String recipeList(Model model) {
        model.addAttribute("recipes", recipeRepository.findAll());
        return "app/recipe/list";
    }

    @GetMapping("/details/{id}")
    public String recipeDetails(Model model, @PathVariable long id) {
        model.addAttribute("recipe", recipeRepository.findById(id));
        model.addAttribute("recipeAlcohols", alcoholRecipeRepository.findByRecipeId(id));
        return "app/recipe/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("recipe", recipeRepository.findById(id));
        return "/recipe/update";
    }

    @PostMapping("/update")
    public String update(Recipe recipe) {
        recipeRepository.save(recipe);
        return "redirect:list";
    }

    @GetMapping("/addRecipe")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "app/recipe/addRecipe";
    }

    @PostMapping("/addRecipe")
    public String create(@Valid Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "app/recipe/addRecipe";
        }
        recipe.setName(recipe.getName());
        recipe.setDescription(recipe.getDescription());
        recipe.setVolume(recipe.getVolume());
        recipeRepository.save(recipe);
        return "redirect:addAlcohol" + recipe.getId() ;
    }

    @GetMapping("/addAlcohol/{id}")
    public String addAlcohol(Model model, @PathVariable long id){
        RecipeAlcohol recipeAlcohol = new RecipeAlcohol();
        Recipe byId = recipeRepository.findById(id);
        recipeAlcohol.setRecipe(byId);
        model.addAttribute(recipeAlcohol);
        model.addAttribute("alcohols", alcoholRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "/app/recipe/addAlcoToRecipe";
    }

    @PostMapping("/saveAlcohol")
    public String saveAlcohol(RecipeAlcohol recipeAlcohol) {

        recipeAlcohol.setVolumeAdd(recipeAlcohol.getVolumeAdd());
        recipeAlcohol.setType(recipeAlcohol.getType());
        recipeAlcohol.setAlcohol(recipeAlcohol.getAlcohol());
        recipeAlcohol.setRecipe(recipeAlcohol.getRecipe());
        alcoholRecipeRepository.save(recipeAlcohol);
        return "redirect:addOI";
    }

    @GetMapping("/addOI")
    public String addOI(Model model){

        model.addAttribute(new RecipeOtherIngredients());
        model.addAttribute("otherIngredients", oiRecipeRepository.findAll());
        model.addAttribute("recipes", recipeRepository.findAll());
        return "app/recipe/addOItoRecipe";
    }

    @PostMapping("/addOI")
    public String saveOI(RecipeOtherIngredients recipeOtherIngredients){

        recipeOtherIngredients.setOtherIngredient(recipeOtherIngredients.getOtherIngredient());
        recipeOtherIngredients.setVolumeAdd(recipeOtherIngredients.getVolumeAdd());
        recipeOtherIngredients.setType(recipeOtherIngredients.getType());
        oiRecipeRepository.save(recipeOtherIngredients);
        return "redirect:list";
    }
}
