package {{ cookiecutter.package_name }}.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import {{ cookiecutter.package_name }}.Application;
import {{ cookiecutter.package_name }}.utils.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application app;

    public ApplicationModule(Application app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application provideApp() {
        return app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    RxBus provideBus() {
        return new RxBus();
    }
}
