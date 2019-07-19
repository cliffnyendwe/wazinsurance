package com.example.wazinsure;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.records) TextView mRecords;
    @BindView(R.id.createButton) Button mCreate;
    @BindView(R.id.agentEditText) EditText mAgent;
    @BindView(R.id.relationEditText) EditText mRelation;
    @BindView(R.id.mobileEditText) EditText mMobile;
    @BindView(R.id.fullEditText) EditText mFull;
    @BindView(R.id.profileEditText) EditText mPhoto;
    @BindView(R.id.countryEditText) EditText mCountry;
    @BindView(R.id.townEditText) EditText mTown;
    @BindView(R.id.codeEditText) EditText mCode;
    @BindView(R.id.postalEditText) EditText mAddress;
    @BindView(R.id.locationEditText) EditText mLocation;
    @BindView(R.id.emailEditText) EditText mEmail;
    @BindView(R.id.numberEditText) EditText mNumber;
    @BindView(R.id.occupationEditText) EditText mOccupation;
    @BindView(R.id.kraEditText) EditText mKra;
    @BindView(R.id.datedEditText) EditText mDate;
    @BindView(R.id.lastEditText) EditText mLastName;
    @BindView(R.id.nameEditText) EditText mName;
    @BindView(R.id.already) TextView mAlready;
    @BindView(R.id.waz) TextView mWaz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecords.setOnClickListener(this);
        checkNetworkConnection();
    }
    @Override
    public void onClick(View v){
        if(v == mRecords){
            Intent intent = new Intent(MainActivity.this, RecordsActivity.class);
            startActivity(intent);
        }
    }

    public boolean checkNetworkConnection(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;

        if(networkInfo != null && (isConnected = networkInfo.isConnected())){
            mWaz.setText("Connected");
        } else {
            mWaz.setText("Not Connected");
        }
        return isConnected;
    }

    private String httpPost(String myUrl) throws IOException, JSONException {
        String result = "";

        URL url = new URL(myUrl);

        // creation of HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        // build JSON object, add JSON content to POST request body, make POST request to given URL return response message
        JSONObject jsonObject = buildJsonObject();
        setPostRequestContent(conn, jsonObject);

        conn.connect();
        return conn.getResponseMessage() + " " + "Submitted";
    }

    private class HTTPAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        // displaying result of AsyncTask
        protected String doInBackground(String... urls) {
            try {
                try {
                    return httpPost(urls[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "Failed";
                }
            } catch (IOException e) {
                return "Unable to complete customer registration";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            mAlready.setText(result);
        }
    }

    public void send(View view){
        Toast.makeText(MainActivity.this, "Submitted", Toast.LENGTH_SHORT).show();

        if(checkNetworkConnection())
            new MainActivity.HTTPAsyncTask().execute("https://demo.wazinsure.com:4443/api/customers");
        else
            Toast.makeText(MainActivity.this,"Failed", Toast.LENGTH_SHORT).show();
    }

    private JSONObject buildJsonObject() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("first_name",mName.getText().toString());
        jsonObject.accumulate("last_name",mLastName.getText().toString());
        jsonObject.accumulate("dob",mDate.getText());
        jsonObject.accumulate("kra_pin",mKra.getText().toString());
        jsonObject.accumulate("occupation",mOccupation.getText().toString());
        jsonObject.accumulate("mobile_no",mMobile.getText().toString());
        jsonObject.accumulate("email",mEmail.getText().toString());
        jsonObject.accumulate("location",mLocation.getText().toString());
        jsonObject.accumulate("postal_address",mAddress.getText().toString());
        jsonObject.accumulate("postal_code",mCode.getText().toString());
        jsonObject.accumulate("town",mTown.getText().toString());
        jsonObject.accumulate("country",mCountry.getText().toString());
        jsonObject.accumulate("photo_url",mPhoto.getText().toString());
        jsonObject.accumulate("nok_fullname",mFull.getText().toString());
        jsonObject.accumulate("nok_mobileno",mMobile.getText().toString());
        jsonObject.accumulate("nok_relation",mRelation.getText().toString());
        jsonObject.accumulate("agent_code",mAgent.getText().toString());

        return  jsonObject;
    }
    private void setPostRequestContent(HttpURLConnection conn, JSONObject jsonObject) throws IOException{
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
        writer.write(jsonObject.toString());
        Log.i(MainActivity.class.toString(), jsonObject.toString());
        writer.flush();
        writer.close();
        os.close();
    }
}


