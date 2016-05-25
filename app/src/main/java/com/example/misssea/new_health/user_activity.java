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
public class user_activity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userfile);
//            ListView mlistview=(ListView)findViewById(R.id.listView); // 用simpleCursorAdapter从数据库读取列表
//            Cursor cursor = getContentResolver().query(filelist_url,null,null,null,null);    //创建SimpleCursorAdapter适配器cursor数据类型
//            CursorAdapter adapter=new SimpleCursorAdapter(MainActivity.this,android.R.layout.simple_expandable_list_item_1,new String[]{filename},new int[]{android.R.id.text1});
//            mlistview.setAdapter(adapter);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array
                .fileList, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        ListView lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;

                switch (position) {
                    case 0:
                        intent = new Intent(user_activity.this, personalInfoActivity.class);
                        break;
                    case 1:
                        intent = new Intent(user_activity.this, health_examination.class);
                        break;
                    case 2:
                        intent = new Intent(user_activity.this, child_management.class);
                        break;
                    case 3:
                        intent = new Intent(user_activity.this, pregnancy_management.class);
                        break;
                    case 4:
                        intent = new Intent(user_activity.this, focus_groups_management.class);
                        break;
                    case 5:
                        intent = new Intent(user_activity.this, clinic_management.class);
                        break;

                    default:

                }
                startActivity(intent);
            }
        });
    }
}
