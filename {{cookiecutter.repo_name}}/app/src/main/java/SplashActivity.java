package {{ cookiecutter.package_name }}.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import {{ cookiecutter.package_name }}.R;

public class SplashActivity extends BaseActivity {

    private static final long DURATION_TIME = 3000;
    AppCompatActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        activity = this;
        Handler handler = new Handler();
        Runnable run =new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(activity,MainActivity.class);
                startActivity(intent);
            }
        };
        handler.postDelayed(run, DURATION_TIME);

    }
}