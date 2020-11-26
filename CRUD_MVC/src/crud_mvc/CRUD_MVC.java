/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_mvc;

import controlador.CRProducto;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.FrameProducto;

/**
 *
 * @author workj
 */
public class CRUD_MVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Producto mod = new Producto();
       ConsultasProducto modC= new ConsultasProducto();
       FrameProducto frm = new FrameProducto();
       CRProducto ctrl = new CRProducto(mod,modC,frm);
       ctrl.iniciar();
       frm.setVisible(true);
    }
    
}
