package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jmed.condominapp.Activity_Home;
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

    public boolean recieveEntryFromHome(Pojo_Entry entry, boolean update) {
        boolean result = false;
        if (cBoardPresenter.validateSecondEntry(entry)) {
            if (update) {
                result = cBoardPresenter.updateSecondEntry(entry) == 0;
            } else {
                result = cBoardPresenter.insertSecondEntry(entry) == 0;
            }
        }
        return result;
    }

    @Override
    public void showMessage(int msg, boolean error) {
        ((Activity_Home) getActivity()).showSnackbar(getString(msg), error);
    }

    public interface FragmentListCBoardListener {
        void onManageCBoardOpen();

        void onManageCBoardOpenEdit(Pojo_Entry entry);
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

        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Dialog
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_context_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        Pojo_Entry entry = adapter_cBoard.getItem(index);

        switch (item.getItemId()) {
            case R.id.menuContext_update:
                homeCallback.onManageCBoardOpenEdit(entry);
                return true;
            case R.id.menuContext_delete:
                if (cBoardPresenter.deleteSecondEntry(entry) == 0) {
                    showMessage(R.string.deleted, false);
                    adapter_cBoard.notifyDataSetChanged();
                } else {
                    showMessage(R.string.no_deleted, true);
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}