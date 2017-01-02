package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Meeting;
import com.jmed.condominapp.pojo.Pojo_Meeting;

import java.util.ArrayList;

public class Adapter_Meeting extends ArrayAdapter<Pojo_Meeting> {
    private Context context;

    public Adapter_Meeting(Context context) {
        super(context, R.layout.adapter_meeting, new ArrayList<>(Repository_Meeting.getInstance().getMeetings()));
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        MeetingHolder meetingHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_meeting, parent, false);
            meetingHolder = new MeetingHolder();
            meetingHolder.txtTitle = (TextView) view.findViewById(R.id.adapterMeeting_txtTitle);

            view.setTag(meetingHolder);
        } else {
            meetingHolder = (MeetingHolder) view.getTag();
        }

        Pojo_Meeting meeting = getItem(position);
        if (meeting != null) {
            String month = (String) android.text.format.DateFormat.format("MMM", meeting.getMe_date());
            String year = (String) android.text.format.DateFormat.format("yyyy", meeting.getMe_date());
            String day = (String) android.text.format.DateFormat.format("dd", meeting.getMe_date());
            meetingHolder.txtTitle.setText(day + " " + month + " " + year);
        }

        return view;
    }

    private class MeetingHolder {
        TextView txtTitle;
    }
}
