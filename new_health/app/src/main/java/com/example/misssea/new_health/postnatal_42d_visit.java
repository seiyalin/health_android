package com.example.misssea.new_health;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by misssea on 2016/3/11.
 */
public class postnatal_42d_visit extends AppCompatActivity{
    private EditText edt_assess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postnatal_42d);
        edt_assess = (EditText) findViewById(R.id.editText41);
        edt_assess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"性保健", "避孕", "婴儿喂养及营养", "其他"};
                final boolean[] arrSelected3 = new boolean[]{false, false, false, false};
                Dialog alertdialog_assess3 = new AlertDialog.Builder(postnatal_42d_visit.this)
                        .setTitle("指导").setMultiChoiceItems(arr3, arrSelected3, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        arrSelected3[which] = isChecked;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < arrSelected3.length; i++) {
                                    if (arrSelected3[i] == true) {
                                        stringBuilder.append(arr3[i] + "，");
                                    }
                                }
                                edt_assess.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess3.show();
            }
        });
    }
}
