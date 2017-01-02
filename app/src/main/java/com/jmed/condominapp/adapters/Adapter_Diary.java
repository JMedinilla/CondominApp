package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Note;
import com.jmed.condominapp.pojo.Pojo_Note;

import java.util.ArrayList;

public class Adapter_Diary extends ArrayAdapter<Pojo_Note> {
    private Context context;

    public Adapter_Diary(Context context) {
        super(context, R.layout.adapter_diary, new ArrayList<>(Repository_Note.getInstance().getNotes()));
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        DiaryHolder diaryHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_diary, parent, false);
            diaryHolder = new DiaryHolder();
            diaryHolder.txtTitle = (TextView) view.findViewById(R.id.adapterDiary_txtTitle);
            diaryHolder.txtDescription = (TextView) view.findViewById(R.id.adapterDiary_txtContent);

            view.setTag(diaryHolder);
        } else {
            diaryHolder = (DiaryHolder) view.getTag();
        }

        Pojo_Note note = getItem(position);
        if (note != null) {
            diaryHolder.txtTitle.setText(note.getNo_title());
            diaryHolder.txtDescription.setText(note.getNo_content());
        }

        return view;
    }

    private class DiaryHolder {
        TextView txtTitle;
        TextView txtDescription;
    }
}
