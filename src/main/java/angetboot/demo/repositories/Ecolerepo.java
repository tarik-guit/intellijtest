package angetboot.demo.repositories;

import angetboot.demo.antities.Classe;
import angetboot.demo.antities.Ecole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface Ecolerepo extends JpaRepository<Ecole,Long> {
    @Query("SELECT n FROM Ecole  n WHERE n.createdby=:username")
    List<Ecole> getall(@Param("username") String username );

}
