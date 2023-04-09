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
    public static final String EXTRA_KEY_FUULNAME="fullName";
    
    ActivityResultLauncher<Intent> ActivityResulLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult activityResult) {
            int result = activityResult.getResultCode();
            Intent data = activityResult.getData();

            if (result == Activity.RESULT_OK && data!=null) {
                String fullName = data.getStringExtra(EXTRA_KEY_FUULNAME);
                TextView textView=findViewById(R.id.main_fullName);
                textView.setText(fullName);
            }
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button saveInformationButton =findViewById(R.id.btn_main_saveInformation);
        saveInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"User Clicked On Save Information Button",Toast.LENGTH_LONG).show();
            }
        });
        CheckBox androidSkillCheckBox=findViewById(R.id.checkBox_main_android);
        androidSkillCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"Android Skill Is Checked!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"Android Skill Is not Checked!",Toast.LENGTH_LONG).show();
                }
            }
        });
        CheckBox deepSkillCheckBox=findViewById(R.id.checkBox_main_deepLearning);
        deepSkillCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"deepLearning Skill Is Checked!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"deepLearning Skill Is not Checked!",Toast.LENGTH_LONG).show();
                }
            }
        });
        CheckBox uiSkillCheckBox=findViewById(R.id.checkBox_main_ui);
        uiSkillCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this,"ui/ux Skill Is Checked!",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this,"ui/ux Skill Is not Checked!",Toast.LENGTH_LONG).show();
                }
            }
        });
        RadioGroup radioGroup =findViewById(R.id.radioGroup_main);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_alborz:
                        Toast.makeText(MainActivity.this,"Alborz Is Checked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.rb_gilan:
                        Toast.makeText(MainActivity.this,"Gilan Is Checked",Toast.LENGTH_LONG).show();
                        break;
                        case R.id.rb_tehran:
                        Toast.makeText(MainActivity.this,"Tehran Is Checked",Toast.LENGTH_LONG).show();
                }
            }
        });
        Button editProfileBtn = findViewById(R.id.main_editProfile_btn);
        editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this,EditProfileActivity.class);
                TextView fullNametv = findViewById(R.id.main_fullName);
                intent.putExtra(EXTRA_KEY_FUULNAME,fullNametv.getText());
//             startActivityForResult(intent,1001);
                ActivityResulLauncher.launch(intent);
            }

        });
        Button viewWebsite = findViewById(R.id.viewWeb_btn);
        viewWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Intent.ACTION_VIEW, Uri.parse("https://7learn.com"));
                startActivity(intent);
            }
        });
    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//    }
}