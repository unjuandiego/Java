/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.productos;
import modelo.productosDAO;

/**
 *
 * @author workj
 */
@WebServlet(name = "ProductosController", urlPatterns = {"/ProductosController"})
public class ProductosController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        productosDAO productoDAO = new productosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        accion = request.getParameter("accion");
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<productos> listaproductos = productoDAO.listarProductos();
            request.setAttribute("lista", listaproductos);
            
        }else if("nuevo".equals(accion)){
            dispatcher = request.getRequestDispatcher("Productos/nuevo.jsp");
        }
        else if("insertar".equals(accion)){
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            productos producto = new productos(0, codigo, nombre, precio, existencia);
            productoDAO.insertar(producto);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<productos> listaProductos = productoDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
        }
        else if("modificar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Productos/modificar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            productos producto = productoDAO.mostrarProductos(id);
            request.setAttribute("producto", producto);
        }
        else if("actualizar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            Double precio = Double.parseDouble(request.getParameter("precio"));
            int existencia = Integer.parseInt(request.getParameter("existencia"));
            productos producto = new productos(id, codigo, nombre, precio, existencia);
            productoDAO.actualizar(producto);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<productos> listaProductos = productoDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
        }
        else if("eliminar".equals(accion)){
            int id = Integer.parseInt(request.getParameter("id"));
            productoDAO.eliminar(id);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<productos> listaProductos = productoDAO.listarProductos();
            request.setAttribute("lista", listaProductos);
            //JOptionPane.showMessageDialog(null, "Registro Guardado");
        }        
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
