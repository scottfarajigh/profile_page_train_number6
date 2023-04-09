package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_STRING_USERNAME = "userName";
    public static final String EXTRA_STRING_USERBIO = "userBio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button SaveInformationBtn =findViewById(R.id.main_save_information_btn);
        SaveInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Informations Saved !",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox AndroidSkillCb =findViewById(R.id.main_android_cb);
        AndroidSkillCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this , "You Checked ANDROID",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox DeepLearningSkillCb =findViewById(R.id.main_deepLearning_cb);
        DeepLearningSkillCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this , "You Checked DEEPLEARNING",Toast.LENGTH_LONG).show();
            }
        });

        CheckBox uISkillCb =findViewById(R.id.main_ui_cb);
        uISkillCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this , "You Checked UI/UX",Toast.LENGTH_LONG).show();
            }
        });

        RadioGroup radioGroup = findViewById(R.id.main_radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.main_tehran_rb:
                        Toast.makeText(MainActivity.this , "You Selected TEHRAN",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.main_alborz_rb:
                        Toast.makeText(MainActivity.this , "You Selected ALBORZ",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.main_gilan_rb:
                        Toast.makeText(MainActivity.this , "You Selected GILAN",Toast.LENGTH_LONG).show();
                }
            }
        });
        Button editProfileBtn = findViewById(R.id.main_editProfile_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,activity_editProfile.class);
                TextView userNameTv = findViewById(R.id.main_userName_tv);
                intent.putExtra(EXTRA_STRING_USERNAME,userNameTv.getText());
                TextView userBioTv = findViewById(R.id.main_bio);
                intent.putExtra(EXTRA_STRING_USERBIO,userBioTv.getText());
                startActivityForResult(intent,4224);
            }
        });

        Button viewWebBtn = findViewById(R.id.main_viewWeb_btn);
        viewWebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://digikala.com"));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 4224 && resultCode == RESULT_OK && data != null){
            String userName = data.getStringExtra(EXTRA_STRING_USERNAME);
            String userBio = data.getStringExtra(EXTRA_STRING_USERBIO);
            TextView textView2 = findViewById(R.id.main_bio);
            textView2.setText(userBio);
            TextView textView = findViewById(R.id.main_userName_tv);
            textView.setText(userName);
        }

    }
}