package com.example.corzello.Service;

import com.example.corzello.Entity.Classe;

import java.util.List;

public interface IclassService {
    public Classe ajouterclass(Classe cm );
    public List<Classe> retrieveAll();
    public void removeclass(int idclass);


    Classe getclass(int idclass );
    public Classe updateclassManagement(Classe cm);
}
