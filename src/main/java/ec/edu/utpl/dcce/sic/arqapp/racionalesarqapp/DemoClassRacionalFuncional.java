/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.dcce.sic.arqapp.racionalesarqapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author SALAS
 */



public class DemoClassRacionalFuncional {
    public static void main(String[] args) {
        List<Racional> fracciones = new ArrayList<>();
        fracciones.add(new Racional(1,4));
        fracciones.add(new Racional(2,3));
        fracciones.add(new Racional(3,4));
        fracciones.add(new Racional(1,3));
        
        fracciones.stream().forEach(r -> System.out.println(r));
        
        System.out.println("Menor que 1/2");
        fracciones.stream().filter(f -> f.esMenorQue(new Racional(1,2))).
                forEach(System.out::println);
        
        System.out.println("Suma de numeradores");
        int sumaNum = fracciones.stream().mapToInt(Racional::getNumerador).sum();
        System.out.println("Suma de numeradores = "+sumaNum);
        
        System.out.println("Promedio numeradores");
        double promNum = fracciones.stream().mapToInt(Racional::getNumerador).average().getAsDouble();
        System.out.println("Promedio Numeradores = "+promNum);
        
        System.out.println("Crear lista solo Numeradores");
        List<Integer> numeradores = fracciones.
                stream().mapToInt(Racional::getNumerador).
                boxed().collect(Collectors.toList());
        
        System.out.println(numeradores);
        
        System.out.println("Promedio numeradores");
        double promNume = fracciones.
                stream().
                mapToInt(Racional::getNumerador).
                average().
                getAsDouble();
        System.out.println(promNume);
        
        System.out.println("Mayor y menor");
        int mayor;
        int menor;
        
        mayor = fracciones.
                stream().
                mapToInt(Racional::getNumerador).
                max().
                getAsInt();
        menor = fracciones.
                stream().
                mapToInt(Racional::getNumerador).
                min().
                getAsInt();
        System.out.printf("Mayor = %d, menor = %d\n",
                mayor,
                menor);
       

        System.out.println("Suma");
        Racional suma = fracciones.
                stream().
                reduce(new Racional(0, 1),
                        (a, b) -> a.sumar(b));
        System.out.println(suma);
        
        System.out.println("Ordenados");
        fracciones.
                stream().
                sorted((r1, r2)->r1.compareTo(r2)).
                forEach(System.out::println);
    }

}
