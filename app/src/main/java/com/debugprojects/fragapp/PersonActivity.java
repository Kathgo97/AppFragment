package com.debugprojects.fragapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Intent callingIntent = getIntent();
        Bundle recivedBundle = callingIntent.getExtras();

        PersonViewer frag = new PersonViewer();
        frag.setArguments(recivedBundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.viewer, frag);
        fragmentTransaction.commit();

    }
}
