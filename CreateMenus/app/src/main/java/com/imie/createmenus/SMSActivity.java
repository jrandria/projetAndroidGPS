package com.imie.createmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SMSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
    }

    protected void sendSMS() {
        //

        String phoneNo = ((EditText)findViewById(R.id.EditTextNo)).getText().toString();
        String message = ((EditText)findViewById(R.id.EdiTextMessage)).getText().toString();

        try{
            SmsManager smsManager=SmsManager.getDefault();
            //
            smsManager.sendTextMessage(phoneNo, null, message, null,null);
        }catch (Exception ex){
            Toast.makeText(getApplicationContext(),"Erreur d'envoi du sms",Toast.LENGTH_LONG);
            ex.printStackTrace();
        }

    }


    public void sendMySMS(View view){
        sendSMS();
    }
}
