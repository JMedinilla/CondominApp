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
import com.jmed.condominapp.adapters.Adapter_Meeting;
import com.jmed.condominapp.interfaces.IMeetingPresenter;
import com.jmed.condominapp.pojos.Pojo_Meeting;
import com.jmed.condominapp.presenters.MeetingPresenterImpl;

public class List_Meeting extends Fragment implements IMeetingPresenter.View {
    private FragmentListMeetingListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_MEETING = "fragmentListMeetingTag";

    MeetingPresenterImpl meetingPresenter;
    Adapter_Meeting adapter_meeting;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    @Override
    public void showMessage(int msg, boolean error) {
        ((Activity_Home) getActivity()).showSnackbar(getString(msg), error);
    }

    public interface FragmentListMeetingListener {
        void onManageMeetingOpen();

        void onManageMeetingOpenEdit(Pojo_Meeting meeting);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListMeetingListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        meetingPresenter = new MeetingPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_list_meeting, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListMeeting_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListMeeting_list);

        adapter_meeting = new Adapter_Meeting(getContext(), meetingPresenter.selectMeetings());
        listView.setDivider(null);
        listView.setAdapter(adapter_meeting);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageMeetingOpen();
            }
        });

        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pojo_Meeting meeting = adapter_meeting.getItem(i);
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_meeting = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_meetings, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuMeetings_date:
                adapter_meeting.sortMeetings(Pojo_Meeting.COMPARATOR_MEETING_DATE);
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
        switch (item.getItemId()) {
            case R.id.menuContext_update:
                return true;
            case R.id.menuContext_delete:
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}