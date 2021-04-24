package ru.hoptar.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String helloPage() {
        return "home/hello";
    }

    @GetMapping("/bye")
    public String byePage() {
        return "home/bye";
    }
}
