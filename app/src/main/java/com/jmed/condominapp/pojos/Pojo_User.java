package com.jmed.condominapp.pojos;

import java.util.Comparator;

public class Pojo_User {
    public static final int ADMINISTRATOR = 0;
    public static final int PRESIDENT = 1;
    public static final int NEIGHBOUR = 2;

    private String us_id;
    private int us_community;
    private String us_floor;
    private String us_door;
    private String us_phone;
    private String us_mail;
    private String us_name;
    private int us_category;
    private String us_photo;
    private boolean us_deleted;

    public Pojo_User(String us_id, int us_community, String us_floor, String us_door,
                     String us_phone, String us_mail, String us_name, int us_category, String us_photo, boolean us_deleted) {
        this.us_id = us_id;
        this.us_community = us_community;
        this.us_floor = us_floor;
        this.us_door = us_door;
        this.us_phone = us_phone;
        this.us_mail = us_mail;
        this.us_name = us_name;
        this.us_category = us_category;
        this.us_photo = us_photo;
        this.us_deleted = us_deleted;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_User) {
                Pojo_User another = (Pojo_User) obj;
                if (this.us_phone.equals(another.us_phone)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "User: " + us_name + " (" + us_phone + ") -> " + us_floor + us_door;
    }

    public String getUs_id() {
        return us_id;
    }

    public void setUs_id(String us_id) {
        this.us_id = us_id;
    }

    public int getUs_community() {
        return us_community;
    }

    public void setUs_community(int us_community) {
        this.us_community = us_community;
    }

    public String getUs_floor() {
        return us_floor;
    }

    public void setUs_floor(String us_floor) {
        this.us_floor = us_floor;
    }

    public String getUs_door() {
        return us_door;
    }

    public void setUs_door(String us_door) {
        this.us_door = us_door;
    }

    public String getUs_phone() {
        return us_phone;
    }

    public void setUs_phone(String us_phone) {
        this.us_phone = us_phone;
    }

    public String getUs_mail() {
        return us_mail;
    }

    public void setUs_mail(String us_mail) {
        this.us_mail = us_mail;
    }

    public String getUs_name() {
        return us_name;
    }

    public void setUs_name(String us_name) {
        this.us_name = us_name;
    }

    public int getUs_category() {
        return us_category;
    }

    public void setUs_category(int us_category) {
        this.us_category = us_category;
    }

    public String getUs_photo() {
        return us_photo;
    }

    public void setUs_photo(String us_photo) {
        this.us_photo = us_photo;
    }

    public boolean isUs_deleted() {
        return us_deleted;
    }

    public void setUs_deleted(boolean us_deleted) {
        this.us_deleted = us_deleted;
    }

    public static final Comparator<Pojo_User> COMPARATOR_USER_NAME = new Comparator<Pojo_User>() {
        @Override
        public int compare(Pojo_User o1, Pojo_User o2) {
            return o1.getUs_name().toUpperCase().compareTo(o2.getUs_name().toUpperCase());
        }
    };

    public static final Comparator<Pojo_User> COMPARATOR_USER_PHONE = new Comparator<Pojo_User>() {
        @Override
        public int compare(Pojo_User o1, Pojo_User o2) {
            return o1.getUs_phone().compareTo(o2.getUs_phone());
        }
    };
}
