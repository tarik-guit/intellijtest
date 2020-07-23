package angetboot.demo.jpa_auditing;

import angetboot.demo.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class Auditor implements AuditorAware<String> {

    @Autowired
    private AuthController controller;
    @Override
    public Optional<String> getCurrentAuditor(){
        return Optional.of(controller.username);
    }
}
