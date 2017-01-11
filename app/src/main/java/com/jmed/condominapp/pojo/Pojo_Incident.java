package com.jmed.condominapp.pojo;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

public class Pojo_Incident {
    private String in_id;
    private Pojo_User in_user;
    private Date in_date;
    private String in_title;
    private String in_description;
    private String in_photo;
    private int in_stars;

    public Pojo_Incident(Pojo_User in_user, Date in_date, String in_title, String in_description,
                         String in_photo, int in_stars) {
        this.in_id = UUID.randomUUID().toString();
        this.in_user = in_user;
        this.in_date = in_date;
        this.in_title = in_title;
        this.in_description = in_description;
        this.in_photo = in_photo;
        this.in_stars = in_stars;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Incident) {
                Pojo_Incident another = (Pojo_Incident) obj;
                if (this.in_title.toUpperCase().equals(another.in_title.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Incident: " + in_title + " (" + in_date.toString() + ")";
    }

    public String getIn_id() {
        return in_id;
    }

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public Pojo_User getIn_user() {
        return in_user;
    }

    public void setIn_user(Pojo_User in_user) {
        this.in_user = in_user;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public String getIn_title() {
        return in_title;
    }

    public void setIn_title(String in_title) {
        this.in_title = in_title;
    }

    public String getIn_description() {
        return in_description;
    }

    public void setIn_description(String in_description) {
        this.in_description = in_description;
    }

    public String getIn_photo() {
        return in_photo;
    }

    public void setIn_photo(String in_photo) {
        this.in_photo = in_photo;
    }

    public int getIn_stars() {
        return in_stars;
    }

    public void setIn_stars(int in_stars) {
        this.in_stars = in_stars;
    }

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_TITLE_ASC = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_title().toUpperCase().compareTo(o2.getIn_title().toUpperCase());
        }
    };
    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_TITLE_DES = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o2.getIn_title().toUpperCase().compareTo(o1.getIn_title().toUpperCase());
        }
    };

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_DATE_ASC = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_date().compareTo(o2.getIn_date());
        }
    };
    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_DATE_DES = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o2.getIn_date().compareTo(o1.getIn_date());
        }
    };

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_AUTHOR_ASC = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_stars() - o2.getIn_stars();
        }
    };
    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_AUTHOR_DES = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o2.getIn_stars() - o1.getIn_stars();
        }
    };
}
