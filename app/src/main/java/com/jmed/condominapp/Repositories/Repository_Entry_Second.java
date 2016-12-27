package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Entry;

import java.util.ArrayList;

public class Repository_Entry_Second extends ArrayList<Pojo_Entry> {
    private static Repository_Entry_Second instance;

    static Repository_Entry_Second getInstance() {
        if (instance == null) {
            instance = new Repository_Entry_Second();
        }
        return instance;
    }

    private Repository_Entry_Second() {

    }
}
