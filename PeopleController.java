package com.example.crud_persona.Controllers;

import com.example.crud_persona.DAO.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/all") //ПРОБЛЕМА!Не показывает всех людей
    public String index(Model model) { //получим всех людей из ДАО и передадим на отображение в представление
        model.addAttribute("personas", personDAO.index());
        return "/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id,Model model) { //получим одного человека из ДАО по айди и передадим на отображение в представление
        model.addAttribute("person",personDAO.show(id));
        return "/show";
    }
}
