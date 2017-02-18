package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Incident;

import java.util.List;

public interface IIncidentPresenter {
    List<Pojo_Incident> selectIncidents();

    Pojo_Incident selectIncident(String id);

    int insertIncident(Pojo_Incident incident);

    int updateIncident(Pojo_Incident incident);

    int deleteIncident(Pojo_Incident incident);

    boolean validateIncident(Pojo_Incident incident);

    interface View {
        void showMessage(int msg);
    }
}
