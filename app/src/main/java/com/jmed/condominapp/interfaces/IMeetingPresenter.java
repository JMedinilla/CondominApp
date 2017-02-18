package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Meeting;

import java.util.List;

public interface IMeetingPresenter {
    List<Pojo_Meeting> selectMeetings();

    Pojo_Meeting selectMeeting(int id);

    int insertMeeting(Pojo_Meeting meeting);

    int updateMeeting(Pojo_Meeting meeting);

    int deleteMeeting(Pojo_Meeting meeting);

    boolean validateMeeting(Pojo_Meeting meeting);

    interface View {
        void showMessage(int msg, boolean error);
    }
}
