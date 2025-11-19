public class Main {
    public static void main(String[] args) {
        ControladorCentral cc = new ControladorCentral();

        SmartLight luz1 = new SmartLight("L1", "Lampara Sala", true, 75);
        SmartThermostat term1 = new SmartThermostat("T1", "Termostato Cocina", false, 22.5, 24.0);
        SmartCamera cam1 = new SmartCamera("C1", "Camara Patio", false, "1080p");

        cc.agregarDispositivo(luz1);
        cc.agregarDispositivo(term1);
        cc.agregarDispositivo(cam1);

        cc.listarDispositivos();
        cc.encenderTodo();
        cc.listarDispositivos();

        cam1.iniciarGrabacion();
        term1.setTemperaturaObjetivo(21.0);

        cc.apagarTodo();
        cc.listarDispositivos();
    }
}
