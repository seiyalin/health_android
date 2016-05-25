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
public class health_examination extends AppCompatActivity{
    private EditText edt_eat;
    private EditText edt_drink;
    private EditText edt_alcohol;
    private EditText edt_cigar;
    private EditText edt_hear;
    private EditText edt_sport;
    private EditText edt_skin;
    private EditText edt_gm;
    private EditText edt_lymph;
    private EditText edt_leg;
    private int selectedIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_examination);
        edt_eat = (EditText) findViewById(R.id.edit_text14);
        edt_eat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr1 = new String[]{"荤素均衡", "荤食为主", "素食为主",
                        "嗜盐", "嗜油", "嗜糖"};
                Dialog alertdialog_eat = new AlertDialog.Builder(health_examination.this)
                        .setTitle("饮食习惯").setSingleChoiceItems(arr1, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_eat.setText(arr1[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_eat.show();
            }
        });

        edt_drink = (EditText) findViewById(R.id.edit_text15);
        selectedIndex=0;
        edt_drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"从不", "偶尔", "经常", "每天"};
                Dialog alertdialog_drink = new AlertDialog.Builder(health_examination.this)
                        .setTitle("饮酒频率").setSingleChoiceItems(arr2, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_drink.setText(arr2[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_drink.show();
            }
        });

        edt_alcohol = (EditText) findViewById(R.id.edit_text17);
        selectedIndex=0;
        edt_alcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"白酒", "啤酒", "红酒",
                        "黄酒", "药酒", "粮食酒","其他"};
                Dialog alertdialog_alcohol = new AlertDialog.Builder(health_examination.this)
                        .setTitle("饮酒种类").setSingleChoiceItems(arr3, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_alcohol.setText(arr3[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_alcohol.show();
            }
        });

        edt_cigar = (EditText) findViewById(R.id.edit_text18);
        selectedIndex=0;
        edt_cigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"从不吸烟", "已戒烟", "吸烟"};
                Dialog alertdialog_cigar = new AlertDialog.Builder(health_examination.this)
                        .setTitle("吸烟状况").setSingleChoiceItems(arr4, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_cigar.setText(arr4[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_cigar.show();
            }
        });

        edt_hear = (EditText) findViewById(R.id.edit_text31);
        selectedIndex=0;
        edt_hear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr5 = new String[]{"听见", "听不清或无法听见"};
                Dialog alertdialog_hear = new AlertDialog.Builder(health_examination.this)
                        .setTitle("听力").setSingleChoiceItems(arr5, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_hear.setText(arr5[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_hear.show();
            }
        });

        edt_sport = (EditText) findViewById(R.id.edit_text23);
        selectedIndex=0;
        edt_sport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"可顺利完成", "无法独立完成其中任何一个动作"};
                Dialog alertdialog_sport = new AlertDialog.Builder(health_examination.this)
                        .setTitle("运动功能").setSingleChoiceItems(arr6, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_sport.setText(arr6[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_sport.show();
            }
        });

        edt_skin = (EditText) findViewById(R.id.edit_text24);
        selectedIndex=0;
        edt_skin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"正常", "潮红","苍白","发绀","黄染","色素沉着","其他"};
                Dialog alertdialog_skin = new AlertDialog.Builder(health_examination.this)
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

        edt_gm = (EditText) findViewById(R.id.edit_text25);
        selectedIndex=0;
        edt_gm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr7 = new String[]{"正常", "黄染","充血","其他"};
                Dialog alertdialog_gm = new AlertDialog.Builder(health_examination.this)
                        .setTitle("巩膜").setSingleChoiceItems(arr7, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_gm.setText(arr7[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_gm.show();
            }
        });

        edt_lymph = (EditText) findViewById(R.id.edit_text26);
        selectedIndex=0;
        edt_lymph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr8 = new String[]{"未触及", "锁骨上","腋窝","其他"};
                Dialog alertdialog_lymph = new AlertDialog.Builder(health_examination.this)
                        .setTitle("淋巴结").setSingleChoiceItems(arr8, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_lymph.setText(arr8[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_lymph.show();
            }
        });

        edt_leg = (EditText) findViewById(R.id.edit_text28);
        selectedIndex=0;
        edt_leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr9 = new String[]{"无", "单侧","双侧不对称","双侧对称"};
                Dialog alertdialog_leg = new AlertDialog.Builder(health_examination.this)
                        .setTitle("下肢水肿").setSingleChoiceItems(arr9, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_leg.setText(arr9[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_leg.show();
            }
        });
    }
}
