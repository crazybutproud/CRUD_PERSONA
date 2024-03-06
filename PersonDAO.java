package com.example.crud_persona.DAO;

import com.example.crud_persona.Models.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Persona> personas;
    {
        personas = new ArrayList<>();
        personas.add(new Persona(1,"Tom"));
        personas.add(new Persona(2,"Mik"));
        personas.add(new Persona(3,"Lilo"));
        personas.add(new Persona(4,"Tim"));
        personas.add(new Persona(5,"Kiko"));
    }
    public List<Persona> index() {
        return personas;
    }

    public Persona show(int id) {
        return personas.stream().filter(persona -> persona.getId() == id).findAny().orElse(null);
    }
}
