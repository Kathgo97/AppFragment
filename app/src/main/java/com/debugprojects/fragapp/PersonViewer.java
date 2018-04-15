package com.debugprojects.fragapp;

import android.content.Context;
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
import de.hdodenhof.circleimageview.CircleImageView;
import static com.debugprojects.fragapp.ListViewer.FRAG_KEY;

/**
 * Created by Douglashdezt
 */
public class PersonViewer extends Fragment {

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
        Persona p1;

        if(bundle != null){
            p1 = (Persona) bundle.getSerializable(FRAG_KEY);

            circleImage.setImageResource(p1.getImage_resource_id());
            text_name.setText(p1.getFullName());
            text_career.setText(p1.getCareer_var());
            text_mail.setText(p1.getMail_var());

            Toast.makeText(getActivity(), "Item: " + p1.getFirstName_var()+" "+p1.getLastName1_var(), Toast.LENGTH_SHORT).show();
        }

        return view;
    }

    private void getAllViews(View v){
        circleImage = v.findViewById(R.id.person_image);
        text_name = v.findViewById(R.id.text_view_name);
        text_mail = v.findViewById(R.id.text_view_mail);
        text_career = v.findViewById(R.id.text_view_career);
        button_share = v.findViewById(R.id.button_share);
    }
}
