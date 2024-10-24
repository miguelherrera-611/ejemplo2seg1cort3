package org.example;

public class Medico extends Thread {
    private String nombre;
    private AreaAtencion areaAtencion;
    private int pacientesAtendidos = 0;

    public Medico(String nombre, AreaAtencion areaAtencion) {
        this.nombre = nombre;
        this.areaAtencion = areaAtencion;
    }

    public void run() {
        while (true) {
            Paciente paciente = areaAtencion.obtenerPaciente();
            if (paciente != null) {
                int tiempoAtencion = paciente.getTiempoAtencion();
                System.out.println(nombre + " está atendiendo a un paciente por " + tiempoAtencion + " segundos.");
                try {
                    Thread.sleep(tiempoAtencion * 1000); // Simula el tiempo de atención
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                pacientesAtendidos++;
                System.out.println(nombre + " ha terminado de atender a un paciente.");
            }
        }
    }

    public int getPacientesAtendidos() {
        return pacientesAtendidos;
    }
}

