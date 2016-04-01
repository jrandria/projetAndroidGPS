package com.imie.createmenus;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.smsID:
                funcEnvoiSMS(item);
                return true;
            case R.id.cameraID:
                funcCAMERA(item);
                return true;
            case R.id.gpsIP:
                funcPositionGPS(item);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void funcEnvoiSMS(MenuItem item){

        Intent intentSMS=new Intent(getApplicationContext(),SMSActivity.class);
        startActivity(intentSMS);

    }

    public void funcCAMERA(MenuItem item){
        //On peut démarrer l'intent de lancement du CAMERA directement
        intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        iv=(ImageView)findViewById(R.id.imageView);
        //startActivityForResult(intent, 0);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        iv.setImageBitmap(bp);
    }

    public void funcPositionGPS(MenuItem item) {

        Intent intentGPS=new Intent(getApplicationContext(),GPSActivity.class);
        startActivity(intentGPS);

    }

}
