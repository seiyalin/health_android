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
public class under_1year_visit extends AppCompatActivity{
    private EditText edt_face1;
    private EditText edt_face2;
    private EditText edt_face3;
    private EditText edt_face4;
    private EditText edt_qb1;
    private EditText edt_qb2;
    private EditText edt_assess1;
    private EditText edt_assess2;
    private EditText edt_assess3;
    private EditText edt_assess4;
    private int selectedIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.under_1year);
        edt_face1 = (EditText) findViewById(R.id.editText5);
        edt_face1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"红润", "黄染", "其他"};
                Dialog alertdialog_face1 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("面色").setSingleChoiceItems(arr1, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_face1.setText(arr1[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_face1.show();
            }
        });

        edt_qb1 = (EditText) findViewById(R.id.editText10);
        edt_qb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"未脱", "脱落","脐部有渗出", "其他"};
                Dialog alertdialog_qb1 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("脐部").setSingleChoiceItems(arr2, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_qb1.setText(arr2[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_qb1.show();
            }
        });

        edt_assess1 = (EditText) findViewById(R.id.editText20);
        edt_assess1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"科学喂养", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess1 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("指导").setMultiChoiceItems(arr3, arrSelected, new
                                DialogInterface.OnMultiChoiceClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which,
                                                        boolean isChecked) {
                                        arrSelected[which] = isChecked;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                StringBuilder stringBuilder = new StringBuilder();
                                for (int i=0;i<arrSelected.length;i++){
                                    if (arrSelected[i]==true){
                                        stringBuilder.append(arr3[i]+"，");
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

        edt_face2 = (EditText) findViewById(R.id.editText29);
        edt_face2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"红润", "黄染", "其他"};
                Dialog alertdialog_face2 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("面色").setSingleChoiceItems(arr4, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_face2.setText(arr4[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_face2.show();
            }
        });

        edt_qb2 = (EditText) findViewById(R.id.editText34);
        edt_qb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr5 = new String[]{"未见异常", "异常"};
                Dialog alertdialog_qb2 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("脐部").setSingleChoiceItems(arr5, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_qb2.setText(arr5[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_qb2.show();
            }
        });

        edt_assess2 = (EditText) findViewById(R.id.editText44);
        edt_assess2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"科学喂养", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected1= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess2 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("指导").setMultiChoiceItems(arr6, arrSelected1, new
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
                                for (int i=0;i<arrSelected1.length;i++){
                                    if (arrSelected1[i]==true){
                                        stringBuilder.append(arr6[i]+"，");
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

        edt_face3 = (EditText) findViewById(R.id.editText51);
        edt_face3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr7 = new String[]{"红润",  "其他"};
                Dialog alertdialog_face3 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("面色").setSingleChoiceItems(arr7, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_face3.setText(arr7[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_face3.show();
            }
        });

        edt_assess3 = (EditText) findViewById(R.id.editText66);
        edt_assess3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr8 = new String[]{"科学喂养", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected2= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess3 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("指导").setMultiChoiceItems(arr8, arrSelected2, new
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
                                        stringBuilder.append(arr8[i]+"，");
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

        edt_face4 = (EditText) findViewById(R.id.editText73);
        edt_face4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr9 = new String[]{"红润",  "其他"};
                Dialog alertdialog_face4 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("面色").setSingleChoiceItems(arr9, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_face4.setText(arr9[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_face4.show();
            }
        });

        edt_assess4 = (EditText) findViewById(R.id.editText88);
        edt_assess4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr10 = new String[]{"科学喂养", "生长发育","疾病预防", "预防意外伤害","口腔保健"};
                final boolean[] arrSelected3= new boolean[]{false,false,false,false,false};
                Dialog alertdialog_assess4 = new AlertDialog.Builder(under_1year_visit.this)
                        .setTitle("指导").setMultiChoiceItems(arr10, arrSelected3, new
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
                                        stringBuilder.append(arr10[i]+"，");
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
