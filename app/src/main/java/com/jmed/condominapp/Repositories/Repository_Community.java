package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Community;

import java.util.ArrayList;

public class Repository_Community extends ArrayList<Pojo_Community> {
    private static Repository_Community instance;

    static Repository_Community getInstance() {
        if (instance == null) {
            instance = new Repository_Community();
        }
        return instance;
    }

    private Repository_Community() {
        add(new Pojo_Community(99, "locality", "municipality", "address",
                "number", "block", "postal", 12, "admin", "admin address",
                "admin phone", "admin mail", "president", "president phone"));
    }
}
