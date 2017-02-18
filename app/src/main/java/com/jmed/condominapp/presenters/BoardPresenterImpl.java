package com.jmed.condominapp.presenters;

import com.jmed.condominapp.R;
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
    public Pojo_Entry selectFirstEntry(String id) {
        return null;
    }

    @Override
    public int insertFirstEntry(Pojo_Entry entry) {
        int result = -1;
        if (!Repository_Entry_First.getInstance().contains(entry)) {
            Repository_Entry_First.getInstance().add(entry);
            result = 0;
            view.showMessage(R.string.inserted);
        } else {
            view.showMessage(R.string.exists);
        }
        return result;
    }

    @Override
    public int updateFirstEntry(Pojo_Entry entry) {
        return 0;
    }

    @Override
    public int deleteFirstEntry(Pojo_Entry entry) {
        return 0;
    }

    @Override
    public boolean validateFirstEntry(Pojo_Entry entry) {
        boolean result;
        if (entry.getEn_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Title);
        } else if (entry.getEn_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Description);
        } else {
            result = true;
        }
        return result;
    }
}
