package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Note;
import com.jmed.condominapp.pojo.Pojo_Note;

import java.util.ArrayList;

public class Adapter_Diary extends ArrayAdapter<Pojo_Note> {
    private Context context;
    private Repository_Note repository;

    public Adapter_Diary(Context context) {
        super(context, R.layout.adapter_diary, new ArrayList<>(Repository_Note.getInstance().getNotes()));
        this.context = context;
        this.repository = Repository_Note.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        DiaryHolder diaryHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_board, parent, false);
            diaryHolder = new DiaryHolder();
        } else {
            diaryHolder = (DiaryHolder) view.getTag();
        }

        Pojo_Note note = getItem(position);
        if (note != null) {
            //
        }

        return view;
    }

    private class DiaryHolder {
        //
    }
}
