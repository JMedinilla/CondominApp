package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Note;

import java.util.List;

public interface IDiaryPresenter {
    List<Pojo_Note> selectNotes();

    Pojo_Note selectNote(String id);

    int insertNote(Pojo_Note note);

    int updateNote(Pojo_Note note);

    int deleteNote(Pojo_Note note);

    boolean validateNote(Pojo_Note note);

    interface View {
        void showMessage(int msg);
    }
}
