package servlets;

import model.Reserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Este servlet se encarga de tomar la lista de reservas guardadas
// y enviarla a la página JSP para mostrarla en pantalla.
@WebServlet(name = "ListaReservasServlet", urlPatterns = {"/ListaReservasServlet"})
public class ListaReservasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Reserva> reservas = ReservaServlet.listaReservas;
        request.setAttribute("reservas", reservas);
        request.getRequestDispatcher("reservas.jsp").forward(request, response);
    }
}