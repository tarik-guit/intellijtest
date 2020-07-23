package angetboot.demo.controllers;

import angetboot.demo.antities.*;
import angetboot.demo.repositories.Classerepo;
import angetboot.demo.repositories.Ecolerepo;
import angetboot.demo.repositories.Etudiantrepo;
import angetboot.demo.repositories.Niveaurepo;
import angetboot.demo.securitycontroller.AuthController;
import angetboot.demo.services.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class Classecontro {
    @Autowired
    private AuthController controller;
    @Autowired
    private Classerepo rep;
    @Autowired
    private Niveaurepo repn;
    @Autowired
    private Ecolerepo repe;
    @Autowired
    private service service;

    @GetMapping("/classes")
    public List<Classe> getall() {
        return rep.findAll();
    }

    @GetMapping("/classe/{id}")
    public Optional<Classe> getbyid(@PathVariable Long id) {
        return rep.findById(id);
    }

    @DeleteMapping("/classes")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";
    }

    @DeleteMapping("/classe/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/classe")
    public Classe creerclasse(@RequestBody Classe classe) {
        return rep.save(classe);

    }
    @PutMapping("/classe/{id}")
    public Classe updateetudiant(@PathVariable Long id, @RequestBody Classe cla) {
        Classe classe= rep.findById(id).get();
        if (cla.getNom() != null) {
            classe.setNom(cla.getNom());
        }
        if (cla.getEtudiants() != null) {
            classe.setEtudiants(cla.getEtudiants());
        }
        if (cla.getNiveau() != null) {
            classe.setNiveau(cla.getNiveau());
        }
        if (cla.getEcole() != null) {
            classe.setEcole(cla.getEcole());
        }

        return rep.save(classe);
    }





    @PostMapping("/classewithecoleetniveau/{ide}/{idn}")
    public Classe addecoletoclasse(@PathVariable Long ide,@PathVariable Long idn,@RequestBody Classe classe){
        Niveau niveau= repn.findById(idn).get();
        Ecole ecole = repe.findById(ide).get();
        classe.setNiveau(niveau);
        classe.setEcole(ecole);
        return rep.save(classe);

    }

    @GetMapping("/classes/{ide}/{idn}")
    public List<Classe> findclasses(@PathVariable Long ide,@PathVariable Long idn) {
        return rep.findclasses(ide,idn);
    }


    @GetMapping("/username")
    public username username(){
        return new username(controller.username);
  }
}