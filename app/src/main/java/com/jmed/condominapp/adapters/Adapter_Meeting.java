package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Meeting;
import com.jmed.condominapp.pojo.Pojo_Meeting;

import java.util.ArrayList;

public class Adapter_Meeting extends ArrayAdapter<Pojo_Meeting> {
    private Context context;
    private Repository_Meeting repository;

    public Adapter_Meeting(Context context) {
        super(context, R.layout.adapter_meeting, new ArrayList<>(Repository_Meeting.getInstance().getMeetings()));
        this.context = context;
        this.repository = Repository_Meeting.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        MeetingHolder meetingHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_board, parent, false);
            meetingHolder = new MeetingHolder();
        } else {
            meetingHolder = (MeetingHolder) view.getTag();
        }

        Pojo_Meeting meeting = getItem(position);
        if (meeting != null) {
            //
        }

        return view;
    }

    private class MeetingHolder {
        //
    }
}
