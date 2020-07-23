package angetboot.demo.controllers;

import angetboot.demo.antities.*;
import angetboot.demo.repositories.Classerepo;
import angetboot.demo.repositories.Ecolerepo;
import angetboot.demo.repositories.Etudiantrepo;
import angetboot.demo.repositories.Niveaurepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class Niveaucontro {
    @Autowired
    private Niveaurepo rep;
    @Autowired
    private Ecolerepo repe;
    @Autowired
    private Classerepo repc;

    @GetMapping("/niveaux")
    public List<Niveau> getall() {
        return rep.findAll();
    }

    @GetMapping("/niveau/{id}")
    public Optional<Niveau> getbyid(@PathVariable Long id) {
        return rep.findById(id);
    }

    @DeleteMapping("/niveaux")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";
    }

    @DeleteMapping("/niveau/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/niveau")
    public Niveau creerniveau(@RequestBody Niveau niveau) {
        return rep.save(niveau);

    }

    @PutMapping("/niveau/{id}")
    public Niveau updateniveau(@PathVariable Long id, @RequestBody Niveau niv) {
        Niveau niveau = rep.findById(id).get();
        if (niv.getNom() != null) {
            niveau.setNom(niv.getNom());
        }
        if (niv.getNemeannee() != niveau.getNemeannee()) {
            niveau.setNemeannee(niv.getNemeannee());
        }
        if (niv.getMatieres() != null) {
            niveau.setMatieres(niv.getMatieres());
        }
        if (niv.getEtudiants() != null) {
            niveau.setEtudiants(niv.getEtudiants());
        }
        if (niv.getClasses() != null) {
            niveau.setClasses(niv.getClasses());
        }

        if (niv.getEcole() != null) {
            niv.setEcole(niv.getEcole());
        }

        return rep.save(niveau);
    }

    @PostMapping("/niveauwithecole/{ide}")
    public Niveau addecoletoclasse(@PathVariable Long ide, @RequestBody Niveau niveau) {

        Ecole ecole = repe.findById(ide).get();
        niveau.setEcole(ecole);
        return rep.save(niveau);

    }

    @GetMapping("/niveaux/{ide}")
    public List<Niveau> getallniveaupourecole(@PathVariable Long ide) {
     return  rep.findniveaux(ide);

    }



}