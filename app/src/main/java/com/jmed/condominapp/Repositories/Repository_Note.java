package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Note;

import java.util.ArrayList;

public class Repository_Note extends ArrayList<Pojo_Note> {
    private static Repository_Note instance;

    static Repository_Note getInstance() {
        if (instance == null) {
            instance = new Repository_Note();
        }
        return instance;
    }

    private Repository_Note() {

    }
}
