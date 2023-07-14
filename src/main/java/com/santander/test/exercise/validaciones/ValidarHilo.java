package com.santander.test.exercise.validaciones;

import com.santander.test.exercise.exceptions.HandleException;

import static com.santander.test.exercise.constants.Constantes.*;

/**
 * @author Sergio Peña
 * @description Clase que realiza validaciones
 */
public class ValidarHilo {

    /**
     * @author Sergio Peña
     * @description Valida el que el campo tipo sea 1 o 2
     * @param tipo
     * @throws HandleException
     */
    public static void validarTipo(int tipo) throws HandleException {
        if(tipo == 0 || tipo > 2) {
            throw new HandleException(MSJ_ERROR_TIPO);
        }
    }

    /**
     * @author Sergio Peña
     * @description Valida el que el campo contador no sea mayor a 10
     * @param contador
     * @throws HandleException
     */
    public static void validarContador(int contador) throws HandleException {
        if(contador > 10) {
            throw new HandleException(MSJ_ERROR_CONTADOR);
        }
    }

    /**
     * @author Sergio Peña
     * @description Valida el que el campo nombre hilo no sea null o vacio,
     * que solo sean letras y que la longuitud de la cadena no sea mayor a 13 caracteres
     * @param nombreHilo
     * @throws HandleException
     */
    public static void validarNombreHilo(String nombreHilo) throws HandleException {
        if(nombreHilo == null || nombreHilo.isEmpty()) {
            throw new HandleException(MSJ_ERROR_NOMBRE_HILO_NULL);
        }

        if(nombreHilo.length() > 13 || !nombreHilo.matches(REGEX_NOMBRE_HILO)) {
            throw new HandleException(MSJ_ERROR_NOMBRE_HILO_NO_MATCH);
        }
    }
}
