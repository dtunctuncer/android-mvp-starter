package {{ cookiecutter.package_name }}.helpers;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import {{ cookiecutter.package_name }}.fragments.AboutFragment;
import {{ cookiecutter.package_name }}.fragments.MainFragment;
import {{ cookiecutter.package_name }}.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    public void changeMenuFragment(int position) {
        Fragment fragment = null;

        switch (position) {
            case 1:
                fragment = new MainFragment();
                break;
            case 2:
                fragment = new AboutFragment();
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.root_view, fragment);
            fragmentTransaction.commit();

        }
    }
}