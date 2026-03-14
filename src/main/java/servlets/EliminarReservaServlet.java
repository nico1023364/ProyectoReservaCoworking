package servlets;

import model.Reserva;
import java.io.IOException;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Este servlet recibe el ID de una reserva
// y la elimina de la lista en memoria.
@WebServlet(name = "EliminarReservaServlet", urlPatterns = {"/EliminarReservaServlet"})
public class EliminarReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idTexto = request.getParameter("idReserva");

        try {
            int id = Integer.parseInt(idTexto);

            Iterator<Reserva> iterator = ReservaServlet.listaReservas.iterator();
            while (iterator.hasNext()) {
                Reserva r = iterator.next();
                if (r.getId() == id) {
                    iterator.remove();
                    break;
                }
            }
        } catch (NumberFormatException e) {
            // Si llega un valor incorrecto, simplemente se vuelve a la lista
        }

        response.sendRedirect("ListaReservasServlet");
    }
}