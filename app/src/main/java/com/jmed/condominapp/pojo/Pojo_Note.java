package com.jmed.condominapp.pojo;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

public class Pojo_Note {
    private String no_id;
    private int no_community;
    private Date no_date;
    private String no_title;
    private String no_content;

    public Pojo_Note(int no_community, Date no_date, String no_title, String no_content) {
        this.no_id = UUID.randomUUID().toString();
        this.no_community = no_community;
        this.no_date = no_date;
        this.no_title = no_title;
        this.no_content = no_content;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Note) {
                Pojo_Note another = (Pojo_Note) obj;
                if (this.no_title.toUpperCase().equals(another.no_title.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Note: " + no_title + " (" + no_date.toString() + ")";
    }

    public String getNo_id() {
        return no_id;
    }

    public void setNo_id(String no_id) {
        this.no_id = no_id;
    }

    public int getNo_community() {
        return no_community;
    }

    public void setNo_community(int no_community) {
        this.no_community = no_community;
    }

    public Date getNo_date() {
        return no_date;
    }

    public void setNo_date(Date no_date) {
        this.no_date = no_date;
    }

    public String getNo_title() {
        return no_title;
    }

    public void setNo_title(String no_title) {
        this.no_title = no_title;
    }

    public String getNo_content() {
        return no_content;
    }

    public void setNo_content(String no_content) {
        this.no_content = no_content;
    }

    public static final Comparator<Pojo_Note> COMPARATOR_NOTE_DATE = new Comparator<Pojo_Note>() {
        @Override
        public int compare(Pojo_Note o1, Pojo_Note o2) {
            return o1.getNo_date().compareTo(o2.getNo_date());
        }
    };

    public static final Comparator<Pojo_Note> COMPARATOR_NOTE_TITLE = new Comparator<Pojo_Note>() {
        @Override
        public int compare(Pojo_Note o1, Pojo_Note o2) {
            return o1.getNo_title().toUpperCase().compareTo(o2.getNo_title().toUpperCase());
        }
    };
}
