package com.jmed.condominapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jmed.condominapp.fragments.Home;
import com.jmed.condominapp.fragments.form.Form_Board;
import com.jmed.condominapp.fragments.form.Form_CBoard;
import com.jmed.condominapp.fragments.form.Form_Diary;
import com.jmed.condominapp.fragments.form.Form_Document;
import com.jmed.condominapp.fragments.form.Form_Incident;
import com.jmed.condominapp.fragments.form.Form_Meeting;
import com.jmed.condominapp.fragments.list.List_Board;
import com.jmed.condominapp.fragments.list.List_CBoard;
import com.jmed.condominapp.fragments.list.List_Community;
import com.jmed.condominapp.fragments.list.List_Diary;
import com.jmed.condominapp.fragments.list.List_Document;
import com.jmed.condominapp.fragments.list.List_Incident;
import com.jmed.condominapp.fragments.list.List_Information;
import com.jmed.condominapp.fragments.list.List_Meeting;
import com.jmed.condominapp.fragments.list.List_User;
import com.jmed.condominapp.preferences.application.Profile;
import com.jmed.condominapp.preferences.application.Settings;

public class Activity_Home extends AppCompatActivity
        implements Home.FragmentHomeListener, List_Board.FragmentListBoardListener, List_CBoard.FragmentListCBoardListener,
        List_Community.FragmentListCommunityListener, List_Diary.FragmentListDiaryListener, List_Document.FragmentListDocumentListener,
        List_Incident.FragmentListIncidentListener, List_Meeting.FragmentListMeetingListener, List_User.FragmentListUserListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Home fragmentHome = (Home) getSupportFragmentManager().findFragmentByTag(Home.TAG_FRAGMENT_HOME);
        if (fragmentHome == null) {
            fragmentHome = new Home();
            getSupportFragmentManager().beginTransaction().add(R.id.activity_home, fragmentHome, Home.TAG_FRAGMENT_HOME).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.action_home_settings:
                intent = new Intent(Activity_Home.this, Settings.class);
                startActivity(intent);
                break;
            case R.id.action_home_about:
                final AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Home.this);
                View dialoglayout = View.inflate(Activity_Home.this, R.layout.dialog_about, null);
                builder.setCancelable(false);
                builder.setView(dialoglayout);
                builder.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                builder.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onHomeFragmentIncidentsButtonTap() {
        List_Incident list_incident = new List_Incident();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_incident);
        fragmentTransaction.addToBackStack("list_incident");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentDiaryButtonTap() {
        List_Diary list_diary = new List_Diary();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_diary);
        fragmentTransaction.addToBackStack("list_diary");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentBoardButtonTap() {
        List_Board list_board = new List_Board();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_board);
        fragmentTransaction.addToBackStack("list_board");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentCBoardButtonTap() {
        List_CBoard list_cBoard = new List_CBoard();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_cBoard);
        fragmentTransaction.addToBackStack("list_cBoard");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentDocumentsButtonTap() {
        List_Document list_document = new List_Document();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_document);
        fragmentTransaction.addToBackStack("list_document");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentMeetingsButtonTap() {
        List_Meeting list_meeting = new List_Meeting();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_meeting);
        fragmentTransaction.addToBackStack("list_meeting");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentInformationButtonTap() {
        List_Information list_information = new List_Information();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_information);
        fragmentTransaction.addToBackStack("list_information");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentUsersButtonTap() {
        List_User list_user = new List_User();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_user);
        fragmentTransaction.addToBackStack("list_user");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentCommunitiesButtonTap() {
        List_Community list_community = new List_Community();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_community);
        fragmentTransaction.addToBackStack("list_community");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentProfileButtonTap() {
        com.jmed.condominapp.fragments.Profile profile = new com.jmed.condominapp.fragments.Profile();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, profile);
        fragmentTransaction.addToBackStack("profile");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageBoardOpen() {
        Form_Board form_board = new Form_Board();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_board);
        fragmentTransaction.addToBackStack("form_board");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageCBoardOpen() {
        Form_CBoard form_cBoard = new Form_CBoard();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_cBoard);
        fragmentTransaction.addToBackStack("form_cBoard");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageCommunityOpen() {
        //Formulario COMMUNITY
    }

    @Override
    public void onManageDiaryOpen() {
        Form_Diary form_diary = new Form_Diary();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_diary);
        fragmentTransaction.addToBackStack("form_diary");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageDocumentOpen() {
        Form_Document form_document = new Form_Document();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_document);
        fragmentTransaction.addToBackStack("form_document");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageIncidentOpen() {
        Form_Incident form_incident = new Form_Incident();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_incident);
        fragmentTransaction.addToBackStack("form_incident");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageMeetingOpen() {
        Form_Meeting form_meeting = new Form_Meeting();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_meeting);
        fragmentTransaction.addToBackStack("form_meeting");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageUserOpen() {
        //Formulario USER
    }
}