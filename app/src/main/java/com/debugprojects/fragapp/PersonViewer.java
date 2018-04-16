package com.debugprojects.fragapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;
import static com.debugprojects.fragapp.ListViewer.FRAG_KEY;

/**
 * Created by Douglashdezt
 */
public class PersonViewer extends Fragment {

    private Persona p1;

    private CircleImageView circleImage;
    private TextView text_name;
    private TextView text_mail;
    private TextView text_career;
    private Button button_share;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_viewer, container, false);

        getAllViews(view);

        Bundle bundle = this.getArguments();

        if(bundle != null){
            p1 = (Persona) bundle.getSerializable(FRAG_KEY);
            circleImage.setImageResource(p1.getImage_resource_id());
            text_name.setText(p1.getFullName());
            text_career.setText(p1.getCareer_var());
            text_mail.setText(p1.getMail_var());
            //button_share.setEnabled(true);
        }else{
            p1 = new Persona("##########", "##########", "##########", "##########", R.drawable.empty, "empty");
            //button_share.setEnabled(false);
        }

        circleImage.setImageResource(p1.getImage_resource_id());
        text_name.setText(p1.getFullName());
        text_career.setText(p1.getCareer_var());
        text_mail.setText(p1.getMail_var());

//        button_share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                sendPack(p1);
//            }
//        });

        return view;
    }

    private void getAllViews(View v){
        circleImage = v.findViewById(R.id.person_image);
        text_name = v.findViewById(R.id.text_view_name);
        text_mail = v.findViewById(R.id.text_view_mail);
        text_career = v.findViewById(R.id.text_view_career);
        //button_share = v.findViewById(R.id.button_share);
    }

    @SuppressLint("SetWorldReadable")
    private void sendPack(Persona per){
        String texto = "Nombre: "+ per.getFullName() + "\nCorreo: " +
                per.getMail_var() + "\nCarrera: "+ per.getCareer_var();

        try {
            //Convertir el recurso en bitmap
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), per.getImage_resource_id());

            //Guardar el bitmap en cache
            File outputFile = new File(getActivity().getApplicationContext().getCacheDir(), per.getImage_name() + ".png");
            FileOutputStream outPutStream = new FileOutputStream(outputFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, outPutStream);
            outPutStream.flush();
            outPutStream.close();
            outputFile.setReadable(true, false);

            //share file
            Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(outputFile));
//            shareIntent.setType("image/png");
            shareIntent.putExtra(Intent.EXTRA_TEXT, texto);
            startActivity(shareIntent);
        }
        catch (Exception e) { Toast.makeText(getActivity().getApplicationContext(), "error", Toast.LENGTH_LONG).show();
        }

    }
}
