package com.example.hankemall.ui;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hankemall.R;
import com.example.hankemall.common.ActivityUtils;
public class SplashActivity extends AppCompatActivity {
    private ImageView iv_logo;
    private ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        iv_logo= (ImageView) findViewById(R.id.iv_logo);
        activityUtils=new ActivityUtils(this);

        SharedPreferences sp=getSharedPreferences("runconfig",MODE_PRIVATE);
        //key=isFirstRun 表示第一次登录  如果取不到对应的value值，就取默认的true值
        boolean isFirstRun=sp.getBoolean("isFirstRun",true);
        if(!isFirstRun){
            activityUtils.startActivity(MainActivity.class);
            finish();
            return;
        }

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.logo);
        animation.setAnimationListener(animationListener);//设置动画监听
        iv_logo.startAnimation(animation);//启动动画
    }

    private Animation.AnimationListener animationListener=new Animation.AnimationListener() {
        //动画开始
        @Override
        public void onAnimationStart(Animation animation) {

        }
        //动画结束
        @Override
        public void onAnimationEnd(Animation animation) {
            activityUtils.startActivity(LeadActivity.class);

            SharedPreferences sp=getSharedPreferences("runconfig",MODE_PRIVATE);
            SharedPreferences.Editor editor=sp.edit();
            editor.putBoolean("isFirstRun",false);
            editor.commit();
            finish();
        }
        //动画重复
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };
}
