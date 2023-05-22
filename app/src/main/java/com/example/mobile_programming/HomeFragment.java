package com.example.mobile_programming;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.security.PrivateKey;

public class HomeFragment extends Fragment {

private RadioGroup rdgGender;
//private RadioButton rdMale, rdFemale, rdOthers;
private Button btnSend;
private View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        findViews();
        return view;
    }
    private void findViews(){
        rdgGender=view.findViewById(R.id.rdgGender);
//        rdMale=view.findViewById(R.id.rdMale);
//        rdFemale=view.findViewById(R.id.rdFemale);
//        rdOthers=view.findViewById(R.id.rdOthers);
        btnSend=view.findViewById(R.id.btnSend);


    }
}