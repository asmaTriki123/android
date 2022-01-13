package isetb.tp6.applivre;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME="livre_db";
    public static final String TABLE_livre="live";
    public static final String COL_ID="_id";
    public static final String COL_Rurique="rubrique";
    public static final String COL_Auteur="auteur";
    public static final String COL_Titre="titre";

    public static final String CREATE_livre_TABLE= "CREATE TABLE "+TABLE_livre+" ("+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_Rurique+" TEXT NOT NULL, "+ COL_Auteur+" TEXT , "+COL_Titre+" TEXT )";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_livre_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_livre);
        onCreate(db);
    }
    public SQLiteDatabase open(){
        db=this.getWritableDatabase();
        return db;
    }
    public void AddStudent(Livre l){
        open();
        ContentValues v = new ContentValues();
        v.put(COL_Rurique,l.getRubrique());
        v.put(COL_Auteur,l.getAuteur());
        v.put(COL_Titre,l.getTitre());
        db.insert(TABLE_livre,null,v);
    }
    public void UpdateStudent(Livre l){
        open();
        ContentValues v = new ContentValues();
        v.put(COL_Rurique,l.getRubrique());
        v.put(COL_Auteur,l.getAuteur());
        v.put(COL_Titre,l.getTitre());
        db.update(TABLE_livre,v,COL_ID+"=?",new String[]{String.valueOf(l.getId())});}

    public void DeleteStudent(int id){
        open();
        db.delete(TABLE_livre,COL_ID+"=?",new String[]{String.valueOf(id)});
    }
    public ArrayList<Livre> getAllStudent(){
        ArrayList<Livre> list=new ArrayList<Livre>();
        db=this.getReadableDatabase();
        Cursor c=db.query(TABLE_livre,null,null,null,null,null,null,null);
        c.moveToFirst();
        do {
            Livre t =new Livre(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            list.add(t);
        }
        while (c.moveToNext());

        return list;

    }


    public int getStudentCount(){
        db=this.getReadableDatabase();
        Cursor c=db.query(TABLE_livre,null,null,null,null,null,null,null);
        return c.getCount();

    }




}

