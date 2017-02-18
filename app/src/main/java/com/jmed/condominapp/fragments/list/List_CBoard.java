package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_CBoard;
import com.jmed.condominapp.interfaces.ICBoardPresenter;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.presenters.CBoardPresenterImpl;

public class List_CBoard extends Fragment implements ICBoardPresenter.View {
    private FragmentListCBoardListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_CBOARD = "fragmentListCBoardTag";

    CBoardPresenterImpl cBoardPresenter;
    Adapter_CBoard adapter_cBoard;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public void recieveEntryFromHome(Pojo_Entry entry) {
        cBoardPresenter.insertSecondEntry(entry);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
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
        cBoardPresenter = new CBoardPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_list_cboard, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListCBoard_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListCBoard_list);

        adapter_cBoard = new Adapter_CBoard(getContext(), cBoardPresenter.selectSecondEntries());
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_cboard, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuCBoard_date:
                adapter_cBoard.sortSecondEntries(Pojo_Entry.COMPARATOR_ENTRY_DATE);
                break;
            case R.id.menuCBoard_title:
                adapter_cBoard.sortSecondEntries(Pojo_Entry.COMPARATOR_ENTRY_DATE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}