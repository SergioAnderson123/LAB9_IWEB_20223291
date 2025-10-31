package org.example.lab9_20223291.Beans;

import java.sql.Timestamp;

public class Carritoitem {

    private int id_item;
    private Usuario id_usuario;
    private Producto id_producto;
    private int cantidad;
    private Timestamp agregado_en;

    public Carritoitem(int id_item, Usuario id_usuario, Producto id_producto, int cantidad, Timestamp agregado_en) {
        this.id_item = id_item;
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.cantidad = cantidad;
        this.agregado_en = agregado_en;
    }

    // Getters y Setters:

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_item) {
        this.id_item = id_item;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Producto getId_producto() {
        return id_producto;
    }

    public void setId_producto(Producto id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Timestamp getAgregado_en() {
        return agregado_en;
    }

    public void setAgregado_en(Timestamp agregado_en) {
        this.agregado_en = agregado_en;
    }
}
