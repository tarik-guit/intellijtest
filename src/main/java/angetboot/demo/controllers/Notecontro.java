package angetboot.demo.controllers;

import angetboot.demo.antities.*;
import angetboot.demo.repositories.Classerepo;
import angetboot.demo.repositories.Etudiantrepo;
import angetboot.demo.repositories.Matiererepo;
import angetboot.demo.repositories.Noterepo;
import angetboot.demo.securitycontroller.AuthController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
public class Notecontro {
    @Autowired
    public AuthController controller;
    @Autowired
    private Noterepo rep;
    @Autowired
    private Matiererepo repm;
    @Autowired
    private Etudiantrepo repet;

    @GetMapping("/notes")
    public List<Note> getall() {
        return rep.findAll();
    }

    @GetMapping("/note/{id}")
    public Optional<Note> getbyid(@PathVariable Long id) {
        return rep.findById(id);
    }

    @DeleteMapping("/notes")
    public String deleteall() {
        rep.deleteAll();
        return "supprimés";
    }

    @DeleteMapping("/note/{id}")
    public String deletbyid(@PathVariable Long id) {
        rep.deleteById(id);
        return "supprimé";
    }

    @PostMapping("/note")
    public Note creerclasse(@RequestBody Note note) {
        return rep.save(note);

    }
    @PutMapping("/note/{id}")
    public Note updateetudiant(@PathVariable Long id, @RequestBody Note cla) {
        Note note= rep.findById(id).get();
        if (cla.getNote() != note.getNote()) {
            note.setNote(cla.getNote());
        }
        if (cla.getRemarque() != null) {
            note.setNote(cla.getNote());
        }
        if (cla.getMatiere() != null) {
            note.setMatiere(cla.getMatiere());
        }
        if (cla.getEtudiant() != null) {
            note.setEtudiant(cla.getEtudiant());
        }

        return rep.save(note);
    }



    @PostMapping("/notewithmatiereetetudiant/{idm}/{ide}")
    public Note addmatieretonote(@PathVariable Long idm,@PathVariable Long ide,@RequestBody Note note){
        Etudiant etudiant = repet.findById(ide).get();
        note.setEtudiant(etudiant);
        Matiere matiere= repm.findById(idm).get();
        note.setMatiere(matiere);
        return rep.save(note);

    }

    @GetMapping("/notes/{ide}/{idm}")
    public List<Note> findnotes(@PathVariable Long ide,@PathVariable Long idm) {
        return rep.findnotes(ide,idm,controller.username);
    }
}
