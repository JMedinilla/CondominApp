package com.jmed.condominapp.pojo;

import java.util.Comparator;

public class Pojo_Community {
    private int co_id;
    private String co_locality;
    private String co_municipality;
    private String co_address;
    private String co_number;
    private String co_block;
    private String co_postal;
    private int co_apartments;
    private String co_admin_name;
    private String co_admin_address;
    private String co_admin_phone;
    private String co_admin_mail;
    private String co_president_name;
    private String co_president_phone;

    public Pojo_Community(int co_id, String co_locality, String co_municipality, String co_address,
                          String co_number, String co_block, String co_postal, int co_apartments,
                          String co_admin_name, String co_admin_address, String co_admin_phone, String co_admin_mail,
                          String co_president_name, String co_president_phone) {
        this.co_id = co_id;
        this.co_locality = co_locality;
        this.co_municipality = co_municipality;
        this.co_address = co_address;
        this.co_number = co_number;
        this.co_block = co_block;
        this.co_postal = co_postal;
        this.co_apartments = co_apartments;
        this.co_admin_name = co_admin_name;
        this.co_admin_address = co_admin_address;
        this.co_admin_phone = co_admin_phone;
        this.co_admin_mail = co_admin_mail;
        this.co_president_name = co_president_name;
        this.co_president_phone = co_president_phone;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Community) {
                Pojo_Community another = (Pojo_Community) obj;
                if (this.co_postal.toUpperCase().equals(another.co_postal.toUpperCase())
                        && this.co_address.toUpperCase().equals(another.co_address.toUpperCase())
                        && this.co_number.toUpperCase().equals(another.co_number.toUpperCase())
                        && this.co_block.toUpperCase().equals(another.co_block.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Community: "
                + co_postal + " (postal), "
                + co_address + " n" + co_number + " (address), "
                + co_admin_name + " (admin)";
    }

    public int getCo_id() {
        return co_id;
    }

    public void setCo_id(int co_id) {
        this.co_id = co_id;
    }

    public String getCo_locality() {
        return co_locality;
    }

    public void setCo_locality(String co_locality) {
        this.co_locality = co_locality;
    }

    public String getCo_municipality() {
        return co_municipality;
    }

    public void setCo_municipality(String co_municipality) {
        this.co_municipality = co_municipality;
    }

    public String getCo_address() {
        return co_address;
    }

    public void setCo_address(String co_address) {
        this.co_address = co_address;
    }

    public String getCo_number() {
        return co_number;
    }

    public void setCo_number(String co_number) {
        this.co_number = co_number;
    }

    public String getCo_block() {
        return co_block;
    }

    public void setCo_block(String co_block) {
        this.co_block = co_block;
    }

    public String getCo_postal() {
        return co_postal;
    }

    public void setCo_postal(String co_postal) {
        this.co_postal = co_postal;
    }

    public int getCo_apartments() {
        return co_apartments;
    }

    public void setCo_apartments(int co_apartments) {
        this.co_apartments = co_apartments;
    }

    public String getCo_admin_name() {
        return co_admin_name;
    }

    public void setCo_admin_name(String co_admin_name) {
        this.co_admin_name = co_admin_name;
    }

    public String getCo_admin_address() {
        return co_admin_address;
    }

    public void setCo_admin_address(String co_admin_address) {
        this.co_admin_address = co_admin_address;
    }

    public String getCo_admin_phone() {
        return co_admin_phone;
    }

    public void setCo_admin_phone(String co_admin_phone) {
        this.co_admin_phone = co_admin_phone;
    }

    public String getCo_admin_mail() {
        return co_admin_mail;
    }

    public void setCo_admin_mail(String co_admin_mail) {
        this.co_admin_mail = co_admin_mail;
    }

    public String getCo_president_name() {
        return co_president_name;
    }

    public void setCo_president_name(String co_president_name) {
        this.co_president_name = co_president_name;
    }

    public String getCo_president_phone() {
        return co_president_phone;
    }

    public void setCo_president_phone(String co_president_phone) {
        this.co_president_phone = co_president_phone;
    }

    public static final Comparator<Pojo_Community> COMPARATOR_COMMUNITY_POSTAL_ASC = new Comparator<Pojo_Community>() {
        @Override
        public int compare(Pojo_Community o1, Pojo_Community o2) {
            return o1.getCo_postal().toUpperCase().compareTo(o2.getCo_postal().toUpperCase());
        }
    };
    public static final Comparator<Pojo_Community> COMPARATOR_COMMUNITY_POSTAL_DES = new Comparator<Pojo_Community>() {
        @Override
        public int compare(Pojo_Community o1, Pojo_Community o2) {
            return o2.getCo_postal().toUpperCase().compareTo(o1.getCo_postal().toUpperCase());
        }
    };

    public static final Comparator<Pojo_Community> COMPARATOR_COMMUNITY_APARTMENTS_ASC = new Comparator<Pojo_Community>() {
        @Override
        public int compare(Pojo_Community o1, Pojo_Community o2) {
            return o1.getCo_apartments() - o2.getCo_apartments();
        }
    };
    public static final Comparator<Pojo_Community> COMPARATOR_COMMUNITY_APARTMENTS_DES = new Comparator<Pojo_Community>() {
        @Override
        public int compare(Pojo_Community o1, Pojo_Community o2) {
            return o2.getCo_apartments() - o1.getCo_apartments();
        }
    };
}
