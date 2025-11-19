public abstract class SmartDevice {
    protected String id;
    protected String nombre;
    protected boolean estadoActivo;

    public SmartDevice(String id, String nombre, boolean estadoActivo) {
        this.id = id;
        this.nombre = nombre;
        this.estadoActivo = estadoActivo;
    }

    // profe estos son los metodos :)
    public abstract void encender();

    public abstract void apagar();

    public abstract void mostrarEstado();

    // aqui obtenemos los valores
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isActivo() {
        return estadoActivo;
    }
}
