package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Entry;
import com.jmed.condominapp.pojo.Pojo_User;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Repository_Entry_First extends ArrayList<Pojo_Entry> {
    private static Repository_Entry_First instance;

    public static Repository_Entry_First getInstance() {
        if (instance == null) {
            instance = new Repository_Entry_First();
        }
        return instance;
    }

    private Repository_Entry_First() {
        Pojo_User user1 = new Pojo_User("12", 99, "-", "-", "656565656", "eliseo@gmail.com", "Eliseo Moreno", Pojo_User.ADMINISTRATOR, "");
        Pojo_User user2 = new Pojo_User("1234", 99, "1", "A", "959595959", "medinilla@gmail.com", "Javier Medinilla", Pojo_User.PRESIDENT, "");
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 3, 2);
        GregorianCalendar calendar_2 = new GregorianCalendar(2016, 3, 14);
        GregorianCalendar calendar_3 = new GregorianCalendar(2016, 3, 27);
        GregorianCalendar calendar_4 = new GregorianCalendar(2016, 4, 5);
        GregorianCalendar calendar_5 = new GregorianCalendar(2016, 4, 12);
        GregorianCalendar calendar_6 = new GregorianCalendar(2016, 4, 25);

        add(new Pojo_Entry(user1, "Ruidos nocturnos",
                "Se recuerda a los vecinos que el ayuntamiento prohibe el ruido a partir de las 21.00",
                new Date(calendar_1.getTimeInMillis()), Pojo_Entry.FIRST));
        add(new Pojo_Entry(user1, "Ascensor",
                "El ascensor está estropeado dessde el martes pasado. El revisor vendrá el mes que viene",
                new Date(calendar_2.getTimeInMillis()), Pojo_Entry.FIRST));
    }

    public List<Pojo_Entry> getEntries() {
        return this;
    }
}
