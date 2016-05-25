package com.example.misssea.new_health;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by misssea on 2016/3/11.
 */
public class child_management extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.child_file);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
                .childfile_list, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(child_management.this, vaccination.class);break;
                    case 1:
                        intent = new Intent(child_management.this,new_born.class);break;
                    case 2:
                        intent = new Intent(child_management.this,under_1year_visit.class);break;
                    case 3:
                        intent = new Intent(child_management.this,between1and2years.class);break;
                    case 4:
                        intent = new Intent(child_management.this,between3and6years.class);break;

                }
                startActivity(intent);
            }
        });
    }
}
