package isetb.tp6.applivre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBAh extends SQLiteOpenHelper {

    public DBAh(@Nullable Context context) {
        super(context, "liv.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table util(_id integer primary key autoincrement,nom text,login text,email text ,pass text,role text)");
        Log.d("DB", "DB created!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop TABLE IF EXISTS util" );
        onCreate(db);
    }

    public Boolean insertData(user u){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("nom",u.getNom());
        contentValues.put("login",u.getLogin());
        contentValues.put("email",u.getEmail());
        contentValues.put("pass",u.getPassword());
        contentValues.put("role",u.getRole());
        long result = MyDB.insert("util", null, contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Boolean checkusernamepassword(user u){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from util where login = ? and pass = ? and role = ?", new String[]
                {u.getLogin(),u.getPassword(),u.getRole()});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }



}
