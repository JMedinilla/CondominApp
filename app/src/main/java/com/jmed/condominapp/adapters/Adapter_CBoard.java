package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Entry_Second;
import com.jmed.condominapp.pojo.Pojo_Entry;

import java.util.ArrayList;

public class Adapter_CBoard extends ArrayAdapter<Pojo_Entry> {
    private Context context;
    private Repository_Entry_Second repository;

    public Adapter_CBoard(Context context) {
        super(context, R.layout.adapter_cboard, new ArrayList<>(Repository_Entry_Second.getInstance().getEntries()));
        this.context = context;
        this.repository = Repository_Entry_Second.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        CBoardHolder cBoardHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_board, parent, false);
            cBoardHolder = new CBoardHolder();
        } else {
            cBoardHolder = (CBoardHolder) view.getTag();
        }

        Pojo_Entry entry = getItem(position);
        if (entry != null) {
            //
        }

        return view;
    }

    private class CBoardHolder {
        //
    }
}
