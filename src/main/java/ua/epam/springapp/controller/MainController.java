package ua.epam.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @GetMapping("/")
    public ModelAndView getMainPage() {
        return new ModelAndView("index");
    }
}
