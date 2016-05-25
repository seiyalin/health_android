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
public class new_born extends AppCompatActivity{
    private EditText edt_ache;
    private EditText edt_hear;
    private EditText edt_disease;
    private EditText edt_feed;
    private EditText edt_face;
    private EditText edt_skin;
    private EditText edt_qd;
    private int selectedIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_born_visit);
        edt_ache = (EditText) findViewById(R.id.editText4);
        edt_ache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"无", "糖尿病", "妊娠期高血压", "其他"};
                Dialog alertdialog_ache = new AlertDialog.Builder(new_born.this)
                        .setTitle("妊娠期患病情况").setSingleChoiceItems(arr1, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_ache.setText(arr1[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_ache.show();
            }
        });
//
        edt_hear = (EditText) findViewById(R.id.editText5);
        selectedIndex=0;
        edt_hear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"通过", "未通过","未筛查","不详"};
                Dialog alertdialog_hear = new AlertDialog.Builder(new_born.this)
                        .setTitle("新生儿听力筛查").setSingleChoiceItems(arr2, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_hear.setText(arr2[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_hear.show();
            }
        });
//
        edt_disease = (EditText) findViewById(R.id.editText6);
        selectedIndex=0;
        edt_disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"无", "甲低","苯丙酮尿症","其他遗传代谢病"};
                Dialog alertdialog_disease = new AlertDialog.Builder(new_born.this)
                        .setTitle("新生儿疾病筛查").setSingleChoiceItems(arr3, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_disease.setText(arr3[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_disease.show();
            }
        });
//
        edt_feed = (EditText) findViewById(R.id.editText10);
        selectedIndex=0;
        edt_feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"纯母乳", "混合","人工"};
                Dialog alertdialog_feed = new AlertDialog.Builder(new_born.this)
                        .setTitle("喂养方式").setSingleChoiceItems(arr4, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_feed.setText(arr4[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_feed.show();
            }
        });
//
        edt_face = (EditText) findViewById(R.id.editText14);
        selectedIndex=0;
        edt_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr5 = new String[]{"红润", "黄染","其他"};
                Dialog alertdialog_face = new AlertDialog.Builder(new_born.this)
                        .setTitle("面色").setSingleChoiceItems(arr5, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_face.setText(arr5[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_face.show();
            }
        });
//
        edt_skin = (EditText) findViewById(R.id.editText20);
        selectedIndex=0;
        edt_skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"未见异常", "湿疹","糜烂","其他"};
                Dialog alertdialog_skin = new AlertDialog.Builder(new_born.this)
                        .setTitle("皮肤").setSingleChoiceItems(arr6, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_skin.setText(arr6[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_skin.show();
            }
        });

        edt_qd = (EditText) findViewById(R.id.editText25);
        selectedIndex=0;
        edt_qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr7 = new String[]{"未脱", "脱落","脐部有渗出","其他"};
                Dialog alertdialog_qd = new AlertDialog.Builder(new_born.this)
                        .setTitle("脐带").setSingleChoiceItems(arr7, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_qd.setText(arr7[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_qd.show();
            }
        });
    }
}
