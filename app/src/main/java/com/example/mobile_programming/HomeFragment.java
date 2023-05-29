package com.example.mobile_programming;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.PrivateKey;

public class HomeFragment extends Fragment {

private RadioGroup rdgGender;
//private RadioButton rdMale, rdFemale, rdOthers;
    private CheckBox chkJava, chkPython, chkReact;
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
        chkJava=view.findViewById(R.id.chkJava);
        chkPython= view.findViewById(R.id.chkPython);
        chkReact= view.findViewById(R.id.chkReact);

        btnSend=view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skills="";
                if (chkJava.isChecked()){
                    skills=skills+" "+chkJava.getText().toString();
                } if (chkPython.isChecked()){
                    skills=skills+","+chkPython.getText().toString();
                }if (chkReact.isChecked()){
                    skills=skills+","+chkReact.getText().toString();
                }

                String value =((RadioButton) view.findViewById(rdgGender.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getContext(), value, Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "your skills :"+skills, Toast.LENGTH_SHORT).show();
            }
        });


    }
}