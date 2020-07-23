package angetboot.demo.controllers;

import angetboot.demo.antities.Classe;
import angetboot.demo.antities.Ecole;
import angetboot.demo.repositories.Classerepo;
import angetboot.demo.repositories.Ecolerepo;
import angetboot.demo.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class Ecolecontro  {

    @Autowired
    public AuthController controller;
    @Autowired
    private Ecolerepo rep;



    @GetMapping("/ecole/{id}")
    public Optional<Ecole> getbyid(@PathVariable Long id) {
        return rep.findById(id);
    }

    @DeleteMapping("/ecoles")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";

    }

    @DeleteMapping("/ecole/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/ecole")
    public Ecole creerecole(@RequestBody Ecole ecole) {
        return rep.save(ecole);

    }
    @PutMapping("/ecole/{id}")
    public Ecole updateecole(@PathVariable Long id, @RequestBody Ecole cla) {
        Ecole ecole= rep.findById(id).get();
        if (cla.getNom() != null) {
            ecole.setNom(cla.getNom());
        }
        if (cla.getEtudiants() != null) {
            ecole.setEtudiants(cla.getEtudiants());
        }
        if (cla.getClasses() != null) {
            ecole.setClasses(cla.getClasses());
        }
        if (cla.getInfo() != null) {
            ecole.setInfo(cla.getInfo());
        }
        if (cla.getAddress() != null) {
            ecole.setAddress(cla.getAddress());
        }
        if (cla.getNiveaux() != null) {
            ecole.setNiveaux(cla.getNiveaux());
        }
        if (cla.getMatieres()!= null) {
            ecole.setMatieres(cla.getMatieres());
        }
        return rep.save(ecole);
    }

    @GetMapping("/ecoles")

    public List<Ecole> getall() {
        return rep.getall(controller.username);
    }

}
