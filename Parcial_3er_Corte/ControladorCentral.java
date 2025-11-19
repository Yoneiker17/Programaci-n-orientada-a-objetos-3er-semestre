import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ControladorCentral {

    private List<SmartDevice> dispositivos;

    public ControladorCentral() {
        this.dispositivos = new ArrayList<>();
    }

    public void agregarDispositivo(SmartDevice d) {
        dispositivos.add(d);
        System.out.println("Agregado: " + d.getNombre() + " - " + "id: " + d.getId());
    }

    public boolean eliminarDispositivoPorId(String id) {

        Optional<SmartDevice> opt = dispositivos.stream()
                .filter(d -> d.getId().equals(id)) 
                .findFirst();

        if (opt.isPresent()) {
            dispositivos.remove(opt.get());
            System.out.println("Se elimino el dispositivo: " + id);
            return true;
        } else {
            System.out.println("No se encontr el dispositivo: " + id);
            return false;
        }
    }

    public void listarDispositivos() {
        System.out.println("\nLista de dispositivos:\n");
        for (SmartDevice d : dispositivos) {
            d.mostrarEstado();
        }
    }

    // Encender todos los dispositivos
    public void encenderTodo() {
        for (SmartDevice d : dispositivos) {
            d.encender();
        }
    }

    // Apagar todos los dispositivos
    public void apagarTodo() {
        for (SmartDevice d : dispositivos) {
            d.apagar();
        }
    }

    // Encender dispositivo por el id
    public void encenderPorId(String id) {
        dispositivos.stream()
                .filter(d -> d.getId().equals(id))
                .forEach(SmartDevice::encender);
    }
}
