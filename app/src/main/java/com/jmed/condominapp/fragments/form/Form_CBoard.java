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
import com.jmed.condominapp.Repositories.Repository_Entry_Second;
import com.jmed.condominapp.pojo.Pojo_Entry;
import com.jmed.condominapp.pojo.Pojo_User;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_CBoard extends Fragment {
    public static final String TAG_FRAGMENT_FORM_CBOARD = "fragmentFormCBoardTag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_cboard, container, false);

        final EditText title;
        final EditText description;
        FloatingActionButton btn;
        final Profile profile;

        title = (EditText) view.findViewById(R.id.fragFormCBoard_title);
        description = (EditText) view.findViewById(R.id.fragFormCBoard_description);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormCBoard_btn);
        profile = new Profile(getContext());

        final Pojo_User user = new Pojo_User(profile.getAccess(), profile.getUserCommunity(), profile.getUserFloor(), profile.getUserDoor(),
                profile.getUserPhone(), profile.getUserMail(), profile.getUserName(), profile.getUserCategory(), profile.getUserPhoto());

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

                Pojo_Entry entry = new Pojo_Entry(user, title.getText().toString(), description.getText().toString(), date, Pojo_Entry.SECOND);

                if (!Repository_Entry_Second.getInstance().contains(entry)) {
                    Repository_Entry_Second.getInstance().add(entry);
                    getActivity().onBackPressed();
                } else {
                    Toast.makeText(getContext(), "Already exists", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}
