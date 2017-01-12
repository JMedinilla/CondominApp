package com.jmed.condominapp.pojo;

import java.util.Comparator;
import java.util.UUID;

public class Pojo_Document {
    private String do_id;
    private int do_community;
    private String do_title;
    private String do_description;
    private String do_link;

    public Pojo_Document(int do_community, String do_title, String do_description, String do_link) {
        this.do_id = UUID.randomUUID().toString();
        this.do_community = do_community;
        this.do_title = do_title;
        this.do_description = do_description;
        this.do_link = do_link;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Document) {
                Pojo_Document another = (Pojo_Document) obj;
                if (this.do_title.toUpperCase().equals(another.do_title.toUpperCase())
                        && this.do_link.toUpperCase().equals(another.do_link.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Document: " + do_title + " -> " + do_link;
    }

    public String getDo_id() {
        return do_id;
    }

    public void setDo_id(String do_id) {
        this.do_id = do_id;
    }

    public int getDo_community() {
        return do_community;
    }

    public void setDo_community(int do_community) {
        this.do_community = do_community;
    }

    public String getDo_title() {
        return do_title;
    }

    public void setDo_title(String do_title) {
        this.do_title = do_title;
    }

    public String getDo_description() {
        return do_description;
    }

    public void setDo_description(String do_description) {
        this.do_description = do_description;
    }

    public String getDo_link() {
        return do_link;
    }

    public void setDo_link(String do_link) {
        this.do_link = do_link;
    }

    public static final Comparator<Pojo_Document> COMPARATOR_DOCUMENT_TITLE = new Comparator<Pojo_Document>() {
        @Override
        public int compare(Pojo_Document o1, Pojo_Document o2) {
            return o1.getDo_title().toUpperCase().compareTo(o2.getDo_title().toUpperCase());
        }
    };
}
