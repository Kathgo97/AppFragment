package com.debugprojects.fragapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Douglashdezt
 */
public class PersonViewer extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_viewer, container, false);

        Bundle bundle = this.getArguments();


        if(bundle != null){
            //Toast.makeText(getActivity(), "Item: " + bundle.getString("KEY"), Toast.LENGTH_SHORT).show();

        }

        return view;
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
