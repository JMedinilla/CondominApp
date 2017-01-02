package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Repository_Note extends ArrayList<Pojo_Note> {
    private static Repository_Note instance;

    public static Repository_Note getInstance() {
        if (instance == null) {
            instance = new Repository_Note();
        }
        return instance;
    }

    private Repository_Note() {
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 3, 1);
        GregorianCalendar calendar_2 = new GregorianCalendar(2016, 3, 5);
        GregorianCalendar calendar_3 = new GregorianCalendar(2016, 3, 13);
        GregorianCalendar calendar_4 = new GregorianCalendar(2016, 3, 26);

        add(new Pojo_Note(99, new Date(calendar_1.getTimeInMillis()), "titulo 1", "contenido 1"));
        add(new Pojo_Note(99, new Date(calendar_2.getTimeInMillis()), "titulo 2", "contenido 2"));
        add(new Pojo_Note(99, new Date(calendar_3.getTimeInMillis()), "titulo 3", "contenido 3"));
        add(new Pojo_Note(99, new Date(calendar_4.getTimeInMillis()), "titulo 4", "contenido 4"));
    }

    public List<Pojo_Note> getNotes() {
        return this;
    }
}
