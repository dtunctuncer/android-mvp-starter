package {{ cookiecutter.package_name }}.main;


import {{ cookiecutter.package_name }}.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private IMainView view;

    public MainModule(IMainView view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    IMainView provideView(){
        return view;
    }
}
