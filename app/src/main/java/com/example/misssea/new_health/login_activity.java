package com.example.misssea.new_health;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.zhy.http.okhttp.OkHttpUtils;

import org.json.JSONException;
import org.json.JSONObject;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import callback.User;
import callback.myCallback;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by misssea on 2016/3/11.
 */
public class login_activity extends AppCompatActivity{

    private Button btnin;
    private Button btncl;
    private EditText edt_name;
    private EditText edt_id;
    private String stringname;
    private String stringID;
    private ProgressDialog pDialog;
    private static final String URL = "http://192.168.1.107/test.php";
    private OkHttpClient client=new OkHttpClient();
    private static final String TAG = login_activity.class.getSimpleName();
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tv = (TextView) findViewById(R.id.register_link);
        tv.setClickable(true);
        tv.setOnClickListener(new tvListener());
        btnin = (Button) findViewById(R.id.login_button);
        btnin.setOnClickListener(new btnin_Listener());
        btncl= (Button)findViewById(R.id.button_cl);
        btncl.setOnClickListener(new Button_cancel_Listener());
        edt_name = (EditText) findViewById(R.id.edit_username);
        edt_id = (EditText) findViewById(R.id.edit_userID);


        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

    }
    private class tvListener implements View.OnClickListener {     //进入注册页面
        @Override
        public void onClick(View v) {
           i=new Intent(login_activity.this,register_activity.class);
            startActivity(i);
        }
    }
    private class btnin_Listener implements View.OnClickListener {   //点击登录按钮
        @Override
        public void onClick(View v) {
            stringname= edt_name.getText().toString();
            stringID=edt_id.getText().toString();

            ((applicationTrans)getApplication()).setValue(stringname,stringID);  //共享用户名

            if (stringname.trim().length() > 0 && stringID.trim().length() > 0) {
                // login user
                try {
                    checkLogin(stringname, stringID);    //登录验证
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                // Prompt user to enter credentials
                Toast.makeText(getApplicationContext(),
                        "Please enter the credentials!", Toast.LENGTH_LONG)
                        .show();
            }

//            Intent i=new Intent(login_activity.this,user_activity.class);
//            startActivity(i);
        }
    }

    private class Button_cancel_Listener implements View.OnClickListener {    //退出
        @Override
        public void onClick(View v) {

            i = new Intent(login_activity.this, MainActivity.class);
            startActivity(i);
        }
    }

    private void checkLogin(final String stringname, final String stringID) throws JSONException {  //登录提交到服务器验证
        // Tag used to cancel the request
        //String tag_string_req = "req_login";

        pDialog.setMessage("Logging in ...");
        showDialog();



//        Map<String,String> params=new HashMap<>();
//        params.put("tag","login");
//        params.put("name",stringname);
//        params.put("userID",stringID);
//
//                OkHttpUtils.post().url(URL).params(params).build().execute(new myCallback() {
//                    @Override
//                    public void onError(Call call, Exception e) {
//
//                    }
//
//                    @Override
//                    public void onResponse(User response) {
//                        Log.d(TAG, "Login Response: " + response);
//                        if (!response.getboolean()) {
//                            i = new Intent(login_activity.this, user_activity.class);
//                            startActivity(i);
//                        } else {
//                            String errorMsg = "Incorrect name or userID!";
//                            Toast.makeText(getApplicationContext(),
//                                    errorMsg, Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final MediaType JSON
              = MediaType.parse("application/json; charset=utf-8");
                JSONObject jsonObject=new JSONObject();
                try {
                    jsonObject.put("tag","login");
                    jsonObject.put("name",stringname);
                    jsonObject.put("userID",stringID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                RequestBody body= FormBody.create(JSON, jsonObject.toString());
                Request request=new Request.Builder().url(URL).post(body).build();
                try {
                    Response response=client.newCall(request).execute();

                    //Log.d(TAG, "Login Response: " + response.body().string());

                    JSONObject object=new JSONObject(response.body().string());
                   // Log.d(TAG,object.getString("tag"));
                    boolean error=object.getBoolean("error");
                    if (!error){
                        i=new Intent(login_activity.this,user_activity.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        String errorMsg = "Incorrect name or userID!";
                        Looper.prepare();
                        Toast toast=Toast.makeText(getApplicationContext(), errorMsg, Toast
                                .LENGTH_LONG);
                        toast.show();
                        Looper.loop();
                        finish();
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        thread.start();
        hideDialog();

    }


    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }
    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}
