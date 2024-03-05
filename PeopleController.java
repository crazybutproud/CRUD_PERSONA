package com.example.crud_persona.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping()
    public String index(Model model) { //получим всех людей из ДАО и передадим на отображение в представление

        return null;
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model) { //получим одного человека из ДАО по айди и передадим на отображение в представление

        return null;
    }
}
