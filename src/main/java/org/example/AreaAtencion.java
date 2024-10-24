package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class AreaAtencion {
    private Queue<Paciente> colaPacientes = new LinkedList<>();

    public synchronized void agregarPaciente() {
        Paciente paciente = new Paciente();
        colaPacientes.add(paciente);
        notify();
    }

    public synchronized Paciente obtenerPaciente() {
        while (colaPacientes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return colaPacientes.poll();
    }
}

