package {{ cookiecutter.package_name }}.di;

{% if cookiecutter.greendao == "y" %}
import {{ cookiecutter.package_name }}.Application;
import {{ cookiecutter.package_name }}.db.DaoMaster;
import {{ cookiecutter.package_name }}.db.DaoSession;
import {{ cookiecutter.package_name }}.utils.DaoUpdateHelper;
import org.greenrobot.greendao.database.Database;
{% endif %}
{% if cookiecutter.realm == "y" %}
import android.content.Context;

import io.realm.Realm;
{% endif %}
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
@Singleton
public class DatabaseModule {
    {% if cookiecutter.greendao == "y" %}
    @Provides
    @Singleton
    DaoSession providesDao(Application application){
        DaoUpdateHelper helper = new DaoUpdateHelper(application, "db");
        Database db = helper.getWritableDb();
        return new DaoMaster(db).newSession();
    }
    {% endif %}

    {% if cookiecutter.realm == "y" %}
    @Provides
    @Singleton
    Realm provideRealm(Context context){
        Realm.init(context);
        return Realm.getDefaultInstance();
    }
    {% endif %}
}