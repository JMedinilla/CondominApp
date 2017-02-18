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
import android.widget.Toast;

import com.jmed.condominapp.R;
import com.jmed.condominapp.repositories.Repository_Entry_Second;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.pojos.Pojo_User;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_CBoard extends Fragment {
    private FragmentFormCBoardListener listCallback;
    public static final String TAG_FRAGMENT_FORM_CBOARD = "fragmentFormCBoardTag";

    EditText title;
    EditText description;
    FloatingActionButton btn;
    Profile profile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentFormCBoardListener {
        void onAcceptCBoard(Pojo_Entry entry);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listCallback = (FragmentFormCBoardListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_cboard, container, false);

        title = (EditText) view.findViewById(R.id.fragFormCBoard_title);
        description = (EditText) view.findViewById(R.id.fragFormCBoard_description);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormCBoard_btn);
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

                Calendar calendar = Calendar.getInstance();
                Date date = new Date(calendar.getTimeInMillis());

                Pojo_Entry entry = new Pojo_Entry(profile.getUserId(), title.getText().toString(), description.getText().toString(), date, Pojo_Entry.SECOND, false);

                listCallback.onAcceptCBoard(entry);
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
