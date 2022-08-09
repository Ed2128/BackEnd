
package com.portfolio.proyectointegrador.Controller;

import com.portfolio.proyectointegrador.Entity.Person;
import com.portfolio.proyectointegrador.Interface.IntPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    @Autowired IntPersonService intpersonService;
    
    @GetMapping("persons/traer/perfil")
    public List<Person> getPerson(){
        return intpersonService.getPerson();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/persons/crear")
    public String createPerson(@RequestBody Person person){
        intpersonService.savePerson(person);
        return "La persona ha sido creada correctamente.";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/persons/borrar/{id}")
    public String deletePerson(@PathVariable Long id){
        intpersonService.deletePerson(id);
        return "La persona ha sido eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/persons/editar/{id}")
    public Person editPerson(@PathVariable Long id,
            @RequestParam("nombre") String nuevoNombre,
            @RequestParam("apellido") String nuevoApellido,
            @RequestParam("img") String nuevoImg){
        
        Person person = intpersonService.findPerson(id);
        
        person.setNombre(nuevoNombre);
        person.setApellido(nuevoApellido);
        person.setImg(nuevoImg);
        
        intpersonService.savePerson(person);
        return person;
    }
        
 
}

