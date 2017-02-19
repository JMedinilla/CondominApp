package com.jmed.condominapp.pojos;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

public class Pojo_Incident implements Parcelable {
    private String in_id;
    private String in_userid;
    private Date in_date;
    private String in_title;
    private String in_description;
    private String in_photo;
    private int in_stars;
    private boolean in_deleted;

    public Pojo_Incident(String in_userid, Date in_date, String in_title, String in_description,
                         String in_photo, int in_stars, boolean in_deleted) {
        this.in_id = UUID.randomUUID().toString();
        this.in_userid = in_userid;
        this.in_date = in_date;
        this.in_title = in_title;
        this.in_description = in_description;
        this.in_photo = in_photo;
        this.in_stars = in_stars;
        this.in_deleted = in_deleted;
    }

    //region Getter
    //---------------------------------------------------------------------------------------------

    public String getIn_id() {
        return in_id;
    }

    public String getIn_userid() {
        return in_userid;
    }

    public Date getIn_date() {
        return in_date;
    }

    public String getIn_title() {
        return in_title;
    }

    public String getIn_description() {
        return in_description;
    }

    public String getIn_photo() {
        return in_photo;
    }

    public int getIn_stars() {
        return in_stars;
    }

    public boolean isIn_deleted() {
        return in_deleted;
    }

    //---------------------------------------------------------------------------------------------
    //endregion

    //region Setter
    //---------------------------------------------------------------------------------------------

    public void setIn_id(String in_id) {
        this.in_id = in_id;
    }

    public void setIn_userid(String in_userid) {
        this.in_userid = in_userid;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public void setIn_title(String in_title) {
        this.in_title = in_title;
    }

    public void setIn_description(String in_description) {
        this.in_description = in_description;
    }

    public void setIn_photo(String in_photo) {
        this.in_photo = in_photo;
    }

    public void setIn_stars(int in_stars) {
        this.in_stars = in_stars;
    }

    public void setIn_deleted(boolean in_deleted) {
        this.in_deleted = in_deleted;
    }

    //---------------------------------------------------------------------------------------------
    //endregion

    //region Override methods
    //---------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Incident: " + in_title + " (" + in_date.toString() + ")";
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

    //---------------------------------------------------------------------------------------------
    //endregion

    //region List Comparators
    //---------------------------------------------------------------------------------------------

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_TITLE = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_title().toUpperCase().compareTo(o2.getIn_title().toUpperCase());
        }
    };

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_DATE = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_date().compareTo(o2.getIn_date());
        }
    };

    public static final Comparator<Pojo_Incident> COMPARATOR_INCIDENT_AUTHOR = new Comparator<Pojo_Incident>() {
        @Override
        public int compare(Pojo_Incident o1, Pojo_Incident o2) {
            return o1.getIn_stars() - o2.getIn_stars();
        }
    };

    //---------------------------------------------------------------------------------------------
    //endregion

    //region Parcerable implementation
    //---------------------------------------------------------------------------------------------

    private Pojo_Incident(Parcel in) {
        in_id = in.readString();
        in_userid = in.readString();
        in_title = in.readString();
        in_description = in.readString();
        in_photo = in.readString();
        in_stars = in.readInt();
        in_deleted = in.readByte() != 0;
    }

    public static final Creator<Pojo_Incident> CREATOR = new Creator<Pojo_Incident>() {
        @Override
        public Pojo_Incident createFromParcel(Parcel in) {
            return new Pojo_Incident(in);
        }

        @Override
        public Pojo_Incident[] newArray(int size) {
            return new Pojo_Incident[size];
        }
    };

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(in_id);
        parcel.writeString(in_userid);
        parcel.writeString(in_title);
        parcel.writeString(in_description);
        parcel.writeString(in_photo);
        parcel.writeInt(in_stars);
        parcel.writeByte((byte) (in_deleted ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //---------------------------------------------------------------------------------------------
    //endregion
}
