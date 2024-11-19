package com.example.examen;

import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Fragments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragments);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentContainerView, new editText(), "editText")
                .add(R.id.fragmentContainerView2, new ShowText(), "ShowText")
                .add(R.id.fragmentContainerView3, new ColorChange(), "ColorChange").commit();
    }
    public void updateFragmentText(int textSize, String text){
        ((ShowText) getSupportFragmentManager().findFragmentByTag("ShowText")).changeText(textSize, text);
    }
    public void updateFragmentColor(int color){
        ((ShowText) getSupportFragmentManager().findFragmentByTag("ShowText")).changeColor(color);
    }
}
