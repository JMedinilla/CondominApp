package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Document;

import java.util.ArrayList;
import java.util.List;

public class Repository_Document extends ArrayList<Pojo_Document> {
    private static Repository_Document instance;

    static Repository_Document getInstance() {
        if (instance == null) {
            instance = new Repository_Document();
        }
        return instance;
    }

    private Repository_Document() {
        add(new Pojo_Document(99, "title 1", "content 1", "url 1"));
        add(new Pojo_Document(99, "title 2", "content 2", "url 2"));
        add(new Pojo_Document(99, "title 3", "content 3", "url 3"));
        add(new Pojo_Document(99, "title 4", "content 4", "url 4"));
        add(new Pojo_Document(99, "title 5", "content 5", "url 5"));
    }

    public List<Pojo_Document> getDocuments() {
        return this;
    }
}
