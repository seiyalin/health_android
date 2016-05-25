package com.example.misssea.new_health;

import android.app.DatePickerDialog;
import android.app.Service;
import android.bluetooth.BluetoothClass;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.security.Provider;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button btnnew = null;
    private Button btnold = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
//                .fileList, android.R.layout.simple_list_item_1);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        ListView lv = (ListView) findViewById(R.id.listView);
//        lv.setAdapter(adapter);
        btnnew = (Button) findViewById(R.id.button_new);
        btnnew.setOnClickListener(new btnnew_Listener());
        btnold = (Button) findViewById(R.id.button_old);
        btnold.setOnClickListener(new btnold_Listener());
    }

    private class btnnew_Listener implements View.OnClickListener {  //新用户进入注册页面
        @Override
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this,register_activity.class);
            startActivity(i);
        }
    }

    private class btnold_Listener implements View.OnClickListener {      //老用户进入登录页面
        @Override
        public void onClick(View v) {
            Intent i=new Intent(MainActivity.this,login_activity.class);
            startActivity(i);
        }
    }
}
