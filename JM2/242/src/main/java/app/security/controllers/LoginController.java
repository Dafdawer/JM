package app.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

//    @GetMapping(value = "/")
//    public String getHomePage() {
//        return "startPage";
//    }

    @GetMapping("/login") // ""?
    public String login(){
        return "login";
    }
}
