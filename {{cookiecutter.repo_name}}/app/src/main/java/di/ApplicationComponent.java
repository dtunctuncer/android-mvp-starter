package {{ cookiecutter.package_name }}.di;

import android.content.Context;
import android.content.SharedPreferences;

import {{ cookiecutter.package_name }}.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Application app();

    Context context();

    SharedPreferences preferences();
}