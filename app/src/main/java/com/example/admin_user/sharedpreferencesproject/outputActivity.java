package com.example.admin_user.sharedpreferencesproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class outputActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTv_login , mTv_password;
    Button mBt_load, mBt_previous;

    MainActivity mainActivity;

    public static final String MESSAGE = "Message";
    public static final String DEFAULT = "N/A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);

        mainActivity = new MainActivity();

        mTv_login = (TextView) findViewById(R.id.tv_login);
        mTv_password = (TextView) findViewById(R.id.tv_password);

        mBt_previous = (Button) findViewById(R.id.bt_previous);
        mBt_load = (Button) findViewById(R.id.bt_load);

        mBt_load.setOnClickListener(this);
        mBt_previous.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bt_previous:
                Intent intent = new Intent(this , MainActivity.class);
                intent.putExtra(MESSAGE , "message");
                startActivity(intent);
                break;

            case R.id.bt_load:
                SharedPreferences sharedPreferences = getSharedPreferences(mainActivity.FILE_SHARED_PREFERENCES_NAME , Context.MODE_PRIVATE);

                String login = sharedPreferences.getString("Login" , DEFAULT);
                String password = sharedPreferences.getString("Password" , DEFAULT);

                if(login.equals(DEFAULT) || password.equals(DEFAULT)){
                    Toast.makeText(this, "SharedPReferences is empty!" , Toast.LENGTH_SHORT).show();
                }else{
                    mTv_login.setText(login);
                    mTv_password.setText(password);
                    Toast.makeText(this, "Successful!" , Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

/* Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mTv.setText(message);*/