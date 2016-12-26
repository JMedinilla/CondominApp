package com.jmed.condominapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.sackcentury.shinebuttonlib.ShineButton;

public class Activity_Login extends AppCompatActivity {

    ShineButton shineButton;
    ExpandableTextView expandableTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        shineButton = (ShineButton) findViewById(R.id.po_image1);
        shineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shineButton.isChecked()) {
                    Toast.makeText(Activity_Login.this, "Marcado", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Activity_Login.this, "Desmarcado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        expandableTextView = (ExpandableTextView) findViewById(R.id.expand_text_view);
        expandableTextView.setText("dsfjkhbsadkifykaslidgbluiadyrgblauidsfjkhbsadkifykaslidgbluiadyrgblauirgbliuaregbliadsfjkhbsadkifykaslidgbluiadyrgblauirgbliuaregbliadsfjkhbsadkifykaslidgbluiadyrgblauirgbliuaregbliadsfjkhbsadkifykaslidgbluiadyrgblauirgbliuaregbliargbliuaregblia");
    }
}
