/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Mauro
 */
public class impresionArchivo {
    
    impresionArchivo(){}
    
    public static void imprimir(ArrayList<String> array, lexico lex) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileWriter imp = new FileWriter("output.txt");
        BufferedWriter escritura = new BufferedWriter(imp);
        for(int i=0;i<array.size();i++){
            imp.write(array.get(i));
            escritura.newLine();
            imp.write("\n");
            //System.out.println(array.get(i));
        }
        imp.close();
        
        FileWriter palabras = new FileWriter("palabras.txt");
        BufferedWriter palabraescritura = new BufferedWriter(palabras);
            palabras.write("IDS");
            palabraescritura .newLine();
            palabras.write("\n");
        for(int i=0;i<lex.IDS.size();i++){
            palabras.write(lex.IDS.get(i));
            palabraescritura .newLine();
            palabras.write("\n");
            
        }
        palabras.write("\n");
        palabras.write("VAL");
        palabraescritura .newLine();
        palabras.write("\n");
        for(int i=0;i<lex.VAL.size();i++){
            palabras.write(lex.VAL.get(i));
            palabraescritura .newLine();
            palabras.write("\n");
            
        }
        palabras.write("\n");
        palabras.write("VAL");
        palabraescritura .newLine();
        palabras.write("\n");
        for(int i=0;i<lex.TXT.size();i++){
            palabras.write(lex.TXT.get(i));
            palabraescritura .newLine();
            palabras.write("\n");
            
        }
        palabras.close();
        
    }  
}
