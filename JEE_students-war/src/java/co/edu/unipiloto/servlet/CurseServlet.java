/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.student.entity.Cursos;
import co.edu.unipiloto.arquitectura.student.session.CursosFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author UUSARIO
 */
@WebServlet(name = "CurseServlet", urlPatterns = {"/CurseServlet"})
public class CurseServlet extends HttpServlet {

    @EJB
    private CursosFacadeLocal cursosFacade;

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
        
        String action = request.getParameter("action");
        String idStr = request.getParameter("codCurso");
        Integer id = new Integer(0);
        if (idStr != null && !idStr.equals("")) {
            id = Integer.parseInt(idStr);
        }
        String nombreCurso = request.getParameter("nombreCurso");
        String numCreditos = request.getParameter("numCreditos");
        Integer numCred = new Integer(0);
        if (numCreditos != null && !numCreditos.equals("")) {
            numCred = Integer.parseInt(numCreditos);
        }
        String semestreStr = request.getParameter("semestre");
        Integer semestre = new Integer(0);
        if (semestreStr != null && !semestreStr.equals("")) {
            semestre = Integer.parseInt(semestreStr);
        }
        String numEstudAdmitidosStr = request.getParameter("numEstudAdmitidos");
        Integer numEstudAdmitidos = new Integer(0);
        if (numEstudAdmitidosStr != null && !numEstudAdmitidosStr.equals("")) {
            numEstudAdmitidos = Integer.parseInt(numEstudAdmitidosStr);
        }
        Cursos curso = new Cursos (id,nombreCurso,numCred,semestre,numEstudAdmitidos);
        if ("Add".equalsIgnoreCase(action)) {
            cursosFacade.create(curso);
        } else if ("Edit".equalsIgnoreCase(action)) {
            cursosFacade.edit(curso);
        } else if ("Delete".equalsIgnoreCase(action)) {
            cursosFacade.remove(cursosFacade.find(id));
        } else if ("Search".equalsIgnoreCase(action)) {
            curso = cursosFacade.find(id);
        } 

        
        
        if ("Search".equalsIgnoreCase(action)) {
            List cursos = new ArrayList();
            cursos.add(curso);
            request.setAttribute("allCurses", cursos);
        } else {
            request.setAttribute("allCurses", cursosFacade.findAll());
        }
        request.setAttribute("cur", curso);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
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
