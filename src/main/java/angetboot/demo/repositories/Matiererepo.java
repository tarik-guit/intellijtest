package angetboot.demo.repositories;

import angetboot.demo.antities.Classe;
import angetboot.demo.antities.Matiere;
import angetboot.demo.antities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Matiererepo extends JpaRepository<Matiere,Long> {
    @Query("SELECT n FROM Matiere  n WHERE n.ecole.id = :ide and n.niveau.id= :idn")
    List<Matiere> findmatieres(@Param("ide") Long ide, @Param("idn") Long idn);

}
