package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class Car {

    @GetMapping(value = "/cars/car")
    public String car(@RequestParam(value = "name") String name,
                    @RequestParam(value = "color") String color,
                    @RequestParam(value = "age") int age,
                    Model model){
        model.addAttribute("car", "Car model: " + name + ";\n" +
                "color: " + color + ";\n" + "age: " + age + ".");
        return "car";
    }

    @GetMapping(value = "/cars")
    public String cars (@RequestParam(value = "count", required = false) Integer count,
                        Model model) {
        String[] carsList = new String[] {"Ford", "Honda", "Toyota", "Renault", "Lada"};

        if (count == null || count > 5) {
            model.addAttribute("carsList", carsList);
        } else {
            model.addAttribute("carsList", Arrays.stream(carsList).limit(count).toArray(String[]::new));
        }

        return "cars";
    }
}
