package com.santander.test.exercise.validaciones;

import static com.santander.test.exercise.constants.Constantes.*;

/**
 * @author Sergio Peña
 * @description Valida la generacion
 */
public class ValidarGeneracion {

    /**
     * @author Sergio Peña
     * @description Obtiene la generacion de acuerdo a la fecha de nacimiento
     * @param year
     * @return
     */
    public static String obtenerGeneracion(int year) {
        if(year >= 1994 && year <= 2010) {
            return GENERACION_Z;
        }

        if(year >= 1981 && year <= 1993) {
            return GENERACION_Y;
        }

        if(year >= 1969 && year <= 1980) {
            return GENERACION_X;
        }

        if(year >= 1949 && year <= 1968) {
            return GENERACION_BABY_BOOM;
        }

        if(year >= 1930 && year <= 1948) {
            return GENERACION_SILENT;
        }

        if(year < 1930 || Integer.toString(year).length() == 2 || year > 2010) {
            return "N/A";
        }
        return "";
    }
}
