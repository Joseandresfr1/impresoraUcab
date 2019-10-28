/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impresoraucab;

/**
 *
 * @author josea
 */
public class Trabajo {

    public enum Estatus
    {
        IMPRIMIR, IMPRIMIENDO, IMPRESO, CANCELADO
    }
 
    private Estatus estatus;
    private String contenido;

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    
    public void Trabajo(Estatus estatus){
        this.estatus = estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }

    public Estatus getEstatus() {
        return estatus;
    }
}
