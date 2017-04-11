package {{ cookiecutter.package_name }}.di;

import android.content.Context;
import android.content.SharedPreferences;

import {{ cookiecutter.package_name }}.Application;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
{% if cookiecutter.retrofit == "n" %}
@Component(modules = {ApplicationModule.class})
{% endif %}
{% if cookiecutter.retrofit == "y" %}
@Component(modules = {ApplicationModule.class,NetModule.class})
{% endif %}
public interface ApplicationComponent {
    Application app();

    Context context();

    SharedPreferences preferences();
}