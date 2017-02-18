package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Entry;

import java.util.List;

public interface IBoardPresenter {
    List<Pojo_Entry> selectFirstEntries();

    int insertFirstEntry(Pojo_Entry entry);

    boolean validateFirstEntry(Pojo_Entry entry);

    interface View {
        void showMessage(int msg);
    }
}
