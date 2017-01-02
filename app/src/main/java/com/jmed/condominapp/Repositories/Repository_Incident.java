package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Incident;
import com.jmed.condominapp.pojo.Pojo_User;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Repository_Incident extends ArrayList<Pojo_Incident> {
    private static Repository_Incident instance;

    public static Repository_Incident getInstance() {
        if (instance == null) {
            instance = new Repository_Incident();
        }
        return instance;
    }

    private Repository_Incident() {
        Pojo_User user1 = new Pojo_User("12", 99, "-", "-", "656565656", "eliseo@gmail.com", "Eliseo Moreno", Pojo_User.ADMINISTRATOR);
        Pojo_User user2 = new Pojo_User("1234", 99, "1", "A", "959595959", "medinilla@gmail.com", "Javier Medinilla", Pojo_User.PRESIDENT);
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 3, 2);
        GregorianCalendar calendar_2 = new GregorianCalendar(2016, 3, 14);
        GregorianCalendar calendar_3 = new GregorianCalendar(2016, 3, 27);

        add(new Pojo_Incident(user1, new Date(calendar_1.getTimeInMillis()), "Bombilla fundida", "La luz de la bombilla del rellano del tercero no va", "url 1", 0));
        add(new Pojo_Incident(user1, new Date(calendar_2.getTimeInMillis()), "Azulejo roto", "En la escalera del segundo al tercero hay un azulejo roto", "url 2", 0));
        add(new Pojo_Incident(user2, new Date(calendar_3.getTimeInMillis()), "Escalón roto", "A un escalón de la escalera del cuarto al ático le falta un trozo", "url 3", 0));
    }

    public List<Pojo_Incident> getIncidents() {
        return this;
    }
}
