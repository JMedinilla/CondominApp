package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Meeting;

import java.util.List;

public interface IMeetingPresenter {
    List<Pojo_Meeting> selectMeetings();

    int insertMeeting(Pojo_Meeting meeting);

    boolean validateMeeting(Pojo_Meeting meeting);

    interface View {
        void showMessage(String msg);
    }
}
