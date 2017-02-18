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
import com.jmed.condominapp.adapters.Adapter_Board;
import com.jmed.condominapp.interfaces.IBoardPresenter;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.presenters.BoardPresenterImpl;

public class List_Board extends Fragment implements IBoardPresenter.View {
    private FragmentListBoardListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_BOARD = "fragmentListBoardTag";

    BoardPresenterImpl boardPresenter;
    Adapter_Board adapter_board;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public void recieveEntryFromHome(Pojo_Entry entry) {
        boardPresenter.insertFirstEntry(entry);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
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
        boardPresenter = new BoardPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_list_board, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListBoard_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListBoard_list);

        adapter_board = new Adapter_Board(getContext(), boardPresenter.selectFirstEntries());
        listView.setDivider(null);
        listView.setAdapter(adapter_board);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageBoardOpen();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_board = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_board, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuBoard_date:
                adapter_board.sortFirstEntries(Pojo_Entry.COMPARATOR_ENTRY_DATE);
                break;
            case R.id.menuBoard_title:
                adapter_board.sortFirstEntries(Pojo_Entry.COMPARATOR_ENTRY_TITLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}