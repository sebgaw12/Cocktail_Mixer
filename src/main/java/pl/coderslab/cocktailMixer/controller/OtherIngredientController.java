package pl.coderslab.cocktailMixer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.cocktailMixer.model.OtherIngredients;
import pl.coderslab.cocktailMixer.repository.otherIngredients.OtherIngredientsRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/otherIngredient")
@RequiredArgsConstructor
public class OtherIngredientController {

    private final OtherIngredientsRepository otherIngredientsRepository;

    @GetMapping("/list")
    public String listOI(Model model){
        model.addAttribute("otherIngredients", otherIngredientsRepository.findAll());
        return "app/otherIngredients/list";
    }

    @GetMapping("/add")
    public String addOI(Model model){
        model.addAttribute("otherIngredient", new OtherIngredients());
        return "app/otherIngredients/addOtherIngredient";
    }

    @PostMapping("/add")
    public String saveOI(@Valid OtherIngredients otherIngredients, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "app/otherIngredients/addOtherIngredient";
        }
        otherIngredients.setName(otherIngredients.getName());
        otherIngredients.setDescription(otherIngredients.getDescription());
        otherIngredientsRepository.save(otherIngredients);
        return "redirect:/otherIngredient/list";
    }
}
