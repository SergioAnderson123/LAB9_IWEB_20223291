package org.example.lab9_20223291.Dto;

import java.math.BigDecimal;

public class CreacionyListadoDeProductosDto {

    private int id;
    private String nombre;
    private String categoriaNombre;
    private BigDecimal precio;
    private int stockCalculado;

    // Getters y Setters:


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoriaNombre() {
        return categoriaNombre;
    }

    public void setCategoriaNombre(String categoriaNombre) {
        this.categoriaNombre = categoriaNombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStockCalculado() {
        return stockCalculado;
    }

    public void setStockCalculado(int stockCalculado) {
        this.stockCalculado = stockCalculado;
    }


}
