/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author Yonei
 */
public class Moto extends Vehiculo {
    private String tipo;

    public Moto(String marca, String modelo, int anio, String tipo) {
        super(marca, modelo, anio);
        this.tipo = tipo;
    }

    @Override
    public String mostrarInfo() {
        return "Moto: " + marca + " " + modelo + " - Año: " + anio + " - Tipo: " + tipo;
    }
}
