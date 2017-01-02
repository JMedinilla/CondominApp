package com.jmed.condominapp.preferences.files;

import android.content.Context;
import android.content.SharedPreferences;

public class Settings {
    private static final int MODE = Context.MODE_PRIVATE;
    private static final String FILE = "com.jmed.condominapp_preferences";

    private static final String REMEMBER = "rememberaccesskey";
    private static final String STAY = "keepuserconnected";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public Settings(Context context) {
        sharedPreferences = context.getSharedPreferences(FILE, MODE);
        editor = sharedPreferences.edit();
    }

    public boolean getRemember() {
        return sharedPreferences.getBoolean(REMEMBER, false);
    }

    public void setRemember(boolean value) {
        editor.putBoolean(REMEMBER, value).commit();
    }

    public boolean getStay() {
        return sharedPreferences.getBoolean(STAY, false);
    }

    public void setStay(boolean value) {
        editor.putBoolean(STAY, value).commit();
    }
}