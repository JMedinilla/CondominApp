package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Document;
import com.jmed.condominapp.pojo.Pojo_Document;

import java.util.ArrayList;

public class Adapter_Document extends ArrayAdapter<Pojo_Document> {
    private Context context;
    private Repository_Document repository;

    public Adapter_Document(Context context) {
        super(context, R.layout.adapter_document, new ArrayList<>(Repository_Document.getInstance().getDocuments()));
        this.context = context;
        this.repository = Repository_Document.getInstance();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        DocumentHolder documentHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_board, parent, false);
            documentHolder = new DocumentHolder();
        } else {
            documentHolder = (DocumentHolder) view.getTag();
        }

        Pojo_Document document = getItem(position);
        if (document != null) {
            //
        }

        return view;
    }

    private class DocumentHolder {
        //
    }
}
