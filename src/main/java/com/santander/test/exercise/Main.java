package com.santander.test.exercise;

import com.santander.test.exercise.excel.GenerarExcel;
import com.santander.test.exercise.threads.HiloContadorNombre;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingresar el ejercicio a ejecutar:\n 1.- Ejercicio de hilos \n 2.- Ejercicio de excel");
        System.out.println("Ingesar opcion: ");
        int ejercicio = lectura.nextInt();
        if(ejercicio == 1) {
            System.out.println("Ha seleccionado el ejercicio de Hilos");
            HiloContadorNombre thread1 = new HiloContadorNombre(10, 1, "HiloUno");
            thread1.start();

            HiloContadorNombre thread2 = new HiloContadorNombre(9, 3, "HiloDos");
            thread2.start();

            HiloContadorNombre thread3 = new HiloContadorNombre(8, 1, "HiloTres");
            thread3.start();
        } else if(ejercicio == 2) {
            System.out.println("Ha seleccionado el ejercicio de excel");
            GenerarExcel generarExcel = new GenerarExcel();
            generarExcel.generarExcel();
        } else {
            System.out.println("Opcion no valida!!");
        }
    }
}