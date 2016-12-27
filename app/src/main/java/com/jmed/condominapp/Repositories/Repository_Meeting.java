package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Meeting;

import java.util.ArrayList;

public class Repository_Meeting extends ArrayList<Pojo_Meeting> {
    private static Repository_Meeting instance;

    static Repository_Meeting getInstance() {
        if (instance == null) {
            instance = new Repository_Meeting();
        }
        return instance;
    }

    private Repository_Meeting() {

    }
}
