public class SmartLight extends SmartDevice {
    private int brillo;

    public SmartLight(String id, String nombre, boolean estadoActivo, int brillo) {
        super(id, nombre, estadoActivo);
        this.brillo = brillo;
    }

    @Override
    public void encender() {
        estadoActivo = true;
        // profe aqui decimos que si es 0 que ponga 50 por defecto ;)
        if (brillo == 0)
            brillo = 50;
        System.out.println(nombre + " encendida con brillo al " + brillo + "%");
    }

    // aqui apagamos la luz
    @Override
    public void apagar() {
        estadoActivo = false;
        System.out.println(nombre + ": apagada");
    }

    // mostramos el estado de la luz :)
    @Override
    public void mostrarEstado() {
        System.out.println("linterna " + id + " - " + nombre + " - " + "activo: " + estadoActivo + " - " + "brillo: "
                + brillo + "%");
    }
}
