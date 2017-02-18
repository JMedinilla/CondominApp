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

import com.jmed.condominapp.Activity_Home;
import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_Diary;
import com.jmed.condominapp.interfaces.IDiaryPresenter;
import com.jmed.condominapp.pojos.Pojo_Note;
import com.jmed.condominapp.presenters.DiaryPresenterImpl;

public class List_Diary extends Fragment implements IDiaryPresenter.View {
    private FragmentListDiaryListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_DIARY = "fragmentListDiaryTag";

    DiaryPresenterImpl diaryPresenter;
    Adapter_Diary adapter_diary;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public boolean recieveNoteFromHome(Pojo_Note note) {
        boolean result = false;
        if (diaryPresenter.validateNote(note)) {
            result = diaryPresenter.insertNote(note) == 0;
        }
        return result;
    }

    @Override
    public void showMessage(int msg, boolean error) {
        ((Activity_Home) getActivity()).showSnackbar(getString(msg),error);
    }

    public interface FragmentListDiaryListener {
        void onManageDiaryOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListDiaryListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        diaryPresenter = new DiaryPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_list_diary, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListDiary_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListDiary_list);

        adapter_diary = new Adapter_Diary(getContext(), diaryPresenter.selectNotes());
        listView.setDivider(null);
        listView.setAdapter(adapter_diary);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageDiaryOpen();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_diary = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_diary, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDiary_title:
                adapter_diary.sortDiaries(Pojo_Note.COMPARATOR_NOTE_TITLE);
                break;
            case R.id.menuDiary_date:
                adapter_diary.sortDiaries(Pojo_Note.COMPARATOR_NOTE_DATE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}