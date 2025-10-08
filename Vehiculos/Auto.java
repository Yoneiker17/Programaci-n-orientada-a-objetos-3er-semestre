/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author Yonei
 */
public class Auto extends Vehiculo {
    private int puertas;

    public Auto(String marca, String modelo, int anio, int puertas) {
        super(marca, modelo, anio);
        this.puertas = puertas;
    }

    @Override
    public String mostrarInfo() {
        return "Auto: " + marca + " " + modelo + " - Año: " + anio + " - Puertas: " + puertas;
    }
}

