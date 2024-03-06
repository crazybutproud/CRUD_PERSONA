package com.example.crud_persona.DAO;

import com.example.crud_persona.Models.Persona;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Persona> personas;
    private static int PEOPLE_COUNT;

    {
        personas = new ArrayList<>();
        personas.add(new Persona(++PEOPLE_COUNT, "Tom"));
        personas.add(new Persona(++PEOPLE_COUNT, "Mik"));
        personas.add(new Persona(++PEOPLE_COUNT, "Lilo"));
        personas.add(new Persona(++PEOPLE_COUNT, "Tim"));
        personas.add(new Persona(++PEOPLE_COUNT, "Kiko"));
    }

    public List<Persona> index() {
        return personas;
    }

    public Persona show(int id) {
        return personas.stream().filter(persona -> persona.getId() == id).findAny().orElse(null);
    }

    public void save(Persona persona) {
        persona.setId(++PEOPLE_COUNT);
        personas.add(persona);
    }
}
