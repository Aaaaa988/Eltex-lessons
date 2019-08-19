package ru.kiselev;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Vladimir");
        model.addAttribute("user", new User(1, "Egnat", "+73458645464"));
        return "index";
    }
}
