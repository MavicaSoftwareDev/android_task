package tech.mavica.listview_learn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

public class DBManager {
    DBHelper dbHelper;
    SQLiteDatabase dbManager;
    Context context;
    static  String DB_NAME="accounts";
    static int DB_VERSION = 1;
    static  String table_name="accounts";
    static  String column_id="id";
    static String column_name="name";
    static  String column_job="job";
    static  String column_salary="salary";

    DBManager(Context context,DBHelper dbHelper){
        this.context=context;
        this.dbHelper=dbHelper;
    }

    long insert(String name,String job,String salary){
       dbManager= dbHelper.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("job",job);
        cv.put("salary",salary);
      long x =  dbManager.insert(table_name,null,cv);
       dbHelper.close();
         return  x;
    }

    Cursor display(){
        dbManager=dbHelper.getWritableDatabase();
        Cursor cursor = dbManager.rawQuery("select * from accounts",null);
//       dbHelper.close();
        return cursor;
    }

        long updateStudentInfo(String name,String job,String salary){
        dbManager=dbHelper.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("name",name);
            cv.put("job",job);
            cv.put("salary",salary);
       long x = dbManager.update(table_name,cv,"name=?",new String[]{name});
       dbHelper.close();
return  x;
    }

    long deleteStudent(String name){
        dbManager=dbHelper.getWritableDatabase();
          long x = dbManager.delete(table_name,"name = ?",new String[]{name});
        if(x>=1) Toast.makeText(context, "recored deleted", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, "not deleted !!", Toast.LENGTH_SHORT).show();
        dbHelper.close();
        return x;
    }

}
