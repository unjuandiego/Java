/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author workj
 */
public class productosDAO {

    Connection conexion;

    public productosDAO() {
        conexion con = new conexion();
        conexion = con.getConexion();
    }

    public List<productos> listarProductos() {
        PreparedStatement ps;
        ResultSet rs;
        List<productos> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("SELECT id,codigo,nombre,precio,existencia FROM productos");
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");

                productos p = new productos(id, codigo, nombre, precio, existencia);
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public productos mostrarProductos(int _id) {
        PreparedStatement ps;
        ResultSet rs;
        productos pr = null;
        try {
            ps = conexion.prepareStatement("SELECT * FROM productos WHERE id=?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String codigo = rs.getString("codigo");
                String nombre = rs.getString("nombre");
                Double precio = rs.getDouble("precio");
                int existencia = rs.getInt("existencia");

                pr = new productos(id, codigo, nombre, precio, existencia);

            }
            return pr;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean insertar(productos producto) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("INSERT INTO productos (codigo, nombre,precio,existencia) VALUES (?,?,?,?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean actualizar(productos producto) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("UPDATE productos SET codigo=?, nombre=?, precio=?, existencia=? WHERE id=?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getExistencia());
            ps.setInt(5, producto.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean eliminar (int _id) {
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("DELETE from productos WHERE id=?");
            ps.setInt(1, _id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
