package com.jmed.condominapp.fragments.form;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.jmed.condominapp.R;
import com.jmed.condominapp.Repositories.Repository_Document;
import com.jmed.condominapp.pojo.Pojo_Document;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_Document extends Fragment {
    public static final String TAG_FRAGMENT_FORM_DOCUMENT = "fragmentFormDocumentTag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_document, container, false);

        final EditText title;
        final EditText description;
        final EditText link;
        FloatingActionButton btn;
        final Profile profile;

        title = (EditText) view.findViewById(R.id.fragFormDocument_title);
        description = (EditText) view.findViewById(R.id.fragFormDocument_description);
        link = (EditText) view.findViewById(R.id.fragFormDocument_link);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormDocument_btn);
        profile = new Profile(getContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (title.getText().toString().length() == 0) {
                    title.setText("default");
                }
                if (description.getText().toString().length() == 0) {
                    description.setText("default");
                }
                if (link.getText().toString().length() == 0) {
                    link.setText("default");
                }

                Pojo_Document doc = new Pojo_Document(profile.getUserCommunity(), title.getText().toString(), description.getText().toString(), link.getText().toString());

                if (!Repository_Document.getInstance().contains(doc)) {
                    Repository_Document.getInstance().add(doc);
                    getActivity().onBackPressed();
                } else {
                    Toast.makeText(getContext(), "Already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
