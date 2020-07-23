package angetboot.demo.securitymodels.repositories;

import angetboot.demo.securitymodels.ERole;
import angetboot.demo.securitymodels.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Rolerepo extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);
}
