package {{ cookiecutter.package_name }}.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import {{ cookiecutter.package_name }}.db.DaoMaster;
import org.greenrobot.greendao.database.Database;

public class DaoUpdateHelper extends DaoMaster.OpenHelper {
    public DaoUpdateHelper(Context context, String name) {
        super(context, name);
    }
    public DaoUpdateHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //DaoMigrationHelper.getInstance().migrate(db, PlaylistDao.class,MusicDao.class); Example usage of Migration Helper
    }
}