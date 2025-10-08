/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vehiculos;

/**
 *
 * @author Yonei
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrmVehiculos extends JFrame {
    private JTextField textMarca, textModelo, textAnio, textExtra;
    private JComboBox<String> comboTipo;
    private JTextArea areaSalida;

    
    private ArrayList<Auto> listaAutos;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Camion> listaCamiones;

    public FrmVehiculos() {
        setTitle("Registro de Vehículos");
        setSize(700, 420);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

       
        JPanel pnlForm = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlForm.add(new JLabel("Marca:"));
        textMarca = new JTextField(10); pnlForm.add(textMarca);

        pnlForm.add(new JLabel("Modelo:"));
        textModelo = new JTextField(10); pnlForm.add(textModelo);

        pnlForm.add(new JLabel("Año:"));
        textAnio = new JTextField(5); pnlForm.add(textAnio);

        pnlForm.add(new JLabel("Tipo:"));
        comboTipo = new JComboBox<>(new String[] {"Auto", "Moto", "Camion"});
        pnlForm.add(comboTipo);

        pnlForm.add(new JLabel("Dato extra:"));
        textExtra = new JTextField(12); pnlForm.add(textExtra);

        JButton btnAgregar = new JButton("Agregar");
        JButton btnMostrar = new JButton("Mostrar todos");
        JButton btnLimpiar = new JButton("Limpiar formulario");
        pnlForm.add(btnAgregar);
        pnlForm.add(btnMostrar);
        pnlForm.add(btnLimpiar);

        add(pnlForm, BorderLayout.NORTH);

     
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        add(new JScrollPane(areaSalida), BorderLayout.CENTER);

        listaAutos = new ArrayList<>();
        listaMotos = new ArrayList<>();
        listaCamiones = new ArrayList<>();

        btnAgregar.addActionListener(e -> agregarVehiculo());
        btnMostrar.addActionListener(e -> mostrarVehiculos());
        btnLimpiar.addActionListener(e -> limpiarFormulario());

  
        comboTipo.addActionListener(e -> actualizarTooltip());

        actualizarTooltip();
    }

    private void actualizarTooltip() {
        String tipo = (String) comboTipo.getSelectedItem();
        if ("Auto".equals(tipo)) textExtra.setToolTipText("Ingrese cantidad de puertas (ej: 4)");
        else if ("Moto".equals(tipo)) textExtra.setToolTipText("Ingrese tipo (ej: deportiva)");
        else textExtra.setToolTipText("Ingrese capacidad (toneladas, ej: 2.5)");
    }

    private void agregarVehiculo() {
        String marca = textMarca.getText().trim();
        String modelo = textModelo.getText().trim();
        String anioStr = textAnio.getText().trim();
        String tipo = (String) comboTipo.getSelectedItem();
        String extra = textExtra.getText().trim();

        if (marca.isEmpty() || modelo.isEmpty() || anioStr.isEmpty() || extra.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Completa todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int anio;
        try {
            anio = Integer.parseInt(anioStr);
            if (anio < 1886 || anio > 3000) {
                JOptionPane.showMessageDialog(this, "Año inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Año debe ser un número entero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            switch (tipo) {
                case "Auto":
                    int puertas = Integer.parseInt(extra);
                    listaAutos.add(new Auto(marca, modelo, anio, puertas));
                    break;
                case "Moto":
                    listaMotos.add(new Moto(marca, modelo, anio, extra));
                    break;
                case "Camion":
                    double carga = Double.parseDouble(extra);
                    listaCamiones.add(new Camion(marca, modelo, anio, carga));
                    break;
            }
            JOptionPane.showMessageDialog(this, tipo + " agregado correctamente.");
            limpiarFormulario();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Formato del dato extra inválido para: " + tipo, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarVehiculos() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== AUTOS ===\n");
        if (listaAutos.isEmpty()) sb.append("No hay autos registrados.\n");
        for (Auto a : listaAutos) sb.append(a.mostrarInfo()).append("\n");

        sb.append("\n=== MOTOS ===\n");
        if (listaMotos.isEmpty()) sb.append("No hay motos registradas.\n");
        for (Moto m : listaMotos) sb.append(m.mostrarInfo()).append("\n");

        sb.append("\n=== CAMIONES ===\n");
        if (listaCamiones.isEmpty()) sb.append("No hay camiones registrados.\n");
        for (Camion c : listaCamiones) sb.append(c.mostrarInfo()).append("\n");

        areaSalida.setText(sb.toString());
    }

    private void limpiarFormulario() {
        textMarca.setText("");
        textModelo.setText("");
        textAnio.setText("");
        textExtra.setText("");
        comboTipo.setSelectedIndex(0);
        textMarca.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FrmVehiculos().setVisible(true);
        });
    }
}


