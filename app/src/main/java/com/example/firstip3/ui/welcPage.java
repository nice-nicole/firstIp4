package com.example.firstip3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstip3.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class welcPage extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.strt)Button strt;
    @BindView(R.id.txtV)TextView txt;

    Animation SlideUpAnimation;
    Animation rot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/caviar_dreams/CaviarDreams.ttf");
        txt.setTypeface(caviarFont);

        txt= (TextView) findViewById(R.id.txtV);
        SlideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slideup);
        txt.startAnimation(SlideUpAnimation);

        strt.setOnClickListener(this);

        rot=AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotateanim);

    }




    @Override
    public void onClick(View v) {
        if (v == strt) {
            Intent intent = new Intent(welcPage.this, LogInActivity.class);
            startActivity(intent);
        }
    }
}
