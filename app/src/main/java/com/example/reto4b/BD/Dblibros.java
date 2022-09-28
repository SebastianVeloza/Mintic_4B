package com.example.reto4b.BD;

import android.content.ContentValues;
import android.content.Context;
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

        ArrayList<LIBROS> listaContactos = new ArrayList<>();
        LIBROS Libros;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_LIBROS + " ORDER BY titulo ASC", null);

        if (cursorContactos.moveToFirst()) {
            do {
                Libros = new LIBROS();
                Libros.setTitulo(cursorContactos.(1));
                contacto.setTelefono(cursorContactos.getString(2));
                contacto.setCorreo_electornico(cursorContactos.getString(3));
                listaContactos.add(contacto);
            } while (cursorContactos.moveToNext());
        }

        cursorContactos.close();

        return listaContactos;
    }

    public Contactos verContacto(int id) {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Contactos contacto = null;
        Cursor cursorContactos;

        cursorContactos = db.rawQuery("SELECT * FROM " + TABLE_CONTACTOS + " WHERE id = " + id + " LIMIT 1", null);

        if (cursorContactos.moveToFirst()) {
            contacto = new Contactos();
            contacto.setId(cursorContactos.getInt(0));
            contacto.setNombre(cursorContactos.getString(1));
            contacto.setTelefono(cursorContactos.getString(2));
            contacto.setCorreo_electornico(cursorContactos.getString(3));
        }

        cursorContactos.close();

        return contacto;
    }

    public boolean editarContacto(int id, String nombre, String telefono, String correo_electronico) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("UPDATE " + TABLE_CONTACTOS + " SET nombre = '" + nombre + "', telefono = '" + telefono + "', correo_electronico = '" + correo_electronico + "' WHERE id='" + id + "' ");
            correcto = true;
        } catch (Exception ex) {
            ex.toString();
            correcto = false;
        } finally {
            db.close();
        }

        return correcto;
    }

    public boolean eliminarContacto(int id) {

        boolean correcto = false;

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        try {
            db.execSQL("DELETE FROM " + TABLE_CONTACTOS + " WHERE id = '" + id + "'");
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
