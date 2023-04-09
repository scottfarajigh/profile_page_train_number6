package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {

//    public static final String KEY_NAME=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        TextView textView = findViewById(R.id.editText);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        String fullName = getIntent().getStringExtra(MainActivity.EXTRA_KEY_FUULNAME);

        EditText editText =findViewById(R.id.et_editProfile);
        editText.setText(fullName);
        Button doneBtn=findViewById(R.id.btn_editProfile_done);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View view) {
                String fullName=editText.getText().toString();
                Intent intent = new Intent();
                intent.putExtra(MainActivity.EXTRA_KEY_FUULNAME ,fullName);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}