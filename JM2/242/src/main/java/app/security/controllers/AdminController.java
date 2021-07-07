package app.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import app.security.service.UserService;
import app.security.model.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAll());
        return "user/showAll";
    }
    @GetMapping("/{id}/show")
    public String showUser(Model model, @PathVariable(value = "id") long id){
        model.addAttribute("user", userService.getUser(id));
        return "user/showUser";
    }

    @GetMapping("/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "user/newUser";
    }
    @PostMapping("")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        return "user/editUser";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") User user){
        userService.editUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String removeUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
