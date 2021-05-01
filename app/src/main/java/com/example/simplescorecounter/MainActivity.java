package com.example.simplescorecounter;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables
    int scorePlayer1;
    int scorePlayer2;
    TextView txtPlayer1;
    TextView txtPlayer2;
    Animation fadeEffect;
    Animation rotateAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize variables
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        txtPlayer1 = (TextView) findViewById(R.id.txtScorePlayer1);
        txtPlayer2 = (TextView) findViewById(R.id.txtScorePlayer2);
        fadeEffect = AnimationUtils.loadAnimation(this, R.anim.fade_effect);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
    }

    public void countScore(View v) {
        String myTag = v.getTag().toString();
        v.startAnimation(fadeEffect);

        if(myTag.equals("player1")) {
            scorePlayer1++;
            txtPlayer1.setText(String.valueOf(scorePlayer1));
        }
        else {
            scorePlayer2++;
            txtPlayer2.setText(String.valueOf(scorePlayer2));
        }
    }

    public void resetCounters(View v) {
        v.startAnimation(rotateAnimation);

        scorePlayer1 = 0;
        scorePlayer2 = 0;
        txtPlayer1.setText(String.valueOf(scorePlayer1));
        txtPlayer2.setText(String.valueOf(scorePlayer2));
    }

}