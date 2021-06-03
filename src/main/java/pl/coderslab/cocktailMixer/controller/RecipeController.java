package pl.coderslab.cocktailMixer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.cocktailMixer.model.*;
import pl.coderslab.cocktailMixer.repository.alcohol.AlcoholRecipeRepository;
import pl.coderslab.cocktailMixer.repository.alcohol.AlcoholRepository;
import pl.coderslab.cocktailMixer.repository.otherIngredients.OtherIngredientsRepository;
import pl.coderslab.cocktailMixer.repository.recipe.RecipeRepository;
import pl.coderslab.cocktailMixer.repository.user.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeRepository recipeRepository;
    private final AlcoholRepository alcoholRepository;
    private final OtherIngredientsRepository otherIngredientsRepository;
    private final AlcoholRecipeRepository alcoholRecipeRepository;
    private final UserRepository userRepository;

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
        return "redirect:addAlcohol";
    }

    @GetMapping("/addAlcohol/{id}")
    public String addAlcoholToRecipe(Model model, @PathVariable long id){
        model.addAttribute(new RecipeAlcohol());
        model.addAttribute("alcohols", alcoholRepository.findAll());
        model.addAttribute(recipeRepository.findById(id));
        return "/app/recipe/addAlcoToRecipe";
    }

    @PostMapping("/addAlcohol")
    public String saveAlcoToRecipe(RecipeAlcohol recipeAlcohol) {

//        recipeAlcohol.setRecipe(recipeRepository.findById(recipeAlcohol.getId()));
        recipeAlcohol.setVolumeAdd(recipeAlcohol.getVolumeAdd());
        recipeAlcohol.setType(recipeAlcohol.getType());
        recipeAlcohol.setAlcohol(recipeAlcohol.getAlcohol());
        alcoholRecipeRepository.save(recipeAlcohol);
        return "redirect:addOI";
    }

    @GetMapping("/addOI/{id}")
    @ResponseBody
    public String addOI(@PathVariable long id){
        return String.valueOf(recipeRepository.findById(id));
    }
}
