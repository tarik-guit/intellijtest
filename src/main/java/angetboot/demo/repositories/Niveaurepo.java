package angetboot.demo.repositories;

import angetboot.demo.antities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


public interface Niveaurepo extends JpaRepository<Niveau,Long> {
    @Query("SELECT n FROM Niveau  n WHERE n.ecole.id = :id")
    List<Niveau> findniveaux(@Param("id") Long id);
}
