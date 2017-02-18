package com.jmed.condominapp.presenters;

import com.jmed.condominapp.R;
import com.jmed.condominapp.interfaces.IIncidentPresenter;
import com.jmed.condominapp.pojos.Pojo_Incident;
import com.jmed.condominapp.repositories.Repository_Incident;

import java.util.List;

public class IncidentPresenterImpl implements IIncidentPresenter {
    private IIncidentPresenter.View view;

    public IncidentPresenterImpl(IIncidentPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Incident> selectIncidents() {
        return Repository_Incident.getInstance().getIncidents();
    }

    @Override
    public Pojo_Incident selectIncident(String id) {
        return null;
    }

    @Override
    public int insertIncident(Pojo_Incident incident) {
        int result = -1;
        if (!Repository_Incident.getInstance().contains(incident)) {
            Repository_Incident.getInstance().add(incident);
            result = 0;
            view.showMessage(R.string.inserted);
        } else {
            view.showMessage(R.string.exists);
        }
        return result;
    }

    @Override
    public int updateIncident(Pojo_Incident incident) {
        return 0;
    }

    @Override
    public int deleteIncident(Pojo_Incident incident) {
        return 0;
    }

    @Override
    public boolean validateIncident(Pojo_Incident incident) {
        boolean result;
        if (incident.getIn_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Title);
        } else if (incident.getIn_description().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Description);
        } else {
            result = true;
        }
        return result;
    }
}
