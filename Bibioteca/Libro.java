import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Libro {
    private String titulo, nombreAutor, fechaPublicacion;

    public Libro(String titulo, String nombreAutor, String fechaPublicacion) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }


    public void informacion(ArrayList<Libro> listaLibros) {
        String validacion;
        do {
            String titulo = JOptionPane.showInputDialog("Asigna el título del libro:");
            String fecha = JOptionPane.showInputDialog("Asigna la fecha de publicación del libro:");
            String autor = JOptionPane.showInputDialog("Asigna el autor del libro:");

            Libro libro = new Libro(titulo, autor, fecha);
            listaLibros.add(libro);

            validacion = JOptionPane.showInputDialog("¿Deseas agregar otro libro? (si/no)");
        } while (validacion != null && validacion.equalsIgnoreCase("si"));

        mostrarLibros(listaLibros);
    }

    
    public void actualizar(ArrayList<Libro> listaLibros) {
        String cambio = JOptionPane.showInputDialog("¿Quieres cambiar los datos de un libro? (si/no)");
        if (cambio != null && cambio.equalsIgnoreCase("si")) {
            String validacion;
            do {
                String indiceStr = JOptionPane.showInputDialog("¿Cuál es el índice a cambiar? (0 - " + (listaLibros.size()-1) + ")");
                int indice = Integer.parseInt(indiceStr);

                String nuevoTitulo = JOptionPane.showInputDialog("Escribe el título:");
                String nuevaFecha = JOptionPane.showInputDialog("Escribe la fecha de publicación:");
                String nuevoAutor = JOptionPane.showInputDialog("Escribe el nombre del autor:");

                listaLibros.get(indice).setTitulo(nuevoTitulo);
                listaLibros.get(indice).setFechaPublicacion(nuevaFecha);
                listaLibros.get(indice).setNombreAutor(nuevoAutor);

                validacion = JOptionPane.showInputDialog("¿Quieres cambiar los datos de otro libro? (si/no)");
            } while (validacion != null && validacion.equalsIgnoreCase("si"));

            mostrarLibros(listaLibros);
        } else {
            JOptionPane.showMessageDialog(null, "Ningún cambio realizado.");
        }
    }

    
    public void mostrarLibros(ArrayList<Libro> listaLibros) {
        StringBuilder sb = new StringBuilder("Lista de libros:\n");
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro l = listaLibros.get(i);
            sb.append(i).append(") ").append(l.getTitulo())
              .append(" | ").append(l.getFechaPublicacion())
              .append(" | ").append(l.getNombreAutor())
              .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getNombreAutor() {
        return nombreAutor;
    }
    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }
    public String getFechaPublicacion() {
        return fechaPublicacion;
    }
    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
