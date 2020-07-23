package angetboot.demo.antities;

import angetboot.demo.jpa_auditing.auditingclasse;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Classe extends auditingclasse<String> implements Serializable {
    @Id
    @GeneratedValue
private Long id;
    @Column
private String nom;
    @JsonIgnore
@ManyToOne(optional = true)
private Niveau niveau;
    @JsonIgnore
@OneToMany(mappedBy = "classe")
private Set<Etudiant> etudiants=new HashSet<Etudiant>(0);
    @JsonIgnore
@ManyToOne(optional = true)
private Ecole     ecole;
}
