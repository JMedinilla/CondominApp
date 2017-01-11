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
import com.jmed.condominapp.adapters.Adapter_CBoard;

public class List_CBoard extends Fragment {
    private FragmentListCBoardListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_CBOARD = "fragmentListCBoardTag";

    Adapter_CBoard adapter_cBoard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface FragmentListCBoardListener {
        void onManageCBoardOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListCBoardListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_cboard, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListCBoard_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListCBoard_list);

        adapter_cBoard = new Adapter_CBoard(getContext());
        listView.setDivider(null);
        listView.setAdapter(adapter_cBoard);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageCBoardOpen();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_cBoard = null;
    }
}