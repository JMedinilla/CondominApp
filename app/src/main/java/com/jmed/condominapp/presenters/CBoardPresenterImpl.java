package com.jmed.condominapp.presenters;

import com.jmed.condominapp.interfaces.ICBoardPresenter;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.repositories.Repository_Entry_Second;

import java.util.List;

public class CBoardPresenterImpl implements ICBoardPresenter {
    private ICBoardPresenter.View view;

    public CBoardPresenterImpl(ICBoardPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Entry> selectSecondEntries() {
        return Repository_Entry_Second.getInstance().getEntries();
    }

    @Override
    public int insertSecondEntry(Pojo_Entry entry) {
        int result = -1;
        if (!Repository_Entry_Second.getInstance().contains(entry)) {
            Repository_Entry_Second.getInstance().add(entry);
            result = 0;
            view.showMessage("Inserted");
        } else {
            view.showMessage("Already exists");
        }
        return result;
    }
}
