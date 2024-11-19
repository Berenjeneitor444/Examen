package com.example.examen;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SunSet extends AppCompatActivity {

    private boolean esMigDia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sunset);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        esMigDia = true;
        findViewById(R.id.sky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int noon = getResources().getColor(R.color.noonSky);
                final int dusk = getResources().getColor(R.color.duskSky);
                final int afternoon = getResources().getColor(R.color.afternoonSky);
                final int night = getResources().getColor(R.color.nightSky);
                ObjectAnimator animadorSol;
                ObjectAnimator animadorCielo;
                if (esMigDia) {
                    animadorSol = ObjectAnimator.ofFloat(findViewById(R.id.sun), "translationY", 700f);
                    animadorCielo = ObjectAnimator.ofInt(findViewById(R.id.sky), "backgroundColor", noon, dusk, afternoon, night);
                }
                else {
                    animadorSol = ObjectAnimator.ofFloat(findViewById(R.id.sun), "translationY", -0f);
                    animadorCielo = ObjectAnimator.ofInt(findViewById(R.id.sky), "backgroundColor", night, afternoon, dusk, noon);
                }
                animadorCielo.setDuration(4500);
                animadorCielo.setEvaluator(new ArgbEvaluator());
                animadorSol.setDuration(4500);
                AnimatorSet postaDeSol = new AnimatorSet();
                postaDeSol.playTogether(animadorSol, animadorCielo);
                postaDeSol.start();
                esMigDia = !esMigDia;

            }
        });
    }
}