/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasProducto;
import modelo.Producto;
import vista.FrameProducto;

/**
 *
 * @author workj
 */
public class CRProducto implements ActionListener {

    private Producto mod;
    private ConsultasProducto modC;
    private FrameProducto frm;

    public CRProducto(Producto mod, ConsultasProducto modC, FrameProducto frm) {
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnSave.addActionListener(this);
        this.frm.btnEdit.addActionListener(this);
        this.frm.btnDelete.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
    }

    public void iniciar() {
        frm.setTitle("Productos");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm.btnSave) {
            mod.setCodigo(frm.txtCod.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.registrar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar");
                limpiar();
            }
        }
        if (e.getSource() == frm.btnEdit) {
            mod.setId(Integer.parseInt(frm.txtID.getText()));
            mod.setCodigo(frm.txtCod.getText());
            mod.setNombre(frm.txtNombre.getText());
            mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
            if (modC.modifiar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }
        }
        if (e.getSource() == frm.btnDelete) {
            mod.setId(Integer.parseInt(frm.txtID.getText()));

            if (modC.eliminar(mod)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }
        }
        if (e.getSource() == frm.btnBuscar) {
            mod.setCodigo(frm.txtCod.getText());
            if (modC.buscar(mod)) {
                frm.txtID.setText(String.valueOf(mod.getId()));
                frm.txtCod.setText(mod.getCodigo());
                frm.txtNombre.setText(mod.getNombre());
                frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
            } else {
                JOptionPane.showMessageDialog(null, "No hay registro");
                limpiar();
            }

        }
        if (e.getSource() == frm.btnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        frm.txtID.setText(null);
        frm.txtCod.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
    }
}
