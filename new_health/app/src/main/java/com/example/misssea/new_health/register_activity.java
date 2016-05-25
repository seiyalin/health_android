package com.example.misssea.new_health;

import android.app.DatePickerDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by misssea on 2016/3/11.
 */
public class register_activity extends AppCompatActivity {

    private Button btnin;
    private Button btncl;
    Intent i;
    private String formattext = "yyyyMMdd";
    private Calendar c = Calendar.getInstance();
    private EditText edt1;

    private static final String URL = "http://192.168.1.107/test.php";

    private EditText nm, edt_id, mid, tel, nativ, addr, nation;
    private CheckBox none;
    private RadioGroup radioGroup;
    private RadioButton radio_m, radio_w;
    private String sex, name, date;
    private String identify_id = " ";

    private DatePickerDialog dialog;
    private ProgressDialog pDialog;
    private int myear = c.get(Calendar.YEAR);
    private int mmonth = c.get(Calendar.MONTH);
    private int mday = c.get(Calendar.DAY_OF_MONTH);

    private OkHttpClient client = new OkHttpClient();
    private static final String TAG = register_activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btnin = (Button) findViewById(R.id.button_in);
        btnin.setOnClickListener(new Buttonin_Listener());
        btncl = (Button) findViewById(R.id.button_cancel);
        btncl.setOnClickListener(new ButtonCL_Listener());
        edt1 = (EditText) findViewById(R.id.editText_time);
        edt1.setOnClickListener(new edt_Listener());

        nm = (EditText) findViewById(R.id.editText_nm);
        edt_id = (EditText) findViewById(R.id.editText_id);   //没有身份证的要改
        mid = (EditText) findViewById(R.id.editText_mid);
        none = (CheckBox) findViewById(R.id.checkButton3);
//        none.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(!isChecked){
//                   identify_id=edt_id.getText().toString();
//                }
//                else {
//                   identify_id=mid.getText().toString()+edt1.getText().toString()+1;
//                }
//            }
//        });
        radio_m = (RadioButton) findViewById(R.id.radioButton_m);
        radio_w = (RadioButton) findViewById(R.id.radioButton_w);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radio_m.getId()) {
                    sex = radio_m.getText().toString();
                } else if (checkedId == radio_w.getId()) {
                    sex = radio_w.getText().toString();
                }
            }
        });
        tel = (EditText) findViewById(R.id.editText_tel);
        nativ = (EditText) findViewById(R.id.editText_add);
        addr = (EditText) findViewById(R.id.editText_addre);
        nation = (EditText) findViewById(R.id.editText_nat);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
    }

    DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            c.set(year, monthOfYear, dayOfMonth);
            SimpleDateFormat df = new SimpleDateFormat(formattext);
            edt1.setText(df.format(c.getTime()));
        }
    };

    private class edt_Listener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            dialog = new DatePickerDialog(register_activity.this, listener, myear, mmonth, mday);
            dialog.show();
        }
    }

    private class Buttonin_Listener implements View.OnClickListener {      //注册,提交信息，建档
        @Override
        public void onClick(View v) {
            name = nm.getText().toString();
            date = edt1.getText().toString();
            if (!none.isChecked()) { // 在这个位置设值
                identify_id = edt_id.getText().toString();
            } else {
                identify_id = mid.getText().toString() + edt1.getText().toString() + 1;
            }

            if (!name.isEmpty() && !identify_id.isEmpty() && !date.isEmpty() && !sex.isEmpty()) {
                //String tag_string_req = "req_register";
                pDialog.setMessage("Registering ...");
                showDialog();


                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final MediaType JSON
                                = MediaType.parse("application/json; charset=utf-8");
                        JSONObject jsonObject = new JSONObject();
                        try {
                            jsonObject.put("tag", "register");
                            jsonObject.put("name", name);
                            jsonObject.put("userID", identify_id);
                            jsonObject.put("birthday", date);
                            jsonObject.put("gender", sex);
                            jsonObject.put("tel", tel.getText().toString());
                            jsonObject.put("native", nativ.getText().toString());
                            jsonObject.put("address", addr.getText().toString());
                            jsonObject.put("nation", nation.getText().toString());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        RequestBody body = FormBody.create(JSON, jsonObject.toString());
                        Request request = new Request.Builder().url(URL).post(body).header
                                ("content-Type", "application/json; charset=utf-8").build();
                        try {
                            Response response = client.newCall(request).execute();

                            //Log.d(TAG,response.body().string());
                            JSONObject object = new JSONObject(response.body().string());
                            //Log.d(TAG,object.getString("tag"));
                            boolean error = object.getBoolean("error");
                            if (!error) {
                                i = new Intent(register_activity.this, login_activity.class);
                                startActivity(i);
                                finish();
                            } else {
                                String errorMsg = object.getString("error_msg");
                                Looper.prepare();
                                Toast toast = Toast.makeText(getApplicationContext(), errorMsg,
                                        Toast
                                        .LENGTH_LONG);
                                toast.show();
                                Looper.loop();
                                hideDialog();
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                });
                thread.start();


//
            } else {
                Toast.makeText(getApplicationContext(),
                        "Please enter your details!", Toast.LENGTH_LONG)
                        .show();
            }

        }
    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private class ButtonCL_Listener implements View.OnClickListener {      //CANCEL
        @Override
        public void onClick(View v) {
            i = new Intent(register_activity.this, MainActivity.class);
            startActivity(i);
        }
    }
}


