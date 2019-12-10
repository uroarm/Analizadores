/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;


import java.util.ArrayList;

/**
 *
 * @author arman
 */
public class AnalizadorSintactico {
    
    Pila pila = new Pila();
    lexico lex= new lexico();
    
    public boolean Compilar(ArrayList<String> tokens){
        for(int i=0; i<tokens.size();i++){
            if(tokens.get(i).equals("PROGRAMA") || tokens.get(i).equals("SI") || tokens.get(i).equals("ENTONCES") 
               || tokens.get(i).equals("REPITE") || tokens.get(i).equals("VECES")){
                pila.push(tokens.get(i));
            }else{
                if(tokens.get(i).equals("FINPROG")){
                    if(pila.top().equals("PROGRAMA")){
                        pila.pop();
                    }else{
                        return false;
                    }
                }
                
                if(tokens.get(i).equals("FINREP")){
                    if(pila.top().equals("VECES")){
                        pila.pop();
                        if(pila.top().equals("REPITE")){
                            pila.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                
                if(tokens.get(i).equals("FINSI")){
                    if(pila.top().equals("SINO")){
                        pila.pop();
                        if(pila.top().equals("ENTONCES")){
                            pila.pop();
                            if(pila.top().equals("SI")){
                                pila.pop();
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                        
                    }else{
                        if(pila.top().equals("ENTONCES")){
                            pila.pop();
                            if(pila.top().equals("SI")){
                                pila.pop();
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        } 
                    }
                }
            }
        }
        if(pila.isEmpty())
            return true;
        else
           return false;
    }
    
    private boolean isVal(String token){
    
        for(int i=0;i<lex.VAL.size();i++){
            if(token == lex.VAL.get(i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isTXT(String token){
    
        for(int i=0;i<lex.TXT.size();i++){
            if(token == lex.TXT.get(i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isIDS(String token){
    
        for(int i=0;i<lex.IDS.size();i++){
            if(token == lex.IDS.get(i)){
                return true;
            }
        }
        return false;
    }
    
    private boolean isELEM(String token){
    
        if(this.isVal(token) || this.isTXT(token)|| this.isIDS(token)){
            return true;
        }
        else{
            return false;
        }
    }
    
    
}
