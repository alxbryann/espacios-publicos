package co.edu.unipiloto.servlet;

import co.edu.unipiloto.arquitectrura.espacios.entity.Proyectos;
import co.edu.unipiloto.arquitectrura.espacios.session.ProyectosFacadeLocal;
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

@WebServlet(name = "ProyectosServlet", urlPatterns = {"/ProyectosServlet"})
public class ProyectosServlet extends HttpServlet {

    @EJB
    private ProyectosFacadeLocal proyectosFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String idStr = request.getParameter("PROYECTOID");
        int proyectoId = 0;
        if (idStr != null && !idStr.equals("")) {
            proyectoId = Integer.parseInt(idStr);
        }
        String nombre = request.getParameter("NOMBRE");
        String descripcion = request.getParameter("DESCRIPCION");
        String localidad = request.getParameter("LOCALIDAD");
        String presupuestoStr = request.getParameter("PRESUPUESTO");
        int presupuesto = 0;
        if (presupuestoStr != null && !presupuestoStr.equals("")) {
            presupuesto = Integer.parseInt(presupuestoStr);
        }
        String numHabitantesStr = request.getParameter("NUMERO_HABITANTES");
        int numHabitantes = 0;
        if (numHabitantesStr != null && !numHabitantesStr.equals("")) {
            numHabitantes = Integer.parseInt(numHabitantesStr);
        }
        
        // Crear un objeto Proyectos
        Proyectos proyecto = new Proyectos(proyectoId, nombre, descripcion, localidad, presupuesto, numHabitantes);

        if ("Add".equalsIgnoreCase(action)) {
            proyectosFacade.create(proyecto);
        } else if ("Edit".equalsIgnoreCase(action)) {
            proyectosFacade.edit(proyecto);
        } else if ("Delete".equalsIgnoreCase(action)) {
            proyectosFacade.remove(proyecto);
        } else if ("Search".equalsIgnoreCase(action)) {
            proyecto = proyectosFacade.find(proyectoId);
            List<Proyectos> proyectos = new ArrayList<>();
            if (proyecto != null) {
                proyectos.add(proyecto);
            }
            request.setAttribute("proyectos", proyecto);
            request.setAttribute("allProyectos", proyectos);
            request.getRequestDispatcher("proyectosInfo.jsp").forward(request, response);
            return;
        }else if ("See Table".equalsIgnoreCase(action)) {
            List proyectos = new ArrayList();
            proyectos = proyectosFacade.findAll();
            request.setAttribute("proyectos", proyecto);
            request.setAttribute("allProyectos", proyectos);
            request.getRequestDispatcher("proyectosInfo.jsp").forward(request, response);
        }
        List<Proyectos> proyectos = proyectosFacade.findAll();
            request.setAttribute("proyectos", proyecto);
            request.setAttribute("allProyectos", proyectos);
            request.getRequestDispatcher("proyectosInfo.jsp").forward(request, response);
            
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentServlet</title>");
            out.println("</head>"); 
            out.println("<body>");
            out.println("</body>");
            out.println("</html>"); 
        }
    }    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
