/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entidades.Vacuno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import negocio.VacunoN;

/**
 *
 * @author Aux Software
 */
public class Vacunos extends HttpServlet {

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
        String modulo = "vacunos.jsp";
        String pagina = "./vacunos.jsp";
        request.setAttribute("targetModulo", modulo);
        String m = "";
        String d = "";
        request.setAttribute("mensajes", null);
        request.setAttribute("datos", null);
        request.setAttribute("actualizar", "");

        String idvacuno = request.getParameter("txtid");
        String raza = request.getParameter("txtraza");
        String idfinca = request.getParameter("cbfinca");
        String finca = request.getParameter("cbfinca");
        String numpartos = request.getParameter("txtpartos");
        String peso = request.getParameter("txtpeso");

        String boton = request.getParameter("action");
        request.setAttribute("listado", null);
        request.setAttribute("datousuario", null);

        VacunoN un = new VacunoN();
        Vacuno enti = new Vacuno();
        
        if ("nuevo".equals(request.getParameter("action"))) {
            try {
                enti.setFinca((""));
                enti.setNumeroPartos((""));
                enti.setPeso((""));

                request.setAttribute("Listado", null);
                request.setAttribute("datousuario", enti);

            } catch (Exception e) {
                m = "" + e.getMessage();
            }
            try {
                request.setAttribute("ListadoVacuno", null);
            } catch (Exception e) {
                m = "" + e.getMessage();
            }

        }
        
        if ("mostrar".equals(request.getParameter("action"))) {
            try {
                request.setAttribute("listado", un.ListadoVacunos());
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }
        
        if ("buscar".equals(request.getParameter("action"))) {
            try {
                Vacuno vn = new Vacuno();
                vn.setIdvacuno(idvacuno);

                request.setAttribute("datousuario", un.getVacuno(idvacuno));

               request.setAttribute("actualizar", "readonly");
            } catch (Exception e) {
                m = "" + e.getMessage();
            }
        }
        
        if ("eliminar".equals(request.getParameter("action"))) {
            try {
                Vacuno vn = new Vacuno();
                vn.setIdvacuno(idvacuno);
                un.getEliminarVacuno(vn);
                request.setAttribute("listado", un.ListadoVacunos());

               request.setAttribute("actualizar", "readonly");
            } catch (Exception e) {
                m = "" + e.getMessage();
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
