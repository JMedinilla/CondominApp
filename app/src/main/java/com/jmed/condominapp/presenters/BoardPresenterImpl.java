package com.jmed.condominapp.presenters;

import com.jmed.condominapp.interfaces.IBoardPresenter;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.repositories.Repository_Entry_First;

import java.util.List;

public class BoardPresenterImpl implements IBoardPresenter {
    private IBoardPresenter.View view;

    public BoardPresenterImpl(IBoardPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Entry> selectFirstEntries() {
        return Repository_Entry_First.getInstance().getEntries();
    }

    @Override
    public int insertFirstEntry(Pojo_Entry entry) {
        int result = -1;
        if (!Repository_Entry_First.getInstance().contains(entry)) {
            Repository_Entry_First.getInstance().add(entry);
            result = 0;
            view.showMessage("Inserted");
        }
        else {
            view.showMessage("Already exists");
        }
        return result;
    }
}
