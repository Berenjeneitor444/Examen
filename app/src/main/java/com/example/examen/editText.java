package com.example.examen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;


public class editText extends Fragment {

    public editText() {
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
        return inflater.inflate(R.layout.fragment_edit_text, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText input = view.findViewById(R.id.input);
        SeekBar textSize = view.findViewById(R.id.text_size);
        view.findViewById(R.id.change_text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Fragments)requireActivity()).updateFragmentText(textSize.getProgress(), input.getText().toString());
            }
        });

    }
}