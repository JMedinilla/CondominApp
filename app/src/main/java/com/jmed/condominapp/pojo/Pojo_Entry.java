package com.jmed.condominapp.pojo;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

public class Pojo_Entry {
    public static final int FIRST = 0;
    public static final int SECOND = 1;

    private String en_id;
    private Pojo_User en_user;
    private String en_title;
    private String en_content;
    private Date en_date;
    private int en_category;

    public Pojo_Entry(Pojo_User en_user, String en_title, String en_content, Date en_date,
                      int en_category) {
        this.en_id = UUID.randomUUID().toString();
        this.en_user = en_user;
        this.en_title = en_title;
        this.en_content = en_content;
        this.en_date = en_date;
        this.en_category = en_category;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Entry) {
                Pojo_Entry another = (Pojo_Entry) obj;
                if (this.en_title.toUpperCase().equals(another.en_title.toUpperCase())
                        && this.en_content.toUpperCase().equals(another.en_content.toUpperCase())
                        && this.en_category == another.en_category) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Pojo_Entry: " + en_title + " (" + en_date.toString() + ")";
    }

    public String getEn_id() {
        return en_id;
    }

    public void setEn_id(String en_id) {
        this.en_id = en_id;
    }

    public Pojo_User getEn_user() {
        return en_user;
    }

    public void setEn_user(Pojo_User en_user) {
        this.en_user = en_user;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getEn_content() {
        return en_content;
    }

    public void setEn_content(String en_content) {
        this.en_content = en_content;
    }

    public Date getEn_date() {
        return en_date;
    }

    public void setEn_date(Date en_date) {
        this.en_date = en_date;
    }

    public int getEn_category() {
        return en_category;
    }

    public void setEn_category(int en_category) {
        this.en_category = en_category;
    }

    public static final Comparator<Pojo_Entry> COMPARATOR_ENTRY_TITLE = new Comparator<Pojo_Entry>() {
        @Override
        public int compare(Pojo_Entry o1, Pojo_Entry o2) {
            return o1.getEn_title().toUpperCase().compareTo(o2.getEn_title().toUpperCase());
        }
    };
    public static final Comparator<Pojo_Entry> COMPARATOR_ENTRY_DATE = new Comparator<Pojo_Entry>() {
        @Override
        public int compare(Pojo_Entry o1, Pojo_Entry o2) {
            return o1.getEn_date().compareTo(o2.getEn_date());
        }
    };
}
