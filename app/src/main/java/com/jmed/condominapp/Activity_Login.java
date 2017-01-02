package com.jmed.condominapp;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.jmed.condominapp.Repositories.Repository_User;
import com.jmed.condominapp.pojo.Pojo_User;
import com.jmed.condominapp.preferences.files.Profile;
import com.jmed.condominapp.preferences.files.Settings;

import java.util.List;

public class Activity_Login extends AppCompatActivity {

    private EditText activity_login_edtKey;
    private CheckBox activity_login_chbRemember;
    private CheckBox activity_login_chbStay;
    private Profile preferences_profile;
    private Settings preferences_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferences_settings = new Settings(Activity_Login.this);
        preferences_profile = new Profile(Activity_Login.this);

        initializeComponents();

        if (preferences_settings.getRemember()) {
            activity_login_edtKey.setText(preferences_profile.getAccess());
        } else {
            preferences_settings.setStay(false);
        }
        if (preferences_settings.getStay()) {
            startActivity(new Intent(Activity_Login.this, Activity_Home.class));
            finish();
        }
        if (activity_login_chbRemember.isChecked()) {
            activity_login_chbStay.setEnabled(true);
        }
    }

    private void initializeComponents() {
        activity_login_edtKey = (EditText) findViewById(R.id.activity_login_edtKey);
        activity_login_chbRemember = (CheckBox) findViewById(R.id.activity_login_chbRemember);
        activity_login_chbStay = (CheckBox) findViewById(R.id.activity_login_chbStay);

        activity_login_chbRemember.setChecked(preferences_settings.getRemember());
        activity_login_chbStay.setChecked(preferences_settings.getStay());

        activity_login_chbRemember.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences_settings.setRemember(isChecked);
                if (isChecked) {
                    activity_login_chbStay.setEnabled(true);
                } else {
                    activity_login_chbStay.setChecked(false);
                    activity_login_chbStay.setEnabled(false);
                }
            }
        });
        activity_login_chbStay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences_settings.setStay(isChecked);
            }
        });
    }

    public void getOnClickLoginMain(View view) {
        switch (view.getId()) {
            case R.id.activity_login_btnScan:
                //
                break;
            case R.id.activity_login_btnJoin:
                //Si el usuario tiene categoría de administrador, se le pasa a la
                //ventana de selección de comunidad
                /*
                startActivity(new Intent(Activity_Login_Main.this, Activity_Login_Admin.class));
                finish();
                */
                //Si es un vecino, pos palante y tal
                neighbourLogin(activity_login_edtKey.getText().toString());
                break;
        }
    }

    private void neighbourLogin(String keyP) {
        boolean result = false;
        Pojo_User tmpUser;
        List<Pojo_User> tmpUsers = Repository_User.getInstance().getUsers();
        for (int i = 0; i < tmpUsers.size(); i++) {
            if (keyP.equals(tmpUsers.get(i).getUs_id())) {
                tmpUser = new Pojo_User(
                        tmpUsers.get(i).getUs_id(),
                        tmpUsers.get(i).getUs_community(),
                        tmpUsers.get(i).getUs_floor(),
                        tmpUsers.get(i).getUs_door(),
                        tmpUsers.get(i).getUs_phone(),
                        tmpUsers.get(i).getUs_mail(),
                        tmpUsers.get(i).getUs_name(),
                        tmpUsers.get(i).getUs_category());

                preferences_profile.setAccess(tmpUser.getUs_id());
                preferences_profile.setUserCommunity(tmpUser.getUs_community());
                preferences_profile.setUserFloor(tmpUser.getUs_floor());
                preferences_profile.setUserDoor(tmpUser.getUs_door());
                preferences_profile.setUserPhone(tmpUser.getUs_phone());
                preferences_profile.setUserMail(tmpUser.getUs_mail());
                preferences_profile.setUserName(tmpUser.getUs_name());
                preferences_profile.setUserCategory(tmpUser.getUs_category());

                result = true;
                startActivity(new Intent(Activity_Login.this, Activity_Home.class));
                finish();
            }
        }
        if (!result) {
            Pojo_User us = new Pojo_User("", 999999, "", "", "", "", "", Pojo_User.NEIGHBOUR);
            preferences_profile.setAccess(us.getUs_id());
            preferences_profile.setUserCommunity(us.getUs_community());
            preferences_profile.setUserFloor(us.getUs_floor());
            preferences_profile.setUserDoor(us.getUs_door());
            preferences_profile.setUserPhone(us.getUs_phone());
            preferences_profile.setUserMail(us.getUs_mail());
            preferences_profile.setUserName(us.getUs_name());
            preferences_profile.setUserCategory(us.getUs_category());
            Snackbar.make(findViewById(R.id.activity_login), "El usuario no existe", Snackbar.LENGTH_LONG).show();
        }
    }
}