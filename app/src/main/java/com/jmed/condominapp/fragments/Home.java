package com.jmed.condominapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jmed.condominapp.R;

public class Home extends Fragment {
    private FragmentHomeListener homeCallback;
    public static final String TAG_FRAGMENT_HOME = "fragmentHomeTag";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public interface FragmentHomeListener {
        void onHomeFragmentIncidentsButtonTap();

        void onHomeFragmentDiaryButtonTap();

        void onHomeFragmentBoardButtonTap();

        void onHomeFragmentCBoardButtonTap();

        void onHomeFragmentDocumentsButtonTap();

        void onHomeFragmentMeetingsButtonTap();

        void onHomeFragmentInformationButtonTap();

        void onHomeFragmentUsersButtonTap();

        void onHomeFragmentCommunitiesButtonTap();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentHomeListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnHomeIncidents = (Button) view.findViewById(R.id.btnHomeIncidents);
        btnHomeIncidents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeCallback.onHomeFragmentIncidentsButtonTap();
            }
        });
        Button btnHomeDiary = (Button) view.findViewById(R.id.btnHomeDiary);
        btnHomeDiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentDiaryButtonTap();
            }
        });
        Button btnHomeBoard;
        btnHomeBoard = (Button) view.findViewById(R.id.btnHomeBoard);
        btnHomeBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentBoardButtonTap();
            }
        });
        Button btnHomeCBoard = (Button) view.findViewById(R.id.btnHomeCBoard);
        btnHomeCBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentCBoardButtonTap();
            }
        });
        Button btnHomeDocuments = (Button) view.findViewById(R.id.btnHomeDocuments);
        btnHomeDocuments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentDocumentsButtonTap();
            }
        });
        Button btnHomeMeetings = (Button) view.findViewById(R.id.btnHomeMeetings);
        btnHomeMeetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentMeetingsButtonTap();
            }
        });
        Button btnHomeInformation = (Button) view.findViewById(R.id.btnHomeInformation);
        btnHomeInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentInformationButtonTap();
            }
        });
        Button btnHomeUsers = (Button) view.findViewById(R.id.btnHomeUsers);
        btnHomeUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentUsersButtonTap();
            }
        });
        Button btnHomeCommunities = (Button) view.findViewById(R.id.btnHomeCommunities);
        btnHomeCommunities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onHomeFragmentCommunitiesButtonTap();
            }
        });
        return view;
    }
}