package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Incident;

import java.util.List;

public interface IIncidentPresenter {
    List<Pojo_Incident> selectIncidents();
    int insertIncident(Pojo_Incident incident);

    interface View {
        void showMessage(String msg);
    }
}
