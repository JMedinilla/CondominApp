package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.repositories.Repository_Incident;
import com.jmed.condominapp.pojos.Pojo_Incident;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Adapter_Incident extends ArrayAdapter<Pojo_Incident> {
    private Context context;

    public Adapter_Incident(Context context, List<Pojo_Incident> pojo_incidents) {
        super(context, R.layout.adapter_incident, pojo_incidents);
        this.context = context;
    }

    public void sortIncidents(Comparator<Pojo_Incident> comparator) {
        Collections.sort(Repository_Incident.getInstance(), comparator);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        IncidentHolder incidentHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_incident, parent, false);
            incidentHolder = new IncidentHolder();
            incidentHolder.imgPhoto = (ImageView) view.findViewById(R.id.adapterIncident_img);
            incidentHolder.txtTitle = (TextView) view.findViewById(R.id.adapterIncident_txtTitle);
            incidentHolder.txtDate = (TextView) view.findViewById(R.id.adapterIncident_txtDate);
            incidentHolder.txtContent = (TextView) view.findViewById(R.id.adapterIncident_txtContent);

            view.setTag(incidentHolder);
        } else {
            incidentHolder = (IncidentHolder) view.getTag();
        }

        Pojo_Incident incident = getItem(position);
        if (incident != null) {
            String month = (String) android.text.format.DateFormat.format("MMM", incident.getIn_date());
            String year = (String) android.text.format.DateFormat.format("yyyy", incident.getIn_date());
            String day = (String) android.text.format.DateFormat.format("dd", incident.getIn_date());

            incidentHolder.imgPhoto.setImageResource(R.drawable.ic_image_black);
            incidentHolder.txtTitle.setText(incident.getIn_title());
            incidentHolder.txtDate.setText(day + " " + month + " " + year);
            incidentHolder.txtContent.setText(incident.getIn_description());
        }

        return view;
    }

    private class IncidentHolder {
        ImageView imgPhoto;
        TextView txtTitle;
        TextView txtDate;
        TextView txtContent;
    }
}
