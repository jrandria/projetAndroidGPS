package com.imie.createmenus;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

public class MapActivity extends FragmentActivity{

    private static final String MONFRAGMENTTAG="MAPFRAGTAG";
    private MonFragment monMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if((monMapFragment=(MonFragment) getSupportFragmentManager().findFragmentByTag(MONFRAGMENTTAG))== null){
            monMapFragment=  MonFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container,monMapFragment,MONFRAGMENTTAG).commit();
        }
    }
}
