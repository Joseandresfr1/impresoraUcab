/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresoraucab;

import java.util.Scanner;

/**
 *
 * @author josea
 */public class MenuPrincipal {
    public enum Estatus
    {
        añadirImpresora, añadirDocumento, imprimir, salir ,opcionErrada
    }
    public static void mostrarMenu() {
        System.out.println("1) Añadir impresora");
        System.out.println("2) Añadir Documento");
        System.out.println("3) Empezar a imprimir");
        System.out.println("0) Salir");
    }
    private static void opcionErrada() {
        System.out.println("Lo sentimos, opcion no disponible");
    }

    public static Estatus pedirDato() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Ingrese una opcion: ");
        int opcionSelecionada;
        try {
             opcionSelecionada = Integer.parseInt(reader.nextLine());
        } catch (Exception ex) {
            opcionErrada();
            return(Estatus.opcionErrada);
        }
        
        switch (opcionSelecionada) {
            case 1:
                return (Estatus.añadirImpresora);
            case 2:
                return (Estatus.añadirDocumento);
            case 3:
                return (Estatus.imprimir);
            case 0:
                return (Estatus.salir);
            default:
                opcionErrada();
                return(Estatus.opcionErrada);
        }  
    }
}
