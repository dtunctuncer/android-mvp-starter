package {{ cookiecutter.package_name }}.main;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import {{ cookiecutter.package_name }}.R;
import {{ cookiecutter.package_name }}.base.BaseActivity;
import {{ cookiecutter.package_name }}.Application;
import {{ cookiecutter.package_name }}.main.DaggerMainComponent;
import {{ cookiecutter.package_name }}.main.IMainView;
import {{ cookiecutter.package_name }}.main.MainModule;
import {{ cookiecutter.package_name }}.main.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IMainView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rootView)
    View parentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        DaggerMainComponent.builder().applicationComponent(Application.getComponent()).mainModule(new MainModule(this)).build().inject(this);
    }
}