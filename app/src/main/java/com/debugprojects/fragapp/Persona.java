package com.debugprojects.fragapp;
import android.net.Uri;

import java.io.Serializable;

public class Persona implements Serializable {
    private String fullName;
    private String firstName_var;
    private String secondName_var;
    private String lastName1_var;
    private String lastName2_var;
    private int image_resource_id;
    private String career_var;
    private String mail_var;

    public Persona(String name, String lastName ,String career, String mail,int image_id){
        String[] names = name.split("\\s");
        String[] lastNames = lastName.split("\\s");

        fullName = name + " " + lastName;
        firstName_var = names [0];
        secondName_var = names [1];
        lastName1_var = lastNames[0];
        lastName2_var = lastNames[1];

        image_resource_id= image_id;

        career_var = career;
        mail_var = mail + "@uca.edu.sv";
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName_var() {
        return firstName_var;
    }

    public String getSecondName_var() {
        return secondName_var;
    }

    public String getLastName1_var() {
        return lastName1_var;
    }

    public String getLastName2_var() {
        return lastName2_var;
    }

    public int getImage_resource_id() {
        return image_resource_id;
    }

    public String getCareer_var() {
        return career_var;
    }

    public String getMail_var() {
        return mail_var;
    }
}
