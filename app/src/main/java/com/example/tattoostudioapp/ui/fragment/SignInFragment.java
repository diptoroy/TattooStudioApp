package com.example.tattoostudioapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


public class SignInFragment extends Fragment {
    FrameLayout parentFrameLayout;
    public SignInFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_sign_in, container, false);
        init(view);
        return view;
    }


    //init all the field
    private void init(View view){
        EditText userEdit,passwordEdit;
        TextView signUpBtn;
        ImageView nextBtn;



        parentFrameLayout = getActivity().findViewById(R.id.frameLayout);
        userEdit = view.findViewById(R.id.editTextLoginname);
        passwordEdit = view.findViewById(R.id.editTextloginpassword);
        signUpBtn = view.findViewById(R.id.signupBtn);
        nextBtn = view.findViewById(R.id.goBtn);

        String userName = userEdit.toString().trim();
        String password = passwordEdit.toString().trim();

        action(signUpBtn,nextBtn,userName,password);
    }

    //Button for next action
    private void action(TextView signUpBtn, ImageView nextBtn,String name,String password) {
        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),BioActivity.class));
            }
        });
    }



    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_right,R.anim.slide_out_from_left);
        fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
        fragmentTransaction.commit();
    }

}