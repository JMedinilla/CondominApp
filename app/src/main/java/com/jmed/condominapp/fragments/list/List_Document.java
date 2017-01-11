package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_Document;


public class List_Document extends Fragment {
    private FragmentListDocumentListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_DOCUMENT = "fragmentListDocumentTag";

    Adapter_Document adapter_document;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentListDocumentListener {
        void onManageDocumentOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListDocumentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_document, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListDocument_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListDocument_list);

        adapter_document = new Adapter_Document(getContext());
        listView.setDivider(null);
        listView.setAdapter(adapter_document);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageDocumentOpen();
            }
        });

        return view;
    }
}