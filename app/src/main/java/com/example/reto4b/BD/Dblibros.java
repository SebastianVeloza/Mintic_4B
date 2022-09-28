package com.example.reto4b.BD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.reto4b.Entidades.LIBROS;

import java.util.ArrayList;

public class Dblibros extends LIBROSBD{
    Context context;
    public Dblibros(@Nullable Context contexto) {
        super(contexto);
        this.context = context;
    }
    public long InsertarLibro(String titulo, String subtitulo, String isbn,String autor, int anio,int precio) {

        long id = 0;

        try {
            LIBROSBD dbHelper = new LIBROSBD(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("titulo", titulo);
            values.put("subtitulo", subtitulo);
            values.put("isbn", isbn);
            values.put("autor", autor);
            values.put("anio", anio);
            values.put("precio", precio);

            id = db.insert(TABLE_LIBROS, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return id;
    }

    public ArrayList<LIBROS> mostrarLibros() {

        LIBROSBD dbHelper = new LIBROSBD(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<LIBROS> listaLibross = new ArrayList<>();
        LIBROS Libros;
        Cursor cursorLibross;

        cursorLibross = db.rawQuery("SELECT * FROM " + TABLE_LIBROS + " ORDER BY titulo ASC", null);

        if (cursorLibross.moveToFirst()) {
            do {
                Libros = new LIBROS();
                Libros.setTitulo(cursorLibross.getString(0));
                Libros.setSubtitulo(cursorLibross.getString(1));
                Libros.setIsbn(cursorLibross.getString(2));
                Libros.setAutor(cursorLibross.getString(2));
                Libros.setAnio_publicacion(cursorLibross.getInt(4));
                Libros.setPrecio(cursorLibross.getInt(5));
                listaLibross.add(Libros);
            } while (cursorLibross.moveToNext());
        }

        cursorLibross.close();

        return listaLibross;
    }

    public LIBROS verLibros(int id) {

        LIBROSBD librosbd = new LIBROSBD(context);
        SQLiteDatabase db = librosbd.getWritableDatabase();

        LIBROS Libros = null;
        Cursor cursorLibross;

        cursorLibross = db.rawQuery("SELECT * FROM " + TABLE_LIBROS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorLibross.moveToFirst()) {
            Libros = new LIBROS();
            Libros.setTitulo(cursorLibross.getString(0));
            Libros.setSubtitulo(cursorLibross.getString(1));
            Libros.setIsbn(cursorLibross.getString(2));
            Libros.setAutor(cursorLibross.getString(2));
            Libros.setAnio_publicacion(cursorLibross.getInt(4));
            Libros.setPrecio(cursorLibross.getInt(5));
        }

        cursorLibross.close();

        return Libros;
    }

    public boolean editarLibros(int id, String nombre, String telefono, String correo_electronico) {

        boolean correcto = false;

        LIBROSBD LibrosBD = new Dblibros(context);
        SQLiteDatabase db = LibrosBD.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_LIBROS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', correo_electronico = '" + correo_electronico + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarLibros(int id) {

        boolean correcto = false;

        LIBROSBD librosbd = new LIBROSBD(context);
        SQLiteDatabase db = librosbd.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_LIBROS + " WHERE id = '" + id + "'");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

}
