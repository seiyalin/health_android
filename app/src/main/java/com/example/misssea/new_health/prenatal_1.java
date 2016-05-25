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
public class prenatal_1 extends AppCompatActivity{

    private EditText edt_hist;
    private EditText edt_fami;
    private EditText edt_personal;
    private EditText edt_assess;
    private int selectedIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prenatal1);

        edt_hist = (EditText) findViewById(R.id.editText9);
        edt_hist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"无", "心脏病", "肾脏疾病", "肝脏疾病", "高血压", "贫血",
                        "糖尿病", "其他"};
                Dialog alertdialog_hist = new AlertDialog.Builder(prenatal_1.this)
                        .setTitle("既往史").setSingleChoiceItems(arr1, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_hist.setText(arr1[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_hist.show();
            }
        });

        edt_fami = (EditText) findViewById(R.id.editText10);
        edt_fami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"遗传性疾病史", "精神疾病史", "其他"};
                Dialog alertdialog_fami = new AlertDialog.Builder(prenatal_1.this)
                        .setTitle("家族史").setSingleChoiceItems(arr2, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_fami.setText(arr2[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_fami.show();
            }
        });

        edt_personal = (EditText) findViewById(R.id.editText11);
        edt_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"无", "吸烟", "饮酒", "服用药物", "接触有毒有害物质","接触放射线","其他"};
                Dialog alertdialog_personal = new AlertDialog.Builder(prenatal_1.this)
                        .setTitle("个人史").setSingleChoiceItems(arr3, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_personal.setText(arr3[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_personal.show();
            }
        });

        edt_assess = (EditText) findViewById(R.id.editText41);
        edt_assess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"个人卫生", "心理", "营养", "避免致畸因素和疾病对胚胎的不良影响", "产前筛查宣传告知"};
                final boolean[] arrSelected4 = new boolean[]{false, false, false, false, false};
                Dialog alertdialog_assess4 = new AlertDialog.Builder(prenatal_1.this)
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
                                for (int i = 0; i < arrSelected4.length; i++) {
                                    if (arrSelected4[i] == true) {
                                        stringBuilder.append(arr4[i] + "，");
                                    }
                                }
                                edt_assess.setText(stringBuilder);
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
