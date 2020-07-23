package angetboot.demo.repositories;

import angetboot.demo.antities.Etudiant;
import angetboot.demo.antities.Matiere;
import angetboot.demo.antities.Niveau;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Etudiantrepo extends JpaRepository<Etudiant,Long> {
    @Query("SELECT n FROM Etudiant  n WHERE n.ecole.id = :ide and n.niveau.id= :idn and n.classe.id= :idc")
    List<Etudiant> findetudiants(@Param("ide") Long ide, @Param("idn") Long idn,@Param("idc") Long idc);

}
