package angetboot.demo.antities;



import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import angetboot.demo.jpa_auditing.auditingclasse;
import angetboot.demo.securitycontroller.AuthController;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Etudiant  extends auditingclasse<String>  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String nom;
    @Column
    private String prenom;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Niveau niveau;
    @JsonIgnore
    @ManyToMany
    private Set<Matiere> matieres=new HashSet<Matiere>(0);
    private float notefinale;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Classe classe;
    @JsonIgnore
    @ManyToOne(optional = true)
    private Ecole ecole;
    @JsonIgnore
    @OneToMany(mappedBy = "etudiant")
    private Set<Note> notes=new HashSet<Note>(0);





}
