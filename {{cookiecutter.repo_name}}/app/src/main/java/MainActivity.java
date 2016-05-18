package {{ cookiecutter.package_name }}.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import {{ cookiecutter.package_name }}.fragments.AboutFragment;
import {{ cookiecutter.package_name }}.fragments.MainFragment;
import {{ cookiecutter.package_name }}.R;

public class MainActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.root_view)
    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        createMenu(savedInstanceState);
        changeMenuFragment(1);
    }

    private void createMenu(Bundle savedInstanceState) {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withSavedInstance(savedInstanceState)
                .withHeaderBackground(R.drawable.material_drawer_badge)
                .withCompactStyle(true)
                .addProfiles(
                        new ProfileDrawerItem()
                                .withName("Android")
                                .withEmail("android@gmail.com")
                                .withIcon(R.mipmap.ic_launcher))
                .build();

        PrimaryDrawerItem homeMenuItem = new PrimaryDrawerItem()
                .withName(getString(R.string.menu_home))
                .withIcon(FontAwesome.Icon.faw_home)
                .withIdentifier(1);

        PrimaryDrawerItem aboutMenuItem = new PrimaryDrawerItem()
                .withName(getString(R.string.menu_about))
                .withIcon(FontAwesome.Icon.faw_info_circle)
                .withIdentifier(2);

        PrimaryDrawerItem exitMenuItem = new PrimaryDrawerItem()
                .withName(getString(R.string.menu_exit))
                .withIcon(FontAwesome.Icon.faw_times_circle)
                .withIdentifier(3);

        DrawerBuilder drawerBuilder = new DrawerBuilder()
                .withActivity(this)
                .withAccountHeader(headerResult)
                .withToolbar(toolbar)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem != null){
                            int id = (int) drawerItem.getIdentifier();
                            switch (id){
                                case 1 :
                                    changeMenuFragment(1);
                                    break;
                                case 2:
                                    changeMenuFragment(2);
                                    break;
                                case 3:
                                    finish();
                                    System.exit(0);
                                    break;
                            }
                        }
                        return false;
                    }
                });

        drawerBuilder.addDrawerItems(homeMenuItem);
        drawerBuilder.addDrawerItems(aboutMenuItem);
        drawerBuilder.addStickyDrawerItems(exitMenuItem);
        drawerBuilder.build();
    }

    private void changeMenuFragment(int position) {
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
