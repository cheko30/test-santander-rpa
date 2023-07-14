package com.santander.test.exercise.threads;

import com.santander.test.exercise.exceptions.HandleException;
import com.santander.test.exercise.validaciones.ValidarHilo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Sergio Peña
 * @description Clase para ejecutar hilos
 */
public class HiloContadorNombre extends Thread {

    private int contador;
    private int tipo;
    private String nombreHilo;

    /**
     * @author Sergio Peña
     * @description Constructor para inicializar los valores
     * @param contador
     * @param tipo
     * @param nombreHilo
     */
    public HiloContadorNombre(int contador, int tipo, String nombreHilo) {
        this.contador = contador;
        this.tipo = tipo;
        this.nombreHilo = nombreHilo;
    }

    @Override
    public void run() {
        try {
            ValidarHilo.validarTipo(tipo);
            ValidarHilo.validarContador(contador);
            ValidarHilo.validarNombreHilo(nombreHilo);
            imprimirResultado(tipo, contador, nombreHilo);
        } catch (HandleException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @author Sergio Peña
     * @description Imprime por consola el resultado
     * @param tipo
     * @param contador
     * @param nombreHilo
     */
    private void imprimirResultado(int tipo, int contador, String nombreHilo) {
        String nombreCompleto = "";
        for (int i = 1; i <= contador; i++) {
            String numero = tipo == 2 ? getNumerosLetras().get(i).toString() : String.valueOf(i);
            String nombreJoin = String.join("-",numero, nombreHilo);
            nombreCompleto = nombreCompleto.isEmpty() ? nombreCompleto.concat(nombreJoin)
                        : nombreCompleto.concat(",").concat(nombreJoin);
            }
            System.out.println("Resultado: " + nombreCompleto);
    }

    /**
     * @author Sergio Peña
     * @description Map con los valores de los numeros en letra
     * @return
     */
    private Map getNumerosLetras() {
        Map<Integer, String> numerosLetrasMap = new LinkedHashMap();
        numerosLetrasMap.put(1, "uno");
        numerosLetrasMap.put(2, "dos");
        numerosLetrasMap.put(3, "tres");
        numerosLetrasMap.put(4, "cuatro");
        numerosLetrasMap.put(5, "cinco");
        numerosLetrasMap.put(6, "seis");
        numerosLetrasMap.put(7, "siete");
        numerosLetrasMap.put(8, "ocho");
        numerosLetrasMap.put(9, "nueve");
        numerosLetrasMap.put(10, "diez");
        return numerosLetrasMap;
    }
}
