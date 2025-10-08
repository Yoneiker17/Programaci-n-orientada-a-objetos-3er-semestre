/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author Yonei
 */
public class Camion extends Vehiculo {
    private double capacidadCarga;

    public Camion(String marca, String modelo, int anio, double capacidadCarga) {
        super(marca, modelo, anio);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String mostrarInfo() {
        return "Camion: " + marca + " " + modelo + " - Año: " + anio + " - Carga: " + capacidadCarga + " t";
    }
}

