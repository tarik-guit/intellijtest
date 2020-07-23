package angetboot.demo.services;

import angetboot.demo.antities.Niveau;
import angetboot.demo.repositories.Niveaurepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class serviceimpl implements service {
   @Autowired
   private Niveaurepo repn;

    @Override
    public Niveau getniveaubyid(Long id) {
        return  repn.findById(id).get();
    }
}
