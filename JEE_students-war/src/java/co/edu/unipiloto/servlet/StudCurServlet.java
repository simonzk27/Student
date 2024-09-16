package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectura.student.entity.Cursos;
import co.edu.unipiloto.arquitectura.student.entity.Student; // Suponiendo que tienes esta clase
import co.edu.unipiloto.arquitectura.student.entity.Studcur;
import co.edu.unipiloto.arquitectura.student.entity.StudcurPK;
import co.edu.unipiloto.arquitectura.student.session.CursosFacadeLocal; // Asumiendo que tienes este facade
import co.edu.unipiloto.arquitectura.student.session.StudentFacadeLocal; // Asumiendo que tienes este facade
import co.edu.unipiloto.arquitectura.student.session.StudcurFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "StudCurServlet", urlPatterns = {"/StudCurServlet"})
public class StudCurServlet extends HttpServlet {

    @EJB
    private StudcurFacadeLocal studcurFacade;
    
    @EJB
    private CursosFacadeLocal cursosFacade; // Para verificar si el curso existe
    
    @EJB
    private StudentFacadeLocal studentsFacade; // Para verificar si el estudiante existe

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String action = request.getParameter("action");
        String idCursoStr = request.getParameter("codCurso");
        String idEstudStr = request.getParameter("studentid");

        Integer idCurso = 0;
        Integer idEstud = 0;

        // Validación de curso
        if (idCursoStr != null && !idCursoStr.equals("")) {
            idCurso = Integer.parseInt(idCursoStr);
        } else {
            request.setAttribute("errorMessage", "Código de curso no válido.");
            request.setAttribute("allIn", studcurFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }

        // Validación de estudiante
        if (idEstudStr != null && !idEstudStr.equals("")) {
            idEstud = Integer.parseInt(idEstudStr);
        } else {
            request.setAttribute("errorMessage", "ID de estudiante no válido.");
            request.setAttribute("allIn", studcurFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }

        // Verificar si el curso existe
        Cursos curso = cursosFacade.find(idCurso);
        if (curso == null) {
            request.setAttribute("errorMessage", "El curso con ID " + idCurso + " no existe.");
            request.setAttribute("allIn", studcurFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }

        // Verificar si el estudiante existe
        Student estudiante = studentsFacade.find(idEstud);
        if (estudiante == null) {
            request.setAttribute("errorMessage", "El estudiante con ID " + idEstud + " no existe.");
            request.setAttribute("allIn", studcurFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }

        StudcurPK relacion = new StudcurPK(idCurso, idEstud);

        // Verificar si ya existe la relación entre curso y estudiante
        Studcur relacionExistente = studcurFacade.find(relacion);
        if (relacionExistente != null) {
            request.setAttribute("errorMessage", "La relación entre el curso y el estudiante ya existe.");
            request.setAttribute("allIn", studcurFacade.findAll());
            request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
            return;
        }

        // Si la acción es "Add" y no hay errores, crear la nueva relación
        if ("Add".equalsIgnoreCase(action)) {
            studcurFacade.create(new Studcur(relacion));
        }

        // Mostrar todos los registros en la misma página
        request.setAttribute("allIn", studcurFacade.findAll());
        request.setAttribute("stcurpk", relacion);
        request.getRequestDispatcher("studentInfo.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "StudCurServlet que gestiona las relaciones entre cursos y estudiantes";
    }
}
