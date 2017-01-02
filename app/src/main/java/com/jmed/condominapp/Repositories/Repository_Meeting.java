package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Repository_Meeting extends ArrayList<Pojo_Meeting> {
    private static Repository_Meeting instance;

    static Repository_Meeting getInstance() {
        if (instance == null) {
            instance = new Repository_Meeting();
        }
        return instance;
    }

    private Repository_Meeting() {
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 4, 4);
        GregorianCalendar calendar_2 = new GregorianCalendar(2015, 5, 16);

        add(new Pojo_Meeting(0, 99, new Date(calendar_1.getTimeInMillis())));
        add(new Pojo_Meeting(1, 99, new Date(calendar_2.getTimeInMillis())));
    }

    public List<Pojo_Meeting> getMeetings() {
        return this;
    }
}
