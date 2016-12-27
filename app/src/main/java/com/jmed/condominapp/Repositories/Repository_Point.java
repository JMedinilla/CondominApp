package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Point;

import java.util.ArrayList;

public class Repository_Point extends ArrayList<Pojo_Point> {
    private static Repository_Point instance;

    static Repository_Point getInstance() {
        if (instance == null) {
            instance = new Repository_Point();
        }
        return instance;
    }

    private Repository_Point() {

    }
}
