package ru.hoptar.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Calc {
    private final String wrong = "you input some crap";
    private final String page = "/yet/calc";
    int a;
    int b;

    @GetMapping("/calc")
    public String calc(@RequestParam(value = "a", required = false) String inp1,
                         @RequestParam(value = "b", required = false) String inp2,
                         @RequestParam(value = "action", required = false) String action,
                         Model model) {
        double result;

        try {
            a = Integer.parseInt(inp1);
            b = Integer.parseInt(inp2);
        } catch (NumberFormatException e) {
            model.addAttribute("result", wrong);
            return page;
        }

        switch (action) {
            case "*":
                result = a * b;
                break;
            case "/":
                if (b != 0) {
                    result = a / (double) b;
                    break;
                } else {
                    model.addAttribute("result", wrong);
                    return page;
                }
            case "plus":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            default:
                model.addAttribute("result", wrong);
                return page;
        }

        model.addAttribute("result", result);

        return page;
    }


}
