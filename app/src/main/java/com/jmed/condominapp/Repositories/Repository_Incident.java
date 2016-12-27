package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Incident;

import java.util.ArrayList;

public class Repository_Incident extends ArrayList<Pojo_Incident> {
    private static Repository_Incident instance;

    static Repository_Incident getInstance() {
        if (instance == null) {
            instance = new Repository_Incident();
        }
        return instance;
    }

    private Repository_Incident() {

    }
}
