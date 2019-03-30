package com.example.dell.myapplication.lottie;

import android.animation.ValueAnimator;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieAnimationView;
import com.example.dell.myapplication.R;

public class LottieActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        animationView = findViewById(R.id.animation_view);
        animationView.setAnimation(R.raw.hello_world);
        animationView.playAnimation();
        animationView.setRepeatCount(ValueAnimator.INFINITE);
        animationView.setRepeatMode(ValueAnimator.REVERSE);

    }
}
