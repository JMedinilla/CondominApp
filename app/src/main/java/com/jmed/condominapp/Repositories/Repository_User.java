package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_User;

import java.util.ArrayList;

public class Repository_User extends ArrayList<Pojo_User> {
    private static Repository_User instance;

    static Repository_User getInstance() {
        if (instance == null) {
            instance = new Repository_User();
        }
        return instance;
    }

    private Repository_User() {

    }
}
