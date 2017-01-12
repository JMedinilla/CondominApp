package com.jmed.condominapp.Repositories;

import com.jmed.condominapp.pojo.Pojo_Entry;
import com.jmed.condominapp.pojo.Pojo_User;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Repository_Entry_Second extends ArrayList<Pojo_Entry> {
    private static Repository_Entry_Second instance;

    public static Repository_Entry_Second getInstance() {
        if (instance == null) {
            instance = new Repository_Entry_Second();
        }
        return instance;
    }

    private Repository_Entry_Second() {
        Pojo_User user1 = new Pojo_User("12", 99, "-", "-", "656565656", "eliseo@gmail.com", "Eliseo Moreno", Pojo_User.ADMINISTRATOR, "");
        GregorianCalendar calendar_1 = new GregorianCalendar(2016, 3, 2);
        GregorianCalendar calendar_2 = new GregorianCalendar(2016, 3, 14);

        add(new Pojo_Entry(user1, "Pantalón perdido",
                "Soy del 1A y tengo un pantalón vaquero que se ha caido al patio, el dueño que se vaya pasando por aquí",
                new Date(calendar_1.getTimeInMillis()), Pojo_Entry.SECOND));
        add(new Pojo_Entry(user1, "Ruidos por la noche",
                "Estoy harto de los putos ruidos de los del atico, o sea, es que me cago en dios ya en serio, como a partir de mañana mismo sigais con la mierda de musica a las 11 de la noche os juro que os meto una denuncia por el culo",
                new Date(calendar_2.getTimeInMillis()), Pojo_Entry.SECOND));
    }

    public List<Pojo_Entry> getEntries() {
        return this;
    }
}
