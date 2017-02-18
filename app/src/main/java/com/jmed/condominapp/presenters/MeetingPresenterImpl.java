package com.jmed.condominapp.presenters;

import com.jmed.condominapp.interfaces.IMeetingPresenter;
import com.jmed.condominapp.pojos.Pojo_Meeting;
import com.jmed.condominapp.repositories.Repository_Meeting;

import java.util.List;

public class MeetingPresenterImpl implements IMeetingPresenter {
    private IMeetingPresenter.View view;

    public MeetingPresenterImpl(IMeetingPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Meeting> selectMeetings() {
        return Repository_Meeting.getInstance().getMeetings();
    }

    @Override
    public int insertMeeting(Pojo_Meeting meeting) {
        return 0;
    }

    @Override
    public boolean validateMeeting(Pojo_Meeting meeting) {
        return false;
    }
}
