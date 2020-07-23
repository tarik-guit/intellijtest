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
public class Etudiantcontro {

    @Autowired
    private Etudiantrepo rep;
    @Autowired
    private Niveaurepo repn;
    @Autowired
    private Classerepo repc;
    @Autowired
    private Ecolerepo repe;

@GetMapping("/etudiants")
    public List<Etudiant> getall(){
    return rep.findAll();
}

    @GetMapping("/etudiant/{id}")
    public Optional<Etudiant> getbyid(@PathVariable Long id){
        return rep.findById(id);
    }
  @DeleteMapping("/etudiants")
    public String deleteall(){
    rep.deleteAll();
    return "supprimés";
  }

    @DeleteMapping("/etudiant/{id}")
    public String deletbyid(@PathVariable Long id){
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/etudiant")
    public Etudiant creeretudiant(@RequestBody Etudiant etudiant){
        return rep.save(etudiant);

    }

    @PutMapping("/etudiant/{id}")
    public Etudiant updateetudiant(@PathVariable Long id,@RequestBody Etudiant etu) {
        Etudiant etudiant = rep.findById(id).get();
        if (etu.getNom() != null) {
            etudiant.setNom(etu.getNom());
        }
        if (etu.getPrenom() != null) {
            etudiant.setPrenom(etu.getPrenom());
        }
        if (etu.getNiveau() != null) {
            etudiant.setNiveau(etu.getNiveau());
        }
        if (etu.getMatieres() != null) {
            etudiant.setMatieres(etu.getMatieres());
        }
        if (etu.getNotefinale() != etudiant.getNotefinale()) {
            etudiant.setNotefinale(etu.getNotefinale());
        }
        if (etu.getClasse() != null) {
            etudiant.setClasse(etu.getClasse());
        }
        if (etu.getEcole() != null) {
            etudiant.setEcole(etu.getEcole());
        }
        if (etu.getNotes() != null) {
            etudiant.setNotes(etu.getNotes());
        }

        return rep.save(etudiant);
    }


    @PostMapping("/etudiantwithecoleetclasseetniveau/{ide}/{idc}/{idn}")
    public Etudiant addniveautoetudiant(@PathVariable Long idn,@PathVariable Long idc,@PathVariable Long ide,@RequestBody Etudiant etudiant){
        Classe classe  = repc.findById(idc).get();
        etudiant.setClasse(classe);
        Niveau niveau = repn.findById(idn).get();
        etudiant.setNiveau(niveau);
        Ecole ecole = repe.findById(ide).get();
        etudiant.setEcole(ecole);
        return rep.save(etudiant);

    }

    @GetMapping("/etudiants/{ide}/{idn}/{idc}")
    public List<Etudiant> findetudiants(@PathVariable Long ide,@PathVariable Long idn,@PathVariable Long idc) {
        return rep.findetudiants(ide,idn,idc);
    }



}
