package com.example.examen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class ColorChange extends Fragment {


    public ColorChange() {
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
        return inflater.inflate(R.layout.fragment_color_change, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.change_color).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int red = ((SeekBar)view.findViewById(R.id.red)).getProgress();
                int green = ((SeekBar)view.findViewById(R.id.green)).getProgress();
                int blue = ((SeekBar)view.findViewById(R.id.blue)).getProgress();
                int color = android.graphics.Color.rgb(red, green, blue);
                ((Fragments)requireActivity()).updateFragmentColor(color);
            }
        });
    }
}