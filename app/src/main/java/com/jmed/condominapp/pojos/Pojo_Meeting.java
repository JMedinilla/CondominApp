package com.jmed.condominapp.pojos;

import java.util.Comparator;
import java.util.Date;

public class Pojo_Meeting {
    private int me_id;
    private int me_community;
    private Date me_date;
    private boolean me_deleted;

    public Pojo_Meeting(int me_id, int me_community, Date me_date, boolean me_deleted) {
        this.me_id = me_id;
        this.me_community = me_community;
        this.me_date = me_date;
        this.me_deleted = me_deleted;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof Pojo_Meeting) {
                Pojo_Meeting another = (Pojo_Meeting) obj;
                if (this.me_date.equals(another.me_date)) {
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "Meeting (" + me_date.toString() + ")";
    }

    public int getMe_id() {
        return me_id;
    }

    public void setMe_id(int me_id) {
        this.me_id = me_id;
    }

    public int getMe_community() {
        return me_community;
    }

    public void setMe_community(int me_community) {
        this.me_community = me_community;
    }

    public Date getMe_date() {
        return me_date;
    }

    public void setMe_date(Date me_date) {
        this.me_date = me_date;
    }

    public boolean isMe_deleted() {
        return me_deleted;
    }

    public void setMe_deleted(boolean me_deleted) {
        this.me_deleted = me_deleted;
    }

    public static final Comparator<Pojo_Meeting> COMPARATOR_MEETING_DATE = new Comparator<Pojo_Meeting>() {
        @Override
        public int compare(Pojo_Meeting o1, Pojo_Meeting o2) {
            return o1.getMe_date().compareTo(o2.getMe_date());
        }
    };
}