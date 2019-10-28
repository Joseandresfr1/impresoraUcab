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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                // TODO code application logic here
         List<Impresora> redImpresoras = new ArrayList<>();
         
         Scanner reader = new Scanner(System.in);
         System.out.println("Ingrese la cantidad de impresoras");
         int cantImpresoras = Integer.parseInt(reader.nextLine());  

         for (int impresora = 0; impresora < cantImpresoras; impresora++) {
            redImpresoras.add(new Impresora());
         }     
         System.out.println("Se añadieron " + redImpresoras.size() + " impresoras"); 
    }
    
}
