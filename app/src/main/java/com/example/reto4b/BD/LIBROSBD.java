package com.example.reto4b.BD;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LIBROSBD extends SQLiteOpenHelper {


    private static final String DATABASE_NOMBRE = "libros.db";
    public static final String TABLE_LIBROS = "libros";


    public LIBROSBD(@Nullable Context contexto) {
        super(contexto, DATABASE_NOMBRE,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+  TABLE_LIBROS +"( "+
                "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "titulo TEXT," +
                "subtitulo TEXT," +
                "isbn TEXT," +
                "autor TEXT," +
                "anio INTEGER," +
                "precio REAL)";
        sqLiteDatabase.execSQL(sql);

        String insert = "INSERT INTO libros VALUES (null," +
                "'Android con ejemplos'," +
                "'No aplica'," +
                "'9874568135'," +
                "'Jesús Tomás G.',2017,57950.5)";
        sqLiteDatabase.execSQL(insert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE "+ TABLE_LIBROS);
        onCreate(db);
    }



}
