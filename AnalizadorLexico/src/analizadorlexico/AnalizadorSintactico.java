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
            if(tokens.get(i)== "PROGRAMA" || tokens.get(i)== "SI" || tokens.get(i)== "ENTONCES" 
               || tokens.get(i)== "REPITE" || tokens.get(i)== "VECES"){
                pila.push(tokens.get(i));
            }else{
                if(tokens.get(i) == "FINPROG"){
                    if(pila.top()== "PROGRAMA"){
                        pila.pop();
                    }else{
                        return false;
                    }
                }
                
                if(tokens.get(i) == "FINREP"){
                    if(pila.top()== "VECES"){
                        pila.pop();
                        if(pila.top() == "REPITE"){
                            pila.pop();
                        }else{
                            return false;
                        }
                    }else{
                        return false;
                    }
                }
                
                if(tokens.get(i) == "FINSI"){
                    if(pila.top()== "SINO"){
                        pila.pop();
                        if(pila.top() == "ENTONCES"){
                            pila.pop();
                            if(pila.top() == "SI"){
                                pila.pop();
                            }else{
                                return false;
                            }
                        }else{
                            return false;
                        }
                        
                    }else{
                        if(pila.top() == "ENTONCES"){
                            pila.pop();
                            if(pila.top() == "SI"){
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
        return true;
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
