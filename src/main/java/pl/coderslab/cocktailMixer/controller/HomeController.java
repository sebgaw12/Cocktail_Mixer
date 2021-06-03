package pl.coderslab.cocktailMixer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.cocktailMixer.model.User;
import pl.coderslab.cocktailMixer.repository.user.UserRepository;
import pl.coderslab.cocktailMixer.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("")
    public String home(){
        return "homepage";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "app/register";
    }

    @PostMapping("/register")
    public String save(@Valid User user, BindingResult result){
        if (result.hasErrors()){
            return "app/register";
        }
        user.setUsername(user.getUsername());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        userService.saveUser(user);
        return "redirect:login";
    }

    @GetMapping("/login")
    public String loginForm(){
       return "redirect:/recipe/list";
    }
}
