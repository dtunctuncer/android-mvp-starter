package {{ cookiecutter.package_name }}.main;

import {{ cookiecutter.package_name }}.di.ActivityScope;
import {{ cookiecutter.package_name }}.di.ApplicationComponent;

import dagger.Component;

@ActivityScope
@Component(modules = {MainModule.class}, dependencies = {ApplicationComponent.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
