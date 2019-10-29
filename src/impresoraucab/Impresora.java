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

    public enum Estatus
    {
        Libre,Pendiente,Ocupada
    }
    private List<Trabajo> colaDeImpresion = new ArrayList<>();
    private Estatus  estatus; 
    private boolean estado;

    public Estatus getEstado() {
        return estatus;
    }

    public void setEstado(Estatus estatus) {
        this.estatus = estatus;
    }
    private int id;
    

   
    public int getId() {
        return id;
    }
    
    //Constructor
    public Impresora(int id){
        this.estatus = Estatus.Libre;
        this.id = id;
    }
    
    public void añadirTrabajo(Trabajo trabajo){
        this.estatus = Estatus.Pendiente;
        this.colaDeImpresion.add(trabajo);
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
            if (trabajo.getEstatus() == Trabajo.Estatus.IMPRIMIENDO) {
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
        if (!this.colaDeImpresion.isEmpty()){
             for (Trabajo trabajo : colaDeImpresion) {
            if (trabajo.getEstatus() == Trabajo.Estatus.IMPRIMIR) {
                trabajoEncontrado = trabajo;
                break;
            }
        }
        return trabajoEncontrado;
        }
        else{
            return null;
        }
       
    }

    
    private void actualizarEstatus(){
        if (null == obtenerTrabajoParaImprimir()){
                this.estatus = Estatus.Libre;
        }
          else
          {
              this.estatus = Estatus.Pendiente;
          }
    }
    private boolean imprimir(Trabajo trabajo) throws InterruptedException {
        if (trabajo.getEstatus() == Trabajo.Estatus.IMPRIMIR) {
              trabajo.setEstatus(Trabajo.Estatus.IMPRIMIENDO);
              this.estatus = Estatus.Ocupada;
              System.out.println("Impresora-" + this.id + ": Imprimiento...");
              TimeUnit.SECONDS.sleep(5); // ESPERA QUE SIMULA IMPRESION
                int maxValor = 5;
                int minValor = 1;
                int estatusFinal = (int) Math.floor(Math.random() * (-maxValor + minValor) + minValor); //SIMULAR ESTATUS DE IMPRESION
                if (estatusFinal == 1) {
                    trabajo.setEstatus(Trabajo.Estatus.IMPRESO);
                    System.out.println("Impresora-" + this.id + ": Error de impresion");
                    actualizarEstatus();
                    return false; // NO SE IMPRIMIO
                } else {
                    System.out.println("Impresora-" + this.id + ":\n Documento:" + trabajo.getContenido());
                    actualizarEstatus();
                    return true; // SE IMPRIMIO CORRECTAMENTE
                }   
             
        }
        else return false;    
    }
    
    public boolean estaPendiente(){
        if(this.estatus == Estatus.Pendiente) 
            return true;
        else
            return false;
    }
    public boolean continuarImpresion() throws InterruptedException{
        Trabajo siguiente = obtenerTrabajoParaImprimir();
        if(siguiente != null){
            if(imprimir(siguiente)){
                return true;
            }
            else return false;
        }
        else return false;
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
