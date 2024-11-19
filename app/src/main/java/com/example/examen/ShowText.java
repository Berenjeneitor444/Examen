package com.example.examen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ShowText extends Fragment {

    public ShowText() {
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
        return inflater.inflate(R.layout.fragment_show_text, container, false);
    }
    public void changeText(int textSize, String text){
        TextView textview = getView().findViewById(R.id.text);
        if(textview != null) {
            textview.setTextSize(textSize);
            textview.setText(text);
        }
    }
    public void changeColor(int color){
        TextView textview = getView().findViewById(R.id.text);
        if(textview != null) {
            textview.setTextColor(color);
        }

    }
}