package com.example.firstip3.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firstip3.Constants;
import com.example.firstip3.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.findNewsbutton) Button mFindNewsbutton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;

    Animation androidZoomInAnimation;
    ImageView zoomInImg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface caviarFont = Typeface.createFromAsset(getAssets(), "fonts/caviar_dreams/CaviarDreams.ttf");
        mAppNameTextView.setTypeface(caviarFont);

        mFindNewsbutton.setOnClickListener(this);

        btn = (Button) findViewById(R.id.findNewsbutton);
        androidZoomInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
        btn.startAnimation(androidZoomInAnimation);

    }




    @Override
    public void onClick(View v) {
        if (v == mFindNewsbutton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(MainActivity.this, NewsActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}

