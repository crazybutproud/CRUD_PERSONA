package com.example.crud_persona.Controllers;

import com.example.crud_persona.DAO.PersonDAO;
import com.example.crud_persona.Models.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private final PersonDAO personDAO;

    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/all")
    public String index(Model model) { //получим всех людей из ДАО и передадим на отображение в представление
        model.addAttribute("personas", personDAO.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) { //получим одного человека из ДАО по айди и передадим на отображение в представление
        model.addAttribute("person", personDAO.show(id));
        return "show";
    }

    @GetMapping("/new")
    public String newPersona(Model model) { //возвращаем форму на добавление нового человека
        model.addAttribute("persona", new Persona());

        return "new";
    }

    @PostMapping()
    public String create(@ModelAttribute Persona persona) { //принимает данные и отправляет в базу данных
        personDAO.save(persona);
        return "redirect:/people/all";
    }
}
