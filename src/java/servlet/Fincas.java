/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.FincaN;
import entidades.Finca;

/**
 *
 * @author Aux Software
 */
public class Fincas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String modulo = "Fincas.jsp";
        String pagina = "./Fincas.jsp";
        request.setAttribute("targetModulo", modulo);
        String m = "";
        String d = "";
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("actualizar", "");

        String idfinca = request.getParameter("txtid");
        String nombre = request.getParameter("txtnombre");
        String direccion = request.getParameter("txtdireccion");
        String nombreprop = request.getParameter("txtnombreprop");
        String hectareas = request.getParameter("txthectareas");
        String iddepartamento = request.getParameter("cbdepartamento");
        String departamento = request.getParameter("cbdepartamento");
        String idmunicipio = request.getParameter("cbmunicipio");
        String municipio = request.getParameter("cbmunicipio");
        String idterreno = request.getParameter("cbterreno");
        String terreno = request.getParameter("cbterreno");

        String boton = request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datousuario", null);

        FincaN un = new FincaN();
        Finca enti = new Finca();
        
        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                enti.setNombre((""));
                enti.setDireccion((""));
                enti.setHectareas((""));
                enti.setPropietario((""));

                request.setAttribute("Listado", null);
                request.setAttribute("datousuario", enti);

            } catch (Exception e) {
                m = "" + e.getMessage();
            }
            try {
                request.setAttribute("ListadoFinca", null);
            } catch (Exception e) {
                m = "" + e.getMessage();
            }

        }
        
        if ("guardar".equals(request.getParameter("action"))) {
            try {

                Finca fin = new Finca(idfinca, nombre, direccion,idmunicipio, municipio,nombreprop, hectareas,
                            iddepartamento, departamento, terreno);
                un.getInsertarFinca(fin);
            } catch (Exception e) {
                m = "" + e.getMessage();
            }

        }
        
        if ("mostrar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", un.ListadoFincas());
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }
        if ("eliminar".equals(request.getParameter("action"))) {
            try {
                Finca fn = new Finca();
                fn.setIdfinca(idfinca);
                un.getEliminarFinca(fn);
                request.setAttribute("listado", un.ListadoFincas());

               request.setAttribute("actualizar", "readonly");
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                Finca fn = new Finca();
                fn.setIdfinca(idfinca);

                request.setAttribute("datousuario", un.getFinca(idfinca));

               request.setAttribute("actualizar", "readonly");
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }
        
        if ("actualizar".equals(request.getParameter("action"))) {
            try {
                Finca finca = new Finca();
                finca.setIdfinca(idfinca);
                finca.setNombre(nombre);
                finca.setDireccion(direccion);
                finca.setHectareas(hectareas);
                finca.setIdmunicipio(idmunicipio);
                finca.setTipoterreno(idterreno);
                finca.setIddepartamento(iddepartamento);
                finca.setPropietario(nombreprop);
                
                un.getActualizarFinca(finca);
                request.setAttribute("listado", un.ListadoFincas());
                request.setAttribute("actualizar", "readonly");
            } catch (Exception e) {
                m = "" + e.getMessage();
                e.printStackTrace();
            }
        }
        
        request.setAttribute("mensajes", m);
        request.setAttribute("datos", d);
        request.getRequestDispatcher(pagina).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
