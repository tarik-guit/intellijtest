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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Note extends auditingclasse<String>  implements Serializable {
    @Id
    @GeneratedValue
    private  Long id;
    @Column
    private  float note;
    @Column
     private String remarque;
    @JsonIgnore
    @ManyToOne(optional = true)
     private  Matiere matiere;
    @JsonIgnore
    @ManyToOne(optional = true)
    private  Etudiant etudiant;

}
