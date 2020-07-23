package angetboot.demo.antities;


import angetboot.demo.jpa_auditing.auditingclasse;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Niveau extends auditingclasse<String> implements Serializable {
    @Id
    @GeneratedValue
    private  Long id;
    @Column
    private String nom;
    @Column
    private Long nemeannee;
    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private Set<Matiere> matieres=new HashSet<Matiere>(0);
    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private Set<Etudiant> etudiants=new HashSet<Etudiant>(0);
    @JsonIgnore
    @OneToMany(mappedBy = "niveau")
    private Set<Classe> classes=new HashSet<Classe>(0);
    @JsonIgnore
    @ManyToOne(optional = true)
    private Ecole ecole;
}
