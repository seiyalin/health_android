package com.example.misssea.new_health;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URLDecoder;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by misssea on 2016/3/11.
 */
public class personalInfoActivity extends AppCompatActivity {
    private EditText edt_study;
    private EditText edt_occu;
    private EditText edt_marr;
    private EditText edt_allergy;
    private EditText edt_expose;
    private EditText edt_disabled;
    private EditText edt_heredity;
    private EditText edt_clinic;
    private TextView edt_name,edt_userID,edt_gender,edt_birthday,edt_telephone,edt_address,edt_nation;
    private Intent i;
    private int selectedIndex = 0;

    private String s="sea";

    private String stringname,stringID;
    private static final String TAG = register_activity.class.getSimpleName();

    private ProgressDialog pDialog;
    private static final String URL = "http://192.168.1.107/test.php";
    private OkHttpClient client=new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Resources res = this.getResources();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(R.layout.personal_info);

        edt_name=(TextView)findViewById(R.id.edit_name);
        edt_userID=(TextView)findViewById(R.id.edit_userID);
        edt_gender=(TextView)findViewById(R.id.edit_gender);
        edt_birthday=(TextView)findViewById(R.id.edit_date);
        edt_telephone=(TextView)findViewById(R.id.edit_tel);
        edt_address=(TextView)findViewById(R.id.edit_addr);
        edt_nation=(TextView)findViewById(R.id.edit_nation);
        edt_heredity=(EditText)findViewById(R.id.edit_text15);



        stringname=((applicationTrans)getApplication()).get_Name();
        stringID=((applicationTrans)getApplication()).get_userID();  //获取用户信息
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final MediaType JSON
                        = MediaType.parse("application/json; charset=utf-8");
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("tag","personalInfo");
                    jsonObject.put("name",stringname);
                    jsonObject.put("userID",stringID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RequestBody body= FormBody.create(JSON, jsonObject.toString());
                Request request=new Request.Builder().url(URL).post(body).build();
                try {
                    Response response=client.newCall(request).execute();

//                    String str=response.body().string();
//                    String backlogJsonStrTmp = str.replace("\\", "");
//                    str = backlogJsonStrTmp.substring(1,backlogJsonStrTmp.length() - 1);
                    //Log.d(TAG,str);
                    //edt_name.setText(s);
                    //Log.d(TAG, "Login Response: " + response.body().string());
                    //final String str= URLDecoder.decode(response.body().string(), "utf-8");

                    JSONObject object=new JSONObject(response.body().string());
                   // Log.d(TAG, object.getString("tag"));

                    edt_name.setText(object.getString("name"));
                    edt_userID.setText(object.getString("userID"));
                    edt_gender.setText(object.getString("gender"));
                    edt_birthday.setText(object.getString("birthday"));
                    edt_address.setText(object.getString("address"));
                    edt_telephone.setText(object.getString("telephone"));
                    edt_nation.setText(object.getString("nation"));



                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();



        edt_study = (EditText) findViewById(R.id.edit_text10);
        edt_study.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                final String[] arr = res.getStringArray(R.array.文化程度);
                final String[] arr1 = new String[]{"文盲及半文盲", "小学", "初中", "高中/技校/中专", "大学专科及以上",
                        "不详"};
                Dialog alertdialog = new AlertDialog.Builder(personalInfoActivity.this).setTitle
                        ("文化程度").setSingleChoiceItems(arr1, selectedIndex, new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex = which;
                            }
                        }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(personalInfoActivity.this, arr[selectedIndex],
//                                Toast.LENGTH_SHORT).show();
                        edt_study.setText(arr1[selectedIndex]);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
                alertdialog.show();
            }
        });

        edt_occu = (EditText) findViewById(R.id.edit_text11);
        selectedIndex=0;
        edt_occu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr2 = new String[]{"国家机关、党群组织、企/事业单位负责人", "专业技术人员", "办事人员和有关人员",
                        "商业、服务业人员", "农林牧渔水利业生产人员", "生产、运输设备操作人员及有关人员","军人","不便分类的其他从业人员"};
                Dialog alertdialog_occu = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("职业").setSingleChoiceItems(arr2, selectedIndex, new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                selectedIndex = which;
                            }
                        }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edt_occu.setText(arr2[selectedIndex]);
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                }).create();
                alertdialog_occu.show();
            }
        });

        edt_marr = (EditText) findViewById(R.id.edit_text12);
        selectedIndex=0;
        edt_marr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr3 = new String[]{"未婚", "已婚", "丧偶",
                        "离婚", "未说明的婚姻状况"};
                Dialog alertdialog_marr = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("婚姻状况").setSingleChoiceItems(arr3, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_marr.setText(arr3[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_marr.show();
            }
        });

        edt_allergy = (EditText) findViewById(R.id.edit_text13);
        selectedIndex=0;
        edt_allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr4 = new String[]{"无", "青霉素", "磺胺",
                        "链霉素", "其他"};
                Dialog alertdialog_allergy = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("药物过敏史").setSingleChoiceItems(arr4, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_allergy.setText(arr4[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_allergy.show();
            }
        });

        edt_expose = (EditText) findViewById(R.id.edit_text14);
        selectedIndex=0;
        edt_expose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr5 = new String[]{"无", "化学品", "毒物", "射线"};
                Dialog alertdialog_expose = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("暴露史").setSingleChoiceItems(arr5, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_expose.setText(arr5[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_expose.show();
            }
        });

        edt_disabled = (EditText) findViewById(R.id.edit_text16);
        selectedIndex=0;
        edt_disabled.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr6 = new String[]{"无残疾", "视力残疾", "听力残疾",
                        "言语残疾", "肢体残疾", "智力残疾","精神残疾","其他残疾"};
                Dialog alertdialog_disabled = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("残疾情况").setSingleChoiceItems(arr6, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_disabled.setText(arr6[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_disabled.show();
            }
        });

        edt_clinic = (EditText) findViewById(R.id.edit_text17);
        selectedIndex=0;
        edt_clinic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] arr7 = new String[]{"城镇职工基本医疗保险", "城镇居民基本医疗保险", "新型农村合作医疗",
                        "贫困救助", "商业医疗保险", "全公费","全自费","其他"};
                Dialog alertdialog_clinic = new AlertDialog.Builder(personalInfoActivity.this)
                        .setTitle("医疗费用支付方式").setSingleChoiceItems(arr7, selectedIndex, new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        selectedIndex = which;
                                    }
                                }).setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                edt_clinic.setText(arr7[selectedIndex]);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        }).create();
                alertdialog_clinic.show();
            }
        });



    }
}
