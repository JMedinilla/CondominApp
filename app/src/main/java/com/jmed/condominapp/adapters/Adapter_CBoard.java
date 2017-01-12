package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Entry_Second;
import com.jmed.condominapp.pojo.Pojo_Entry;

import java.util.Collections;
import java.util.Comparator;

public class Adapter_CBoard extends ArrayAdapter<Pojo_Entry> {
    private Context context;

    public Adapter_CBoard(Context context) {
        super(context, R.layout.adapter_cboard, Repository_Entry_Second.getInstance().getEntries());
        this.context = context;
    }

    public void sortSecondEntries(Comparator<Pojo_Entry> comparator) {
        Collections.sort(Repository_Entry_Second.getInstance(), comparator);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        CBoardHolder cBoardHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_cboard, parent, false);
            cBoardHolder = new CBoardHolder();
            cBoardHolder.txtTitle = (TextView) view.findViewById(R.id.adapterCBoard_txtTitle);
            cBoardHolder.txtDate = (TextView) view.findViewById(R.id.adapterCBoard_txtDate);
            cBoardHolder.txtDescription = (TextView) view.findViewById(R.id.adapterCBoard_txtContent);

            view.setTag(cBoardHolder);
        } else {
            cBoardHolder = (CBoardHolder) view.getTag();
        }

        Pojo_Entry entry = getItem(position);
        if (entry != null) {
            String month = (String) android.text.format.DateFormat.format("MMM", entry.getEn_date());
            String year = (String) android.text.format.DateFormat.format("yyyy", entry.getEn_date());
            String day = (String) android.text.format.DateFormat.format("dd", entry.getEn_date());

            cBoardHolder.txtTitle.setText(entry.getEn_title());
            cBoardHolder.txtDate.setText(day + " " + month + " " + year);
            cBoardHolder.txtDescription.setText(entry.getEn_content());
        }

        return view;
    }

    private class CBoardHolder {
        TextView txtTitle;
        TextView txtDate;
        TextView txtDescription;
    }
}
