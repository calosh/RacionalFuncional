/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.dcce.sic.arqapp.racionalesarqapp;

import java.util.Scanner;


/**
 *
 * @author SALAS
 */
public class TestRacional {
    
    public static void main(String[] args) {
        Racional r1 = new Racional(3,5);
        Racional r2 = new Racional(2,7);
        /*
        r1.setNumerador(8);
        r1.setDenominador(4);
        
        r2.setNumerador(1);
        try {
            //r2.setDenominador(8);
        } catch (IllegalArgumentException e) {
            //System.out.println("No debes usar el cero como denominador");
        }   
        
        
        //System.out.printf("r1 = %d/%d\n",r1.getNumerador(), r1.getDenominador());
        //System.out.printf("r2 = %d/%d\n",r2.getNumerador(), r2.getDenominador());
        
        */
        
 
        Racional r = new Racional();
        r = r1.sumar(r2);
        Racional.resultado(r);
        
        Racional rr = new Racional();
        rr = Racional.sumar(r1, r2);
        Racional.resultado(rr);
        System.out.println(Racional.igualdad(new Racional(1,2), new Racional(2, 4)));
        
        System.out.println("Suma: "+Racional.sumar(new Racional(1,2), new Racional(2, 4)));
        
        /*
        try {
            Racional r1 = new Racional();
            Racional r2 = new Racional();
            Racional r = new Racional();
            
            int opcion = 0;
            do {  
                opcion = menu();
                if (opcion==1) {
                    System.out.println("Ingre");
                }

                
            } while (opcion==6);
            
            
            
        } catch (Exception e) {
        
        }
        */
                
    }
    
    
}
