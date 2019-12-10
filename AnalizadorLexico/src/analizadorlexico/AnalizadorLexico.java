/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Jose Manuel Patron
 */
public class AnalizadorLexico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ruta: ");
        String ruta = scanner.nextLine();
        
        leerArchivo l1 = new leerArchivo();
        
        ArrayList<String> array = new ArrayList<String>();  
        File archivo = new File(ruta);
        Scanner lectura = new Scanner(archivo);
	while (lectura.hasNextLine()) {
            String linea = lectura.nextLine();
            array.add(linea);
        }
        
        l1.setArray(array);
    }
}
