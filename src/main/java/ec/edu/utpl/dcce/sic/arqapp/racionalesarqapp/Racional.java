/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.utpl.dcce.sic.arqapp.racionalesarqapp;

import java.util.stream.Stream;

/**
 *
 * @author SALAS
 */
public class Racional {
    private int numerador;
    private int denominador;
    
    public Racional(){
        
    }

    public Racional(int numerador, int denominador) {
        this.numerador = numerador;
        setDenominador(denominador);
        //this.denominador=this.denominador;
    }
    
    

    /**
     * @return the numerador
     */
    public int getNumerador() {
        return numerador;
    }

    /**
     * @param numerador the numerador to set
     */
    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    /**
     * @return the denominador
     */
    public int getDenominador() {
        return denominador;
    }

    /**
     * @param denominador the denominador to set
     */
    public final void setDenominador(int denominador) {
        if(denominador!=0){
            this.denominador = denominador;
        }else{
            throw new IllegalArgumentException("El denominador no puede ser cero");
        }
    }
    
    public Racional sumar(Racional otro){
        Racional r = new Racional();
        r.setNumerador((this.numerador*otro.getDenominador()+otro.getNumerador()*this.denominador));
        r.setDenominador((this.denominador*otro.getDenominador()));
        return simplificar(r);
    }
    
    public static Racional sumar(Racional r1, Racional r2){
        Racional r = new Racional();
        r.setNumerador((r1.getNumerador()*r2.getDenominador()+r2.getNumerador()*r1.getDenominador()));
        r.setDenominador((r1.getDenominador()*r2.getDenominador()));
        return simplificar(r);
    }
    
    public Racional restar(Racional otro){
        Racional r = new Racional();
        r.setNumerador((this.numerador*otro.getDenominador()-otro.getNumerador()*this.denominador));
        r.setDenominador((this.denominador*otro.getDenominador()));
        return r;
    }
    
    public static Racional restar(Racional r1, Racional r2){
        Racional r = new Racional();
        r.setNumerador((r1.getNumerador()*r2.getDenominador()-r2.getNumerador()*r1.getDenominador()));
        r.setDenominador((r1.getDenominador()*r2.getDenominador()));
        return r;
    }
    
    public static Racional multiplicar(Racional r1, Racional r2){
        Racional r = new Racional();
        r.setNumerador(r1.getNumerador()*r2.getNumerador());
        r.setDenominador(r1.getDenominador()*r2.getDenominador());
        return r;
    }
    
    public Racional multiplicar(Racional otro){
        Racional r = new Racional();
        r.setNumerador(this.numerador*otro.getNumerador());
        r.setDenominador(this.denominador*otro.getDenominador());
        return r;
    }
    
    
    public static Racional dividir(Racional r1, Racional r2){
        Racional r = new Racional();
        r.setNumerador(r1.getNumerador()*r2.getDenominador());
        r.setDenominador(r1.getDenominador()*r2.getNumerador());
        return r;
    }
    
    public Racional dividir(Racional otro){
        Racional r = new Racional();
        r.setNumerador(this.numerador*otro.getDenominador());
        r.setDenominador(this.denominador*otro.getNumerador());
        return r;
    }
    
    public static boolean igualdad(Racional r1, Racional r2){
        if (r1.getNumerador()*r2.getDenominador() == r1.getDenominador()*r2.getNumerador()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean igualdad(Racional r2){
        if (this.numerador*r2.getDenominador() == this.denominador*r2.getNumerador()){
            return true;
        }else{
            return false;
        }
    }
    
    public static int mcd(int num, int den){
        int u = Math.abs(num);
        int v = Math.abs(den);
        if (v == 0) {
            return u;
        }
        int r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }
    
    public static Racional simplificar(Racional r){
        int dividir = mcd(r.getNumerador(),r.getDenominador());
        int num = r.getNumerador();
        int den = r.getDenominador();
        num /= dividir;
        den /= dividir;
        return new Racional(num,den);
    }
    
    public static void resultado(Racional r){
        System.out.printf("Respuesta: %s/%s\n", r.getNumerador(), r.getDenominador());
    }

    @Override
    public String toString() {
        return numerador+"/"+denominador; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean esMenorQue(Racional otro) {
        return numerador * otro.getDenominador() < otro.getNumerador() * denominador;
}
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Racional otro = (Racional) obj;

        return numerador * otro.getDenominador() == denominador * otro.getNumerador();
    }

    public int compareTo(Racional otro) {
        if (this.equals(otro)) {
            return 0;
        }

        if (this.esMenorQue(otro)) {
            return -1;
        } else {
            return 1;
        }
    }
    
    
}
