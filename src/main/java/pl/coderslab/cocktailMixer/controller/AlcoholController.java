package pl.coderslab.cocktailMixer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.cocktailMixer.model.Alcohol;
import pl.coderslab.cocktailMixer.repository.alcohol.AlcoholRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/alcohol")
@RequiredArgsConstructor
public class AlcoholController {

    private final AlcoholRepository alcoholRepository;

    @GetMapping("/list")
    public String alcoList(Model model){
        model.addAttribute("alcohols", alcoholRepository.findAll());
        return "app/alcohol/list";
    }

    @GetMapping("/add")
    public String addAlcohol(Model model){
        model.addAttribute("alcohol", new Alcohol());
        return "app/alcohol/addAlcohol";
    }

    @PostMapping("/add")
    public String saveAlcohol (@Valid Alcohol alcohol, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "app/alcohol/addAlcohol";
        }
        alcohol.setName(alcohol.getName());
        alcohol.setDescription(alcohol.getDescription());
        alcohol.setAbv(alcohol.getAbv());
        alcoholRepository.save(alcohol);
        return "redirect:/alcohol/list";
    }
}
