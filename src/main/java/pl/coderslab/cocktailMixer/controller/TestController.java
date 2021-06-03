package pl.coderslab.cocktailMixer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.cocktailMixer.model.RecipeAlcohol;

@Controller
public class TestController {

    @RequestMapping("/test")
    public String home(){ return "testHomepage"; }

}
