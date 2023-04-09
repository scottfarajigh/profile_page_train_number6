package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_editProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        String userName = getIntent().getStringExtra("userName");
        EditText userNameEt = findViewById(R.id.editProfile_userName_et);
        userNameEt.setText(userName);
        Button DoneBtn = findViewById(R.id.editProfile_done);
        DoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("userName",userName);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}