/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresoraucab;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author josea
 */
public class Impresora {

    private List<Trabajo> colaDeImpresion = new ArrayList<>();
    private boolean  estado; 
    private int id;
    

    public int getId() {
        return id;
    }
    
    //Constructor
    public void Impresora(){
        this.id = System.identityHashCode(this);
    }
    
    public int obtenerTrabajosEnCola(){
    //obtiene la cantidad de trabajos (número entero positivo) encolados que deben ser impresos
        int cont = 0;
        for (Trabajo trabajo : colaDeImpresion) {
            if (trabajo.getEstatus() == Trabajo.Estatus.IMPRIMIR) {

                cont++;
            }
        }
        return cont;
    }


    private void pausarImpresion() {
        //obtiene un estado (booleano) de encendido o apagado
    }

    private void estaImprimiendo(Trabajo trabajo) {
        //permite conocer si se esta imprimiendo un trabajo, que anteriormente haya estado encolado.
        if (this.colaDeImpresion.contains(trabajo)) {
            if (trabajo.getEstatus() == Estatus.IMPRIMIENDO) {
                this.estado = true;
            } else {
                this.estado = false;
            }
        } else {
            this.estado = false;
        }
    }

    private Trabajo obtenerTrabajoParaImprimir() {
        //obtiene el trabajo proximo a ser impreso.
        Trabajo trabajoEncontrado = null;
        for (Trabajo trabajo : colaDeImpresion) {
            if (trabajo.getEstatus() == Estatus.IMPRIMIR) {
                trabajoEncontrado = trabajo;
                break;
            }
        }
        return trabajoEncontrado;
    }

    private boolean imprimir(Trabajo trabajo) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5); // ESPERA QUE SIMULA IMPRESION
        int maxValor = 5;
        int minValor = 1;
        int estatusFinal = (int) Math.floor(Math.random() * (-maxValor + minValor) + minValor); //SIMULAR ESTATUS DE IMPRESION
        if (estatusFinal == 1) {
            return false; // NO SE IMPRIMIO
        } else {
            return true; // SE IMPRIMIO CORRECTAMENTE
        }
    }


    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public List<Trabajo> getTrabajos() {
        return colaDeImpresion;
    }

}
