/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprograi;

import java.io.Serializable;

/**
 *
 * @author Walter Morales
 */
public class Factura implements Serializable{


    private String NoFactura;

    public String getNoFactura() {
        return NoFactura;
    }

    public void setNoFactura(String NoFactura) {
        this.NoFactura = NoFactura;
    }
    private String Nit;
    private String Nombre;
    private String Direccion;
    private String Producto;
    private Integer Cantidad;
    private Float Precio;
    private Float Total;
    private String Usuario;

   
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public Factura(String noFactura, String nit, String nombre, String direccion, String producto, int cantidad, float precio, float total, String Usuario) {
    this.NoFactura = noFactura;
    this.Nit = nit;
    this.Nombre = nombre;
    this.Direccion = direccion;
    this.Producto = producto;
    this.Cantidad = cantidad;
    this.Precio = precio;
    this.Total = total;
    this.Usuario = Usuario;

}
public Factura() {
    // No hace nada
}    

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float Precio) {
        this.Precio = Precio;
    }

    public Float getTotal() {
        return Total;
    }

    public void setTotal(Float Total) {
        this.Total = Total;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}
