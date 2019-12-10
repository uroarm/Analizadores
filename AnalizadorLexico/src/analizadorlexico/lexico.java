/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Jose Manuel Patron
 */
public class lexico {
    
//    private Scanner x;
   // public String programa;
    private String[] palabrasReservadas  = {"PROGRAMA", "FINPROG","SI", "ENTONCES", "SINO", "FINSI","REPITE","VECES","FINREP","IMPRIME","LEE"} ;
    private String [] operadoresRelacionales = {"<",">","=="};
    private String [] operadoresAritmeticos = {"+","-","*","/"};

    public ArrayList<String> IDS = new ArrayList();
    public ArrayList<String> VAL = new ArrayList();
    public ArrayList<String> TXT = new ArrayList();
    public ArrayList<String> Tokens = new ArrayList();
    
    public ArrayList<String> crearTokens(ArrayList<String> archivo){
        
        for (int i=0; i<archivo.size();i++){
            if (archivo.get(i).charAt(0) != '#'){
                
            
          StringTokenizer Stokens = new StringTokenizer(archivo.get(i));
        String token;
        
        while (Stokens.hasMoreTokens()){
            token = Stokens.nextToken();
            if(token.equals("#") != true){            
            Tokens.add(token);
            }   
        }  
        }
        }
        clasificar(Tokens);
        return Tokens;
    }
    public void clasificar(ArrayList<String> tokens){
        //si son valores
         
         
        for (int i=0; i< tokens.size(); i++ ){
            if (esVal(tokens.get(i)) ){
               
                 VAL.add(tokens.get(i));
            }
            // si son textos
             if (tokens.get(i).charAt(0) == '“' ){
                  
                 TXT.add(tokens.get(i)); 
            }
             //si son identificadores
             if (esIde(tokens.get(i))){
                 IDS.add(tokens.get(i));
             }
        }
        
    }
    public boolean esIde(String token){
        
        for (int i=0; i<palabrasReservadas.length;i++){
            if (token.equals(palabrasReservadas[i])){ 
                
                return false;   
               
            }
        }
 
        if ((token.charAt(0)>=65 && token.charAt(0)<=90) || (token.charAt(0)>=97 && token.charAt(0)<=122) ){
                    return true;
        }
        else{
            return false;
        }
    }
    public boolean esVal(String token){
       char [] valor = token.toCharArray();
        if (valor[0] == '0'){
         if (valor[1] == 'x'){
            return true;
         }   
        }
       return false;
   }

   
   
       
    
} 

