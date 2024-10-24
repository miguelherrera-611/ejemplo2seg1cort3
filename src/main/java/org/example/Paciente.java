package org.example;

import java.util.Random;

public class Paciente {
    private int tiempoAtencion;

    public Paciente() {
        Random random = new Random();
        this.tiempoAtencion = random.nextInt(5) + 1; // Tiempo entre 1 y 5 segundos
    }

    public int getTiempoAtencion() {
        return tiempoAtencion;
    }
}
