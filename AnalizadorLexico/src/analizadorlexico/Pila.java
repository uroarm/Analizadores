/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico;

/**
 *
 * @author patron
 */
public class Pila {
    private Nodo ultimoToken;
    
    public Pila(){
        ultimoToken = null;
    }
    
    public void push(String token){
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.token = token;
        
        if(ultimoToken == null){
            nuevoNodo.siguiente = null;
            ultimoToken = nuevoNodo;
        }else{
            nuevoNodo.siguiente = ultimoToken;
            ultimoToken = nuevoNodo;
        }
    }
    
    public String pop(){
        if(ultimoToken != null){
            String token = ultimoToken.token;
            ultimoToken = ultimoToken.siguiente;
            return token;
        }else{
            return null;
        }
    }
    
    public String top(){
        return ultimoToken.token;
    }
    
    public boolean isEmpty(){
        return ultimoToken == null;
    }
}
