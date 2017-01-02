package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Incident;
import com.jmed.condominapp.pojo.Pojo_Incident;

import java.util.ArrayList;

public class Adapter_Incident extends ArrayAdapter<Pojo_Incident> {
    private Context context;
    private Repository_Incident repository;

    public Adapter_Incident(Context context) {
        super(context, R.layout.adapter_incident, new ArrayList<>(Repository_Incident.getInstance().getIncidents()));
        this.context = context;
        this.repository = Repository_Incident.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        IncidentHolder incidentHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_board, parent, false);
            incidentHolder = new IncidentHolder();
        } else {
            incidentHolder = (IncidentHolder) view.getTag();
        }

        Pojo_Incident incident = getItem(position);
        if (incident != null) {
            //
        }

        return view;
    }

    private class IncidentHolder {
        //
    }
}
