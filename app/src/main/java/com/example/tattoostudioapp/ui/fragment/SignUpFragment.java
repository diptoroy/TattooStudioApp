package com.example.tattoostudioapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpFragment extends Fragment {
    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        init(view);
        return view;
    }

    //init all the field
    private void init(View view){
        EditText fullnameEdit,userEdit,passwordEdit;
        ImageView nextBtn,fbBtn,gglBtn;

        fullnameEdit = view.findViewById(R.id.editTextuseFullname);
        userEdit = view.findViewById(R.id.editTextusename);
        passwordEdit = view.findViewById(R.id.editTextTextpasswrod);
        nextBtn = view.findViewById(R.id.goBtn);
        fbBtn = view.findViewById(R.id.fbBtn);
        gglBtn = view.findViewById(R.id.gglBtn);

        String fullName = fullnameEdit.toString().trim();
        String userName = userEdit.toString().trim();
        String password = passwordEdit.toString().trim();

        action(nextBtn,fbBtn,gglBtn);
    }

    //Button for next action
    private void action(ImageView nextBtn,ImageView fbBtn,ImageView gglBtn) {

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),BioActivity.class));
            }
        });

        fbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Signup using Facebook!",Toast.LENGTH_SHORT).show();
            }
        });

        gglBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Signup using Google!",Toast.LENGTH_SHORT).show();
            }
        });
    }

}