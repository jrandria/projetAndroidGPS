package com.imie.createmenus;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GPSActivity extends AppCompatActivity {

    private LocationManager locationManager;
    private TextView textViewGPS;
    private Location l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        //On initialisation un LocationManager pour déterminer la position
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        //On précise qu'on veut obtenir une position avec le GPS PROVIDER seulement
        String provider = LocationManager.GPS_PROVIDER;

        //On détermine la position
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            l = locationManager.getLastKnownLocation(provider);
        }
        else{
            l=null;
        }
        //On passe cette position à une fonction qui lui va faire l'affichage
        obtenirMaLocalisation(l);

    }


    private  void obtenirMaLocalisation(Location location) {

        textViewGPS=(TextView)findViewById(R.id.positionGPS);
        String maLocalisationGPS="Aucune position trouvé";

        if(location!=null){
            double latitude=location.getLatitude();
            double longitude=location.getLongitude();

            maLocalisationGPS="Ma latitude est "+latitude+"\n et ma logitude est:"+longitude;

        }
        textViewGPS.setText(maLocalisationGPS);

    }
}
