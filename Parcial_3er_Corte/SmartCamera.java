public class SmartCamera extends SmartDevice {
    private String resolucion;
    private boolean grabando;

    public SmartCamera(String id, String nombre, boolean estadoActivo, String resolucion) {
        super(id, nombre, estadoActivo);
        this.resolucion = resolucion;
        this.grabando = false;
    }

    @Override
    public void encender() {
        estadoActivo = true;
        System.out.println(nombre + " encendida con resolución: " + resolucion);
    }

    @Override
    public void apagar() {
        estadoActivo = false;
        grabando = false;
        System.out.println(nombre + " apagada");
    }

    @Override
    public void mostrarEstado() {
        System.out.println("Camara " + id + " - " + nombre + " - " + "activo: " + estadoActivo +
                " - resolucion: " + resolucion + " - grabando: " + grabando);
    }

    public void iniciarGrabacion() {
        if (estadoActivo) {
            grabando = true;
            System.out.println(nombre + " grabando");
        } else {
            System.out.println(nombre + " camara apagada, no se puede grabar :(");
        }
    }

    public void detenerGrabacion() {
        grabando = false;
        System.out.println(nombre + " grabacion detenida");
    }
}
