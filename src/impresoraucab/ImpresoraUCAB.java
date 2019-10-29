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
    
    public static void main(String[] args) throws InterruptedException {
        
         estatusActual = Estatus.Dentro;
         System.out.println("Ingrese la cantidad de impresoras");
         int cantImpresoras = Integer.parseInt(reader.nextLine());  

         for (int impresora = 0; impresora < cantImpresoras; impresora++) {
            redImpresoras.add(new Impresora(impresora));
         }     
         System.out.println("Se añadieron " + redImpresoras.size() + " impresoras"); 
         
         while (getEstatusActual() == Estatus.Dentro) {
            añadirLinea();
            MenuPrincipal.mostrarMenu();
            switch (MenuPrincipal.pedirDato()) {
                case imprimir:
                        int cont;
                        do{
                            cont = 0;
                            for (Impresora impresora : redImpresoras) {
                               impresora.continuarImpresion();
                               if ( impresora.estaPendiente() == true){                            
                                   cont++;
                               }
                           }    
                        }while(cont > 0);
   
                    break;
                case añadirDocumento:
                    añadirDocumento();               
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
    
    private static void añadirDocumento() {
        System.out.println("Seleccione una impresora");
        for (Impresora Impresora : redImpresoras) {       
            System.out.println(Impresora.getId());
        }
        int impresoraId = Integer.parseInt(reader.nextLine());  
        Impresora impresoraSeleccionada = redImpresoras.get(impresoraId);
         System.out.println("Ingrese el texto del documento");
         String texto =reader.nextLine();  
         Trabajo nuevoTrabajo = new Trabajo(texto);
         impresoraSeleccionada.añadirTrabajo(nuevoTrabajo);
        System.out.println("Añadido documento Satisfactoriamente!");
         
    }
}
