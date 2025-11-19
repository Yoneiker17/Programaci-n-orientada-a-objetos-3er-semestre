public class SmartThermostat extends SmartDevice {
    private double temperaturaActual;
    private double temperaturaObjetivo;

    public SmartThermostat(String id, String nombre, boolean estadoActivo, double tempActual, double tempObjetivo) {
        super(id, nombre, estadoActivo);
        this.temperaturaActual = tempActual;
        this.temperaturaObjetivo = tempObjetivo;
    }

    @Override
    public void encender() {
        estadoActivo = true;
        System.out.println(nombre + ": encendido, objetivo " + temperaturaObjetivo + " °C");
    }

    @Override
    public void apagar() {
        estadoActivo = false;
        System.out.println(nombre + ": apagado");
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Termostato " + id + " - " + nombre + " - " + "activo: " + estadoActivo + " - " +
                "actual: " + temperaturaActual + " °C - " + "objetivo: " + temperaturaObjetivo + " °C");
    }

    // metodo para cambiar objetivo
    public void setTemperaturaObjetivo(double objetivo) {
        this.temperaturaObjetivo = objetivo;
        if (estadoActivo)
            System.out.println(nombre + " - " + "nueva temperatura: " + objetivo);
    }
}
