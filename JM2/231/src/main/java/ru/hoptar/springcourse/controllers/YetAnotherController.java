package ru.hoptar.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class YetAnotherController {
    @GetMapping("/exit")
    public String exit(@RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "surname", required = false) String surname,
                       Model model) {
        model.addAttribute("message", "Hey, " + name + " " + surname + "!");

        return ("yet/exit");
    }
}
