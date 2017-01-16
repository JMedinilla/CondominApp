package com.jmed.condominapp.pojos;

import java.util.Comparator;
import java.util.UUID;

public class Pojo_Point {
    private String po_id;
    private int po_meeting;
    private String po_title;
    private String po_content;

    public Pojo_Point(int po_meeting, String po_title, String po_content) {
        this.po_id = UUID.randomUUID().toString();
        this.po_meeting = po_meeting;
        this.po_title = po_title;
        this.po_content = po_content;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Point) {
                Pojo_Point another = (Pojo_Point) obj;
                if (this.po_title.toUpperCase().equals(another.po_title.toUpperCase())) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Point: " + po_title;
    }

    public String getPo_id() {
        return po_id;
    }

    public void setPo_id(String po_id) {
        this.po_id = po_id;
    }

    public int getPo_meeting() {
        return po_meeting;
    }

    public void setPo_meeting(int po_meeting) {
        this.po_meeting = po_meeting;
    }

    public String getPo_title() {
        return po_title;
    }

    public void setPo_title(String po_title) {
        this.po_title = po_title;
    }

    public String getPo_content() {
        return po_content;
    }

    public void setPo_content(String po_content) {
        this.po_content = po_content;
    }

    public static final Comparator<Pojo_Point> COMPARATOR_POINT_TITLE = new Comparator<Pojo_Point>() {
        @Override
        public int compare(Pojo_Point o1, Pojo_Point o2) {
            return o1.getPo_title().toUpperCase().compareTo(o2.getPo_title().toUpperCase());
        }
    };
}
