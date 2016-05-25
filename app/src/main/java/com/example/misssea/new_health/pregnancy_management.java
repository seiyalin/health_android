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
public class pregnancy_management extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregnancy_file);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
                .pregnancy_list, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(pregnancy_management.this, prenatal_1.class);break;
                    case 1:
                        intent = new Intent(pregnancy_management.this,prenatal_2to5.class);break;
                    case 2:
                        intent = new Intent(pregnancy_management.this,postnatal.class);break;
                    case 3:
                        intent = new Intent(pregnancy_management.this,postnatal_42d_visit.class);break;

                }
                startActivity(intent);
            }
        });
    }
}
