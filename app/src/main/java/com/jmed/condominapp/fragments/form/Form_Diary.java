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
import com.jmed.condominapp.repositories.Repository_Note;
import com.jmed.condominapp.pojos.Pojo_Note;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_Diary extends Fragment {
    private FragmentFormDiaryListener listCallback;
    public static final String TAG_FRAGMENT_FORM_DIARY = "fragmentFormDiaryTag";

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

    public interface FragmentFormDiaryListener {
        void onAcceptDiary(Pojo_Note note);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listCallback = (FragmentFormDiaryListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_diary, container, false);

        title = (EditText) view.findViewById(R.id.fragFormDiary_title);
        description = (EditText) view.findViewById(R.id.fragFormDiary_description);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormDiary_btn);
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

                Pojo_Note note = new Pojo_Note(profile.getUserCommunity(), date, title.getText().toString(), description.getText().toString(), false);

                listCallback.onAcceptDiary(note);
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
