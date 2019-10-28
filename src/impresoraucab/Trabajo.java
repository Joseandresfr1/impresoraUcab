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
    private Estatus estatus;
    
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
