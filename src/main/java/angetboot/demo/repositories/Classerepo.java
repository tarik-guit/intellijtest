package angetboot.demo.repositories;

import angetboot.demo.antities.Classe;
import angetboot.demo.antities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


public interface Classerepo extends JpaRepository<Classe,Long> {

    @Query("SELECT n FROM Classe  n WHERE n.ecole.id = :ide and n.niveau.id= :idn")
    List<Classe> findclasses(@Param("ide") Long ide,@Param("idn") Long idn);

}
