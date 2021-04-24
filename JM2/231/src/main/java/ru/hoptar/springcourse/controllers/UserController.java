package ru.hoptar.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.hoptar.springcourse.entity.User;
import ru.hoptar.springcourse.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAll(Model model) {
        model.addAttribute("allUsers", userService.getAll());
        return "user/showAll";
    }

    @GetMapping("/{id}/show")
    public String showUser(Model model, @PathVariable(value = "id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "user/showUser";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "user/newUser";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/editUser";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user) {
        userService.editUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
