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
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.preferences.files.Profile;

import java.util.Calendar;
import java.util.Date;

public class Form_CBoard extends Fragment {
    private boolean UPDATE_MODE = false;
    private Pojo_Entry update = null;

    private FragmentFormCBoardListener listCallback;
    public static final String TAG_FRAGMENT_FORM_CBOARD = "fragmentFormCBoardTag";

    EditText title;
    EditText description;
    FloatingActionButton btn;
    Profile profile;

    /**
     * Listener from the fragment to the Activity
     */
    public interface FragmentFormCBoardListener {
        void onAcceptCBoard(Pojo_Entry entry, boolean update);
    }

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

        title = (EditText) view.findViewById(R.id.fragFormCBoard_title);
        description = (EditText) view.findViewById(R.id.fragFormCBoard_description);
        btn = (FloatingActionButton) view.findViewById(R.id.fragFormCBoard_btn);
        profile = new Profile(getContext());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UPDATE_MODE) {
                    listCallback.onAcceptCBoard(update, true);
                } else {
                    Calendar calendar = Calendar.getInstance();
                    Date date = new Date(calendar.getTimeInMillis());
                    Pojo_Entry entry = new Pojo_Entry(profile.getUserId(), profile.getUserCommunity(), title.getText().toString(), description.getText().toString(), date, Pojo_Entry.SECOND, false);
                    listCallback.onAcceptCBoard(entry, false);
                }
            }
        });

        Pojo_Entry pojo_entry = getArguments().getParcelable("pojo_entrys");
        if (pojo_entry != null) {
            update = pojo_entry;
            UPDATE_MODE = true;
            title.setText(pojo_entry.getEn_title());
            description.setText(pojo_entry.getEn_content());
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listCallback = (FragmentFormCBoardListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listCallback = null;
    }
}
