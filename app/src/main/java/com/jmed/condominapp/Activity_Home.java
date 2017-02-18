package com.jmed.condominapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
import com.jmed.condominapp.pojos.Pojo_Document;
import com.jmed.condominapp.pojos.Pojo_Entry;
import com.jmed.condominapp.pojos.Pojo_Incident;
import com.jmed.condominapp.pojos.Pojo_Meeting;
import com.jmed.condominapp.pojos.Pojo_Note;
import com.jmed.condominapp.preferences.application.Settings;

public class Activity_Home extends AppCompatActivity
        implements
        NavigationView.OnNavigationItemSelectedListener, Home.FragmentHomeListener,
        List_Board.FragmentListBoardListener, List_CBoard.FragmentListCBoardListener, List_Community.FragmentListCommunityListener,
        List_Diary.FragmentListDiaryListener, List_Document.FragmentListDocumentListener, List_Incident.FragmentListIncidentListener,
        List_Meeting.FragmentListMeetingListener, List_User.FragmentListUserListener,
        Form_Incident.FragmentFormIncidentListener, Form_Board.FragmentFormBoardListener, Form_CBoard.FragmentFormCBoardListener,
        Form_Diary.FragmentFormDiaryListener, Form_Document.FragmentFormDocumentListener, Form_Meeting.FragmentFormMeetingListener {

    List_Incident list_incident;
    List_Diary list_diary;
    List_Board list_board;
    List_CBoard list_cBoard;
    List_Document list_document;
    List_Meeting list_meeting;
    List_Information list_information;
    List_User list_user;
    List_Community list_community;
    Form_Board form_board;
    Form_CBoard form_cBoard;
    Form_Diary form_diary;
    Form_Document form_document;
    Form_Incident form_incident;
    Form_Meeting form_meeting;

    private Toolbar homeToolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private boolean exit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_navigation);

        list_incident = new List_Incident();
        list_diary = new List_Diary();
        list_board = new List_Board();
        list_cBoard = new List_CBoard();
        list_document = new List_Document();
        list_meeting = new List_Meeting();
        list_information = new List_Information();
        list_user = new List_User();
        list_community = new List_Community();

        homeToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(homeToolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setupDrawerContent();
        showHome();
    }

    public void showHome() {
        Home fragmentHome = new Home();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, fragmentHome, "list_incident");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentIncidentsButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_incident, "list_incident");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentDiaryButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_diary, "list_diary");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentBoardButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_board, "list_board");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentCBoardButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_cBoard, "list_cBoard");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentDocumentsButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_document, "list_document");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentMeetingsButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_meeting, "list_meeting");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentInformationButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_information, "list_information");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentUsersButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_user, "list_user");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentCommunitiesButtonTap() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, list_community, "list_community");
        fragmentTransaction.commit();
    }

    @Override
    public void onHomeFragmentProfileButtonTap() {
        com.jmed.condominapp.fragments.Profile profile = new com.jmed.condominapp.fragments.Profile();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, profile, "profile");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageBoardOpen() {
        form_board = new Form_Board();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_board);
        fragmentTransaction.addToBackStack("form_board");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageCBoardOpen() {
        form_cBoard = new Form_CBoard();
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
        form_diary = new Form_Diary();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_diary);
        fragmentTransaction.addToBackStack("form_diary");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageDocumentOpen() {
        form_document = new Form_Document();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_document);
        fragmentTransaction.addToBackStack("form_document");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageIncidentOpen() {
        form_incident = new Form_Incident();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_incident);
        fragmentTransaction.addToBackStack("form_incident");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageMeetingOpen() {
        form_meeting = new Form_Meeting();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.activity_home, form_meeting);
        fragmentTransaction.addToBackStack("form_meeting");
        fragmentTransaction.commit();
    }

    @Override
    public void onManageUserOpen() {
        //Formulario USER
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else if (getSupportFragmentManager().getBackStackEntryCount() > 0 || exit)
            super.onBackPressed();
        else {
            exit = true;
            Snackbar.make(findViewById(R.id.activity_home), getString(R.string.back_pressed_twice), Snackbar.LENGTH_SHORT)
                    .addCallback(new Snackbar.Callback() {
                        @Override
                        public void onDismissed(Snackbar snackbar, int event) {
                            super.onDismissed(snackbar, event);
                            exit = false;
                        }
                    }).show();
        }

    }

    public void showSnackbar(String msg, boolean error) {
        Snackbar snackbar;
        snackbar = Snackbar.make(findViewById(R.id.activity_home), msg, Snackbar.LENGTH_SHORT);
        View snackBarView = snackbar.getView();
        TextView textView = (TextView) snackBarView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));
        if (error) {
            snackBarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorError));
        } else {
            snackBarView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorSuccess));
        }
        snackbar.show();
    }

    private void setupDrawerContent() {
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        switch (item.getItemId()) {
            case R.id.navIncidents:
                onHomeFragmentIncidentsButtonTap();
                break;
            case R.id.navDiary:
                onHomeFragmentDiaryButtonTap();
                break;
            case R.id.navBoard:
                onHomeFragmentBoardButtonTap();
                break;
            case R.id.navCBoard:
                onHomeFragmentCBoardButtonTap();
                break;
            case R.id.navDocuments:
                onHomeFragmentDocumentsButtonTap();
                break;
            case R.id.navMeetings:
                onHomeFragmentMeetingsButtonTap();
                break;
            case R.id.navInformation:
                onHomeFragmentInformationButtonTap();
                break;
            case R.id.navProfile:
                onHomeFragmentProfileButtonTap();
                break;
            case R.id.navUsers:
                onHomeFragmentUsersButtonTap();
                break;
            case R.id.navCommunities:
                onHomeFragmentCommunitiesButtonTap();
                break;
            case R.id.twoNavShop:
                //
                break;
            case R.id.twoNavGame:
                //
                break;
            case R.id.threeNavSettings:
                Intent intent = new Intent(Activity_Home.this, Settings.class);
                startActivity(intent);
                break;
            case R.id.threeNavHelp:
                //
                break;
            case R.id.fourNavAbout:
                break;
            default:
                item.setChecked(false);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        setTitle(item.getTitle());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAcceptIncident(Pojo_Incident incident) {
        if (list_incident.recieveIncidentFromHome(incident)) {
            onBackPressed();
        }
    }

    @Override
    public void onAcceptBoard(Pojo_Entry entry) {
        if (list_board.recieveEntryFromHome(entry)) {
            onBackPressed();
        }
    }

    @Override
    public void onAcceptCBoard(Pojo_Entry entry) {
        if (list_cBoard.recieveEntryFromHome(entry)) {
            onBackPressed();
        }
    }

    @Override
    public void onAcceptDiary(Pojo_Note note) {
        if (list_diary.recieveNoteFromHome(note)) {
            onBackPressed();
        }
    }

    @Override
    public void onAcceptDocument(Pojo_Document document) {
        if (list_document.recieveDocumentFromHome(document)) {
            onBackPressed();
        }
    }

    @Override
    public void onAcceptMeeting(Pojo_Meeting meeting) {

    }
}