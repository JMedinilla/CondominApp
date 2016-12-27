package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Document;

import java.util.ArrayList;

public class Repository_Document extends ArrayList<Pojo_Document> {
    private static Repository_Document instance;

    static Repository_Document getInstance() {
        if (instance == null) {
            instance = new Repository_Document();
        }
        return instance;
    }

    private Repository_Document() {

    }
}
