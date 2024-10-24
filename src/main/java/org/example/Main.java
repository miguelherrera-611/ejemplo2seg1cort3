package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AreaAtencion areaAtencion = new AreaAtencion();
        Medico[] medicos = new Medico[3]; // 3 médicos

        for (int i = 0; i < medicos.length; i++) {
            medicos[i] = new Medico("Médico " + (i + 1), areaAtencion);
            medicos[i].start();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de atención médica.");

        while (true) {
            System.out.println("1. Agregar paciente");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                areaAtencion.agregarPaciente();
                System.out.println("Paciente agregado a la cola.");
            } else if (opcion == 2) {
                break;
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        System.out.println("Cerrando el sistema de atención médica...");
        for (Medico medico : medicos) {
            medico.interrupt();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (Medico medico : medicos) {
            System.out.println(medico.getName() + " atendió a " + medico.getPacientesAtendidos() + " pacientes.");
        }

        scanner.close();
        System.out.println("Sistema cerrado.");
    }
}
