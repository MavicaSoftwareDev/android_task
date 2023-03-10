package tech.mavica.listview_learn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    Context context;
    static  String DB_NAME="accounts";
    static int DB_VERSION = 1;
    static  String table_name="accounts";
    static  String column_id="id";
    static String column_name="name";
    static  String column_job="job";
    static  String column_salary="salary";
    DBHelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
        this.context=context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table accounts (id integer primary key autoincrement , name text , job text,salary text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
