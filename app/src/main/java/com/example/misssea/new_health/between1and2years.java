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
public class between1and2years extends AppCompatActivity{

    private EditText edt_assess1;
    private EditText edt_assess2;
    private EditText edt_assess3;
    private EditText edt_assess4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.between1and2);
        edt_assess1 = (EditText) findViewById(R.id.editText20);
        edt_assess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"科学喂养", "生长发育", "疾病预防", "预防意外伤害", "口腔保健"};
                final boolean[] arrSelected1 = new boolean[]{false, false, false, false, false};
                Dialog alertdialog_assess1 = new AlertDialog.Builder(between1and2years.this)
                        .setTitle("指导").setMultiChoiceItems(arr1, arrSelected1, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        arrSelected1[which] = isChecked;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i = 0; i < arrSelected1.length; i++) {
                                    if (arrSelected1[i] == true) {
                                        stringBuilder.append(arr1[i] + "，");
                                    }
                                }
                                edt_assess1.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess1.show();
            }
        });

        edt_assess2 = (EditText) findViewById(R.id.editText44);
        edt_assess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"科学喂养", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected2= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess2 = new AlertDialog.Builder(between1and2years.this)
                        .setTitle("指导").setMultiChoiceItems(arr2, arrSelected2, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        arrSelected2[which] = isChecked;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i=0;i<arrSelected2.length;i++){
                                    if (arrSelected2[i]==true){
                                        stringBuilder.append(arr2[i]+"，");
                                    }
                                }
                                edt_assess2.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess2.show();
            }
        });

        edt_assess3 = (EditText) findViewById(R.id.editText66);
        edt_assess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"合理膳食", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected3= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess3 = new AlertDialog.Builder(between1and2years.this)
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
                                for (int i=0;i<arrSelected3.length;i++){
                                    if (arrSelected3[i]==true){
                                        stringBuilder.append(arr3[i]+"，");
                                    }
                                }
                                edt_assess3.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess3.show();
            }
        });

        edt_assess4 = (EditText) findViewById(R.id.editText88);
        edt_assess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"合理膳食", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected4= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess4 = new AlertDialog.Builder(between1and2years.this)
                        .setTitle("指导").setMultiChoiceItems(arr4, arrSelected4, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        arrSelected4[which] = isChecked;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i=0;i<arrSelected4.length;i++){
                                    if (arrSelected4[i]==true){
                                        stringBuilder.append(arr4[i]+"，");
                                    }
                                }
                                edt_assess4.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess4.show();
            }
        });

    }
}
