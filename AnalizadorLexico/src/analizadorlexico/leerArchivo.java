/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mauro
 */
public class leerArchivo {
    private ArrayList<String> lecturaArray;

    public static void leerArchivo(String ruta) throws FileNotFoundException{
        ArrayList<String> array = new ArrayList<String>();  
        File archivo = new File(ruta);
        Scanner lectura = new Scanner(archivo);

	while (lectura.hasNextLine()) {
            String linea = lectura.nextLine();
            //System.out.println(linea);
            array.add(linea);
        }
        
        //for(int x=0;x<array.size();x++) {
        //  System.out.println(array.get(x));
        //}
    }
    
    leerArchivo(){}
    
    public void setArray(ArrayList<String> lecturaArray){
        this.lecturaArray = lecturaArray;
    }

    public ArrayList<String> getArray(){
        return lecturaArray;
    }
    
}
