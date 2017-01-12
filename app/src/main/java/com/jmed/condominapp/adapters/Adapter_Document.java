package com.jmed.condominapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Document;
import com.jmed.condominapp.pojo.Pojo_Document;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Adapter_Document extends ArrayAdapter<Pojo_Document> {
    private Context context;

    public Adapter_Document(Context context) {
        super(context, R.layout.adapter_document, Repository_Document.getInstance().getDocuments());
        this.context = context;
    }

    public void sortDocuments(Comparator<Pojo_Document> comparator) {
        Collections.sort(Repository_Document.getInstance(), comparator);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        DocumentHolder documentHolder;

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.adapter_document, parent, false);
            documentHolder = new DocumentHolder();
            documentHolder.txtTitle = (TextView) view.findViewById(R.id.adapterDocument_txtTitle);
            documentHolder.txtDescription = (TextView) view.findViewById(R.id.adapterDocument_txtContent);

            view.setTag(documentHolder);
        } else {
            documentHolder = (DocumentHolder) view.getTag();
        }

        Pojo_Document document = getItem(position);
        if (document != null) {
            documentHolder.txtTitle.setText(document.getDo_title());
            documentHolder.txtDescription.setText(document.getDo_description());
        }

        return view;
    }

    private class DocumentHolder {
        TextView txtTitle;
        TextView txtDescription;
    }
}
