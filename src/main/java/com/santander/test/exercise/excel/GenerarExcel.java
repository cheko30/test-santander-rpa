package com.santander.test.exercise.excel;

import com.santander.test.exercise.exceptions.HandleException;
import com.santander.test.exercise.validaciones.ValidarGeneracion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * @author Sergio Peña
 * @description Clase encargada de crear un archivo en excel
 */
public class GenerarExcel {

    /**
     * @author Sergio Peña
     * @description Genera un archivo de excel y se guarda en la raiz del proyecto
     */
    public void generarExcel() {
        try {
            // Creacion del libro de excel y una hoja
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet("Personas");

            // Leectura de la data del archivo personas.csv
            InputStream inputStream = new FileInputStream("personas.csv");
            Scanner scanner = new Scanner(inputStream);
            int indexFila = 0;
            while (scanner.hasNextLine()) {
                String datos = scanner.nextLine();
                // Creacion de un arreglo de strings
                String[] datosArray = datos.split(",");
                List<String> datosList = new ArrayList<>(Arrays.asList(datosArray));
                datosList.add("GENERACION");
                Row row = sheet.createRow(indexFila);
                for (int i = 0; i < datosList.size(); i++) {
                    if(indexFila == 0) {
                        // Creacion de celda personalizada
                        crearEstiloCelda(wb, row, datosList, i);
                    } else {
                        row.createCell(i).setCellValue(datosList.get(i));
                    }
                }

                String fecha = datosList.get(10);
                // Calcula la generacion
                calcularGeneracion(fecha, row);

                indexFila++;
            }
            // Crea el archivo
            generarArchivo("personas.xlsx", wb);

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    /**
     * @author Sergio Peña
     * @description Crea una celda personalizada
     * @param wb
     * @param row
     * @param datos
     * @param indice
     */
    private void crearEstiloCelda(Workbook wb, Row row, List<String> datos, int indice)  {
        CellStyle style = wb.createCellStyle();

        Font font = wb.createFont();
        font.setBold(true);
        font.setColor(IndexedColors.WHITE.getIndex());

        style.setFont(font);
        style.setFillBackgroundColor(IndexedColors.BLUE1.getIndex());
        style.setFillPattern(FillPatternType.ALT_BARS);

        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());

        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        Cell cell = row.createCell(indice);
        cell.setCellValue(datos.get(indice));
        cell.setCellStyle(style);
    }

    /**
     * @author Sergio Peña
     * @description Calcula la generacion
     * @param fecha
     * @param row
     */
    private void calcularGeneracion(String fecha, Row row) {
        if(!fecha.equals("FECHA_NACIMIENTO")) {
            String fechaArray[] = fecha.split("/");
            int year = Integer.valueOf(fechaArray[2]);
            row.createCell(11).setCellValue(ValidarGeneracion.obtenerGeneracion(year));
        }
    }

    /***
     * @author Sergio Peña
     * @description Crea el archivo de excel
     * @param nombreArchivo
     */
    private void generarArchivo(String nombreArchivo, Workbook wb) throws IOException {
        OutputStream outputStream = new FileOutputStream(nombreArchivo);
        wb.write(outputStream);
        outputStream.close();
        System.out.println("Archivo generado exitosamente");
    }
}
