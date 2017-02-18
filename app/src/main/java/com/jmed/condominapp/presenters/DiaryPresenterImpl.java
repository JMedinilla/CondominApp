package com.jmed.condominapp.presenters;

import com.jmed.condominapp.interfaces.IDiaryPresenter;
import com.jmed.condominapp.pojos.Pojo_Note;
import com.jmed.condominapp.repositories.Repository_Note;

import java.util.List;

public class DiaryPresenterImpl implements IDiaryPresenter {
    private IDiaryPresenter.View view;

    public DiaryPresenterImpl(IDiaryPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Note> selectNotes() {
        return Repository_Note.getInstance().getNotes();
    }

    @Override
    public int insertNote(Pojo_Note note) {
        int result = -1;
        if (!Repository_Note.getInstance().contains(note)) {
            Repository_Note.getInstance().add(note);
            result = 0;
            view.showMessage("Inserted");
        }
        else {
            view.showMessage("Already exists");
        }
        return result;
    }
}
