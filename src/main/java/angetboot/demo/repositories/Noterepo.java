package angetboot.demo.repositories;

import angetboot.demo.antities.Etudiant;
import angetboot.demo.antities.Note;
import angetboot.demo.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Noterepo extends JpaRepository<Note,Long> {



    @Query("SELECT n FROM Note  n WHERE n.etudiant.id = :ide and n.matiere.id= :idm and n.createdby= :username")
    List<Note> findnotes(@Param("ide") Long ide, @Param("idm") Long idm,@Param("username") String username);
}
