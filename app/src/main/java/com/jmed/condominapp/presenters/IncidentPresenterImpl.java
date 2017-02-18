package com.jmed.condominapp.presenters;

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
    public int insertIncident(Pojo_Incident incident) {
        int result = -1;
        if (!Repository_Incident.getInstance().contains(incident)) {
            Repository_Incident.getInstance().add(incident);
            result = 0;
            view.showMessage("Inserted");
        }
        else {
            view.showMessage("Already exists");
        }
        return result;
    }
}
