package com.jmed.condominapp.fragments.form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Incident;
import com.jmed.condominapp.pojo.Pojo_Incident;
import com.jmed.condominapp.pojo.Pojo_User;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_Incident extends Fragment {
    public static final String TAG_FRAGMENT_FORM_INCIDENT = "fragmentFormIncidentTag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_incident, container, false);

        ImageView img;
        final EditText title;
        final EditText description;
        FloatingActionButton btn;
        Profile profile;

        img = (ImageView) view.findViewById(R.id.fragFormIncident_img);
        title = (EditText) view.findViewById(R.id.fragFormIncident_title);
        description = (EditText) view.findViewById(R.id.fragFormIncident_description);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormIncident_btn);
        profile = new Profile(getContext());

        final Pojo_User user = new Pojo_User(profile.getAccess(), profile.getUserCommunity(), profile.getUserFloor(), profile.getUserDoor(),
                profile.getUserPhone(), profile.getUserMail(), profile.getUserName(), profile.getUserCategory(), profile.getUserPhoto());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.getText().toString().length() == 0) {
                    title.setText("default");
                }
                if (description.getText().toString().length() == 0) {
                    description.setText("default");
                }

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Pojo_Incident incident = new Pojo_Incident(user, date, title.getText().toString(),
                        description.getText().toString(), "url", 0);

                if (!Repository_Incident.getInstance().contains(incident)) {
                    Repository_Incident.getInstance().add(incident);
                    getActivity().onBackPressed();
                } else {
                    Toast.makeText(getContext(), "Already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
