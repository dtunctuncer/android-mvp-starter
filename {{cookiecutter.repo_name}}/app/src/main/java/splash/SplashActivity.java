package {{ cookiecutter.package_name }}.splash;

import {{ cookiecutter.package_name }}.main.MainActivity;
import {{ cookiecutter.package_name }}.base.BaseActivity;
import android.content.Intent;
import android.os.Bundle;

import {{ cookiecutter.package_name }}.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}