package mx.edu.utez.controller;

import mx.edu.utez.model.pelicula.BeanPelicula;
import mx.edu.utez.model.pelicula.DaoPelicula;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletPelicula", urlPatterns = {"/readPelicula", "/createPelicula", "/getPeliculaById", "/updatePelicula", "/deletePelicula"})
public class ServletPelicula extends HttpServlet {
    Logger logger = LoggerFactory.getLogger(ServletPelicula.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPelicula", new DaoPelicula().findAll());
        request.getRequestDispatcher("/views/pelicula/pelicula.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch(action){
            case "create":
                // do something
                String nombre = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String descripcion = request.getParameter("descripcion");
                String fechaEstreno = request.getParameter("fechaEstreno");
                double recaudacion = Integer.parseInt(request.getParameter("recaudacion"));

                BeanPelicula beanPelicula = new BeanPelicula(1,nombre, descripcion, fechaEstreno, recaudacion, 1);

                if(new DaoPelicula().create(beanPelicula)){
                    request.setAttribute("message", "La pelicula fue registrada correctamente");
                } else {
                    request.setAttribute("message", "La pelicula no fue registrada");
                }
                doGet(request, response);
                break;

            case "getPeliculaById":
                // do something
                long id = Long.parseLong(request.getParameter("id"));
                request.setAttribute("pelicula", new DaoPelicula().findById(id));
                request.getRequestDispatcher("/views/pelicula/update.jsp").forward(request, response);
                break;

            case "update":
                // do something
                long id1 = Long.parseLong(request.getParameter("id"));
                String nombre1 = request.getParameter("nombre") != null ? request.getParameter("nombre") : "";
                String descripcion1 = request.getParameter("descripcion");
                String fechaEstreno1 = request.getParameter("fechaEstreno");
                double recaudacion1 = Integer.parseInt(request.getParameter("recaudacion"));

                BeanPelicula beanPelicula1 = new BeanPelicula(id1, nombre1, descripcion1, fechaEstreno1, recaudacion1, 1);

                if(new DaoPelicula().update(beanPelicula1)){
                    request.setAttribute("message", "La pelicula fue modificada correctamente");
                } else {
                    request.setAttribute("message", "La pelicula no fue modificada correctamente");
                }
                doGet(request, response);
                break;

            case "delete":
                // do something
                long id2 = Long.parseLong(request.getParameter("id"));
                if(new DaoPelicula().delete(id2)){
                    request.setAttribute("message", "El usuario fue eliminado correctamente");
                } else {
                    request.setAttribute("message", "El usuario no fue eliminado correctamente");
                }
                doGet(request, response);
                break;
            default:

                break;
        }
    }
}
