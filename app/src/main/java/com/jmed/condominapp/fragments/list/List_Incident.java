package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_Incident;
import com.jmed.condominapp.pojo.Pojo_Incident;

public class List_Incident extends Fragment {
    private FragmentListIncidentListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_INCIDENT = "fragmentListIncidentTag";

    Adapter_Incident adapter_incident;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentListIncidentListener {
        void onManageIncidentOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListIncidentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_incident, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListIncident_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListIncident_list);

        adapter_incident = new Adapter_Incident(getContext());
        listView.setDivider(null);
        listView.setAdapter(adapter_incident);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageIncidentOpen();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_incident = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_incidents, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuIncidents_date:
                adapter_incident.sortIncidents(Pojo_Incident.COMPARATOR_INCIDENT_DATE);
                break;
            case R.id.menuIncidents_author:
                adapter_incident.sortIncidents(Pojo_Incident.COMPARATOR_INCIDENT_AUTHOR);
                break;
            case R.id.menuIncidents_title:
                adapter_incident.sortIncidents(Pojo_Incident.COMPARATOR_INCIDENT_TITLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}