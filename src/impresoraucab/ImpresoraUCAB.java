/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresoraucab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author josea
 */
public class ImpresoraUCAB {
    private enum Estatus
      {
          Dentro, Salir
      }
    private static Estatus estatusActual;
    private static List<Impresora> redImpresoras = new ArrayList<>();
    private static Scanner reader = new Scanner(System.in);
    
    private static void setEstatusActual(Estatus estatus){
        estatusActual = estatus;
    }
    
    private static Estatus getEstatusActual(){
        return estatusActual;
    }
    
    private static void añadirLinea(){
        System.out.println("\n------------------------------------------\n");
    }
    
    public static void main(String[] args) {
        
         estatusActual = Estatus.Dentro;
         System.out.println("Ingrese la cantidad de impresoras");
         int cantImpresoras = Integer.parseInt(reader.nextLine());  

         for (int impresora = 0; impresora < cantImpresoras; impresora++) {
            redImpresoras.add(new Impresora());
         }     
         System.out.println("Se añadieron " + redImpresoras.size() + " impresoras"); 
         
         while (getEstatusActual() == Estatus.Dentro) {
            añadirLinea();
            MenuPrincipal.mostrarMenu();
            switch (MenuPrincipal.pedirDato()) {
                case imprimir:
                    break;
                case añadirDocumento:
                    break;
                case añadirImpresora:
                    break;
                case salir:
                    setEstatusActual(Estatus.Salir);
                    break;
                default:
                    break;
            }
        }  
    }
}
