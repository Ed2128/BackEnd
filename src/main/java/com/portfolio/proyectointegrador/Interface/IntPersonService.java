
package com.portfolio.proyectointegrador.Interface;

import com.portfolio.proyectointegrador.Entity.Person;
import java.util.List;



public interface IntPersonService {
    // Lista de personas
    public List<Person> getPerson();
    
    // Guardar Persona
    public void savePerson(Person person);
    
    // Eliminar Persona por ID
    public void deletePerson(Long id);
    
    // Buscar persona por ID
    public Person findPerson(Long id);
}
