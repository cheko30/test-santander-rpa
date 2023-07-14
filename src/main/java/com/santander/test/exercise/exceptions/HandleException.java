package com.santander.test.exercise.exceptions;

/**
 * @author Sergio Peña
 * @description Clase personalizada para el manejo de errores
 */
public class HandleException extends Exception{

    /**
     * @author Sergio Peña
     * @description Construcor que recibe el mensaje pernsonalizado
     * @param mensaje
     */
    public HandleException(String mensaje) {
        super(mensaje);
    }

}
