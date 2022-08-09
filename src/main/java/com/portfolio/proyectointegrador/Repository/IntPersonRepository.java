
package com.portfolio.proyectointegrador.Repository;

import com.portfolio.proyectointegrador.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IntPersonRepository extends JpaRepository<Person,Long> {
    
}
