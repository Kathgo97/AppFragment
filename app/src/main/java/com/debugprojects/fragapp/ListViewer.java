package com.debugprojects.fragapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

public class ListViewer extends ListFragment implements AdapterView.OnItemClickListener{

    private String[] names;
    private String[] lastnames;
    private String[] mails;
    private String[] imgNames;
    private String[] careers;

    public static final String FRAG_KEY = "Esta es mi llave";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_viewer, container, false);
        Resources res = getResources();
        names = res.getStringArray(R.array.people_names);
        lastnames = res.getStringArray(R.array.people_lastnames);
        mails = res.getStringArray(R.array.people_mail);
        imgNames =res.getStringArray(R.array.people_image);
        careers = res.getStringArray(R.array.people_career);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter;

        adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.list_names, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
        Persona person = new Persona(names[pos], lastnames[pos], careers[pos], mails[pos], getImageId(imgNames[pos]), imgNames[pos]);
        Bundle sendBundle =  new Bundle();
        sendBundle.putSerializable(FRAG_KEY, person);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            Intent newIntenet = new Intent(getActivity().getApplicationContext(), PersonActivity.class);

            newIntenet.putExtras(sendBundle);

            startActivity(newIntenet);

        }else if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){

            PersonViewer frag = new PersonViewer();
            frag.setArguments(sendBundle);

            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.viewer, frag);
            fragmentTransaction.commit();
        }
    }

    private int getImageId(String ImgName){
        switch (ImgName){
            case "amrg":
                return R.drawable.amrg;

            case "daht":
                return R.drawable.daht;

            case "oeot":
                return R.drawable.oeot;

            case "amlw":
                return R.drawable.amlw;

            case "kiga":
                return R.drawable.kiga;

            case "elqs":
                return R.drawable.elqs;

            case "eeal":
                return R.drawable.eeal;
        }
        return 0;
    }

}
