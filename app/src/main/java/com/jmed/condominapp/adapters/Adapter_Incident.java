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
import com.jmed.condominapp.Repositories.Repository_Incident;
import com.jmed.condominapp.pojo.Pojo_Incident;
import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

public class Adapter_Incident extends ArrayAdapter<Pojo_Incident> {
    private Context context;

    public Adapter_Incident(Context context) {
        super(context, R.layout.adapter_incident, new ArrayList<>(Repository_Incident.getInstance().getIncidents()));
        this.context = context;
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
            incidentHolder.btnLike = (ShineButton) view.findViewById(R.id.adapterIncident_like);

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
        ShineButton btnLike;
    }
}
