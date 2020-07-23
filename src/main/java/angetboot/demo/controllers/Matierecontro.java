package angetboot.demo.controllers;


import angetboot.demo.antities.*;
import angetboot.demo.repositories.Ecolerepo;
import angetboot.demo.repositories.Etudiantrepo;
import angetboot.demo.repositories.Matiererepo;
import angetboot.demo.repositories.Niveaurepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class Matierecontro {

    @Autowired
    private Matiererepo rep;
    @Autowired
    private Niveaurepo repn;
    @Autowired
    private Ecolerepo repe;

    @GetMapping("/matieres")
    public List<Matiere> getall() {
        return rep.findAll();
    }

    @GetMapping("/matiere/{id}")
    public Optional<Matiere> getbyid(@PathVariable Long id) {
        return rep.findById(id);
    }

    @DeleteMapping("/matieres")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";
    }

    @DeleteMapping("/matiere/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/matiere")
    public Matiere creeretudiant(@RequestBody Matiere matiere) {
        return rep.save(matiere);

    }

    @PutMapping("/matiere/{id}")
    public Matiere updatematiere(@PathVariable Long id, @RequestBody Matiere mat) {
        Matiere matiere = rep.findById(id).get();
        if (mat.getNom() != null) {
            matiere.setNom(mat.getNom());
        }
        if (mat.getCoefficient() != null) {
            matiere.setCoefficient(mat.getCoefficient());
        }
        if (mat.getEtudiants() != null) {
            matiere.setEtudiants(mat.getEtudiants());
        }
        if (mat.getNiveau() != null) {
            matiere.setNiveau(mat.getNiveau());
        }
        if (mat.getNotes() != null) {
            matiere.setNotes(mat.getNotes());
        }
        if (mat.getEcole() != null) {
            matiere.setEcole(mat.getEcole());
        }


        return rep.save(matiere);

    }

    @PostMapping("/matierewithecoleetniveau/{ide}/{idn}")
    public Matiere addecoletomatiere(@PathVariable Long ide,@PathVariable Long idn,@RequestBody Matiere matiere){
        Niveau niveau = repn.findById(idn).get();
        matiere.setNiveau(niveau);
        Ecole ecole = repe.findById(ide).get();
        matiere.setEcole(ecole);
        return rep.save(matiere);

    }

    @GetMapping("/matieres/{ide}/{idn}")
    public List<Matiere> findmatieres(@PathVariable Long ide,@PathVariable Long idn) {
        return rep.findmatieres(ide,idn);
    }


}