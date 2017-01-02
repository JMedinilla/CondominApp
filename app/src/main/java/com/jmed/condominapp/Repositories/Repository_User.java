package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_User;

import java.util.ArrayList;
import java.util.List;

public class Repository_User extends ArrayList<Pojo_User> {
    private static Repository_User instance;

    public static Repository_User getInstance() {
        if (instance == null) {
            instance = new Repository_User();
        }
        return instance;
    }

    private Repository_User() {
        add(new Pojo_User("123456", 99, "1", "A", "656565656", "mail@mail.com", "Javier Medinilla", Pojo_User.PRESIDENT));
    }

    public List<Pojo_User> getUsers() {
        return this;
    }
}
