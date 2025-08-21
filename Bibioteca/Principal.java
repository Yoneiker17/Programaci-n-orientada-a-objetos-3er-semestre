import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<Libro> listaLibros = new ArrayList<>();
        Libro libro = new Libro("", "", "");

        libro.informacion(listaLibros);
        libro.actualizar(listaLibros);
    }
}
