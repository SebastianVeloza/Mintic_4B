package com.example.reto4b.Entidades;

public class LIBROS {
    private String titulo, subtitulo, isbn, autor;
    private int Anio_publicacion;
    private double precio;

    public LIBROS() {
    }

    public LIBROS(String titulo, String subtitulo, String isbn, String autor, int anio_publicacion, double precio) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.isbn = isbn;
        this.autor = autor;
        Anio_publicacion = anio_publicacion;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnio_publicacion() {
        return Anio_publicacion;
    }

    public void setAnio_publicacion(int anio_publicacion) {
        Anio_publicacion = anio_publicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
