package com.edwinacubillos.losverdes;

/**
 * Created by Edwin on 20/09/2016.
 */
public class Lista_Entrada {

    private int idImagen,precio;
    private String nombre, descripcion;

    public Lista_Entrada(int idImagen, int precio, String nombre, String descripcion) {
        this.idImagen = idImagen;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}



