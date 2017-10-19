package com.example.admin_user.sharedpreferencesproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mBt_start_activity , mBt_save;
    EditText mEt_login , mEt_password;
    TextView mTv;
    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    public static final String FILE_SHARED_PREFERENCES_NAME = "FilesSharedPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTv = (TextView) findViewById(R.id.text_out_other_activity);

        mBt_start_activity = (Button) findViewById(R.id.bt_startActivity);
        mBt_save = (Button) findViewById(R.id.bt_save);

        mEt_login = (EditText) findViewById(R.id.editText);
        mEt_password = (EditText) findViewById(R.id.editText2);

        mBt_start_activity.setOnClickListener(this);
        mBt_save.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_startActivity:
                Intent intent = new Intent(this , outputActivity.class);
                startActivity(intent);
                break;

            case R.id.bt_save:

                SharedPreferences sharedPreferences = getSharedPreferences(FILE_SHARED_PREFERENCES_NAME , Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("Login" , mEt_login.getText().toString());
                editor.putString("Password" , mEt_password.getText().toString());
                editor.apply();

                Toast.makeText(this, "Data save is successful!" , Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
