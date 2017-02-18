package com.jmed.condominapp.fragments.form;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jmed.condominapp.R;
import com.jmed.condominapp.pojos.Pojo_Document;
import com.jmed.condominapp.preferences.files.Profile;

public class Form_Document extends Fragment {
    private FragmentFormDocumentListener listCallback;
    public static final String TAG_FRAGMENT_FORM_DOCUMENT = "fragmentFormDocumentTag";

    EditText title;
    EditText description;
    EditText link;
    FloatingActionButton btn;
    Profile profile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentFormDocumentListener {
        void onAcceptDocument(Pojo_Document document);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listCallback = (FragmentFormDocumentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_document, container, false);

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

                Pojo_Document doc = new Pojo_Document(profile.getUserCommunity(), title.getText().toString(), description.getText().toString(), link.getText().toString(), false);

                listCallback.onAcceptDocument(doc);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listCallback = null;
    }
}
