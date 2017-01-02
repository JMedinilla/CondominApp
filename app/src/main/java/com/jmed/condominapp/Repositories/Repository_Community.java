package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Community;

import java.util.ArrayList;
import java.util.List;

public class Repository_Community extends ArrayList<Pojo_Community> {
    private static Repository_Community instance;

    public static Repository_Community getInstance() {
        if (instance == null) {
            instance = new Repository_Community();
        }
        return instance;
    }

    private Repository_Community() {
        add(new Pojo_Community(99, "Málaga", "Málaga", "Calle Falsa",
                "1", "-", "29114", 12, "Eliseo Moreno", "Calle de mentira, 2, 3B",
                "656565656", "eliseo@gmail.com", "Sebastián Millán", "747474747"));
    }

    public List<Pojo_Community> getCommunities() {
        return this;
    }
}
