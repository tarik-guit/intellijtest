package angetboot.demo.antities;

import angetboot.demo.jpa_auditing.auditingclasse;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Ecole extends auditingclasse<String> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nom;
    @Column
    private  String address;
    @Column
    private String info;
    @JsonIgnore
    @OneToMany(mappedBy = "ecole")
    private Set<Etudiant> etudiants=new HashSet<Etudiant>(0);
    @JsonIgnore
    @OneToMany(mappedBy = "ecole")
    private Set<Classe> classes=new HashSet<Classe>(0);
    @JsonIgnore
    @OneToMany(mappedBy = "ecole")
    private Set<Niveau> niveaux=new HashSet<Niveau>(0);
    @JsonIgnore
    @OneToMany(mappedBy = "ecole")
    private Set<Matiere> matieres=new HashSet<Matiere>(0);

}
