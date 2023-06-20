package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // dichiara che è una classe controller
@RequestMapping("/") //rotta a cui rispondono i controller, a questa rotta risponderanno i seguenti metodi
public class IndexController {

    @GetMapping //risponde a richieste di tipo get
    public String home (Model model){ //invoco metodo model per creare oggetti da mandare insieme al return
        model.addAttribute("name", "Carlo");
        return "index"; // nome del template da rimandare
    }
}
