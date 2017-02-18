package com.jmed.condominapp.presenters;

import com.jmed.condominapp.R;
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
    public Pojo_Note selectNote(String id) {
        return null;
    }

    @Override
    public int insertNote(Pojo_Note note) {
        int result = -1;
        if (!Repository_Note.getInstance().contains(note)) {
            Repository_Note.getInstance().add(note);
            result = 0;
            view.showMessage(R.string.inserted);
        } else {
            view.showMessage(R.string.exists);
        }
        return result;
    }

    @Override
    public int updateNote(Pojo_Note note) {
        return 0;
    }

    @Override
    public int deleteNote(Pojo_Note note) {
        return 0;
    }

    @Override
    public boolean validateNote(Pojo_Note note) {
        boolean result;
        if (note.getNo_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Title);
        } else if (note.getNo_content().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Description);
        } else {
            result = true;
        }
        return result;
    }
}
