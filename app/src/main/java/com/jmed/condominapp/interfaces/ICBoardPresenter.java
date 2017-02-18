package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Entry;

import java.util.List;

public interface ICBoardPresenter {
    List<Pojo_Entry> selectSecondEntries();

    int insertSecondEntry(Pojo_Entry entry);

    boolean validateSecondEntry(Pojo_Entry entry);

    interface View {
        void showMessage(int msg);
    }
}
