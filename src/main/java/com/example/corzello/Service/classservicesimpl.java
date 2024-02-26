package com.example.corzello.Service;

import com.example.corzello.Entity.Classe;
import com.example.corzello.Repository.Iclassrepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class classservicesimpl implements IclassService{

    @Autowired
    Iclassrepo iclassrepo;


    @Override
    public Classe ajouterclass(Classe cm ) {
        return iclassrepo.save(cm);
    }



    @Override
    public List<Classe> retrieveAll() {
        return iclassrepo.findAll();
    }

    @Override
    public void removeclass(int idclass) {
        iclassrepo.deleteById(idclass);
    }

    @Override
    public Classe getclass(int idclass) {
        return iclassrepo.findById(idclass).orElse(null);
    }

    @Override
    public Classe updateclassManagement(Classe cm) {
        return iclassrepo.save(cm);
    }

}