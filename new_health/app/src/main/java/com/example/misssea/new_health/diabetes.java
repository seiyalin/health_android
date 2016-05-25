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
public class diabetes extends AppCompatActivity{

    private EditText edt_symp;
    private EditText edt_mode;
    private EditText edt_psycho;
    private EditText edt_medicine;
    private EditText edt_doct;
    private EditText edt_assess;
    private EditText edt_sugar;
    private int selectedIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.diabetes);

        edt_symp = (EditText) findViewById(R.id.editText5);
        edt_symp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"无症状", "多饮", "多食", "多尿", "视力模糊",
                        "感染", "手脚麻木", "下肢浮肿", "体重明显下降"};
                final boolean[] arrSelected1 = new boolean[]{false, false, false, false, false,
                        false, false, false, false};
                Dialog alertdialog_symp = new AlertDialog.Builder(diabetes.this)
                        .setTitle("症状").setMultiChoiceItems(arr1, arrSelected1, new
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
                                edt_symp.setText(stringBuilder);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_symp.show();
            }
        });

        edt_mode = (EditText) findViewById(R.id.editText4);
        edt_mode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"门诊", "家庭","电话"};
                Dialog alertdialog_mode = new AlertDialog.Builder(diabetes.this)
                        .setTitle("随访方式").setSingleChoiceItems(arr2, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_mode.setText(arr2[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_mode.show();
            }
        });

        edt_psycho = (EditText) findViewById(R.id.editText8);
        edt_psycho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"良好", "一般","差"};
                Dialog alertdialog_psycho = new AlertDialog.Builder(diabetes.this)
                        .setTitle("心理调整").setSingleChoiceItems(arr3, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_psycho.setText(arr3[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_psycho.show();
            }
        });

        edt_doct = (EditText) findViewById(R.id.editText9);
        edt_doct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"良好", "一般","差"};
                Dialog alertdialog_doct = new AlertDialog.Builder(diabetes.this)
                        .setTitle("遵医行为").setSingleChoiceItems(arr4, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_doct.setText(arr4[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_doct.show();
            }
        });

        edt_medicine = (EditText) findViewById(R.id.editText17);
        edt_medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr5 = new String[]{"规律", "间断","不服药"};
                Dialog alertdialog_medicine = new AlertDialog.Builder(diabetes.this)
                        .setTitle("服药依从性").setSingleChoiceItems(arr5, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_medicine.setText(arr5[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_medicine.show();
            }
        });

        edt_assess = (EditText) findViewById(R.id.editText40);
        edt_assess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"控制满意", "控制不满意","不良反应","并发症"};
                Dialog alertdialog_assess = new AlertDialog.Builder(diabetes.this)
                        .setTitle("此次随访分类").setSingleChoiceItems(arr6, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_assess.setText(arr6[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_assess.show();
            }
        });

        edt_sugar = (EditText) findViewById(R.id.editText12);
        edt_sugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr7 = new String[]{"无", "偶尔","频繁"};
                Dialog alertdialog_sugar = new AlertDialog.Builder(diabetes.this)
                        .setTitle("低血糖反应").setSingleChoiceItems(arr7, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_sugar.setText(arr7[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_sugar.show();
            }
        });

    }
}
