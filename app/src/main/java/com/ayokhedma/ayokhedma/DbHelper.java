package com.ayokhedma.ayokhedma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SevenTG on 18/04/2017.
 */

public class DbHelper extends SQLiteOpenHelper{

    public static final String DB_NAME = "ayokhedma.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_CATEGORY = "category";
    public static final String CAT_NAME = "cat_name";

    public static final String TABLE_REGION = "region";
    public static final String REG_NAME = "reg_name";

    public static final String TABLE_STREET = "street";
    public static final String STR_NAME = "str_name";

    public static final String TABLE_OBJECT = "objects";
    public static final String OBJ_NAME = "obj_name";
    public static final String OBJ_DES = "obj_des";
    public static final String OBJ_STR_SIDE = "street_side";
    public static final String OBJ_CAT_ID = "street_side";
    public static final String OBJ_REG_ID = "street_side";
    public static final String OBJ_STR_ID = "street_side";

    public static final String TABLE_PHONE = "phone";
    public static final String PHO_NUM = "pho_num";
    public static final String PHO_OBJ_ID = "street_side";

    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORY +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                CAT_NAME + " TEXT");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_REGION +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                REG_NAME + " TEXT");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_STREET +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                STR_NAME + " TEXT");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_PHONE +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                PHO_NUM + " TEXT," + PHO_OBJ_ID + " INTEGER");
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_OBJECT +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                OBJ_NAME + " TEXT," + OBJ_DES + " TEXT," +
                OBJ_STR_SIDE + " TEXT," + OBJ_CAT_ID + " INTEGER," +
                OBJ_REG_ID + " INTEGER," + OBJ_STR_ID + " INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STREET);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OBJECT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PHONE);
        onCreate(db);
    }



}
