package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmed.condominapp.R;

public class List_Board extends Fragment {
    private FragmentListBoardListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_BOARD = "fragmentListBoardTag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentListBoardListener {
        void onManageBoardOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListBoardListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_board, container, false);

        /*
        FloatingActionButton btnListIncicent = (FloatingActionButton) view.findViewById(R.id.btnListIncicent);
        btnListIncicent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeCallback.onManageIncidentOpen();
            }
        });
        */
        return view;
    }
}