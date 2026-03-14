package servlets;

import model.Reserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Este servlet recibe los datos del formulario,
// valida que estén completos y guarda la reserva en memoria.
@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {

    // Lista en memoria donde se van guardando las reservas
    public static List<Reserva> listaReservas = new ArrayList<>();
    
    // Contador simple para asignar un ID a cada reserva
    public static int contadorId = 1;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombreUsuario = request.getParameter("nombreUsuario");
        String fechaReserva = request.getParameter("fechaReserva");
        String espacioTrabajo = request.getParameter("espacioTrabajo");
        String duracionHorasTexto = request.getParameter("duracionHoras");

        String error = "";

        // Se revisa que ningún campo llegue vacío
        if (nombreUsuario == null || nombreUsuario.trim().isEmpty()
                || fechaReserva == null || fechaReserva.trim().isEmpty()
                || espacioTrabajo == null || espacioTrabajo.trim().isEmpty()
                || duracionHorasTexto == null || duracionHorasTexto.trim().isEmpty()) {
            error = "Todos los campos son obligatorios.";
        }

        int duracionHoras = 0;

        // Se valida que la duración sea numérica y mayor a cero
        if (error.isEmpty()) {
            try {
                duracionHoras = Integer.parseInt(duracionHorasTexto);
                if (duracionHoras <= 0) {
                    error = "La duración debe ser mayor a 0.";
                }
            } catch (NumberFormatException e) {
                error = "La duración debe ser numérica.";
            }
        }

        // Se valida que la fecha sea correcta y que no sea anterior al día actual
        if (error.isEmpty()) {
            try {
                LocalDate fecha = LocalDate.parse(fechaReserva);
                if (fecha.isBefore(LocalDate.now())) {
                    error = "La fecha de reserva no puede ser anterior a hoy.";
                }
            } catch (Exception e) {
                error = "La fecha ingresada no es válida.";
            }
        }

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // Si hay error, se muestra un mensaje amigable y se deja volver al formulario
        if (!error.isEmpty()) {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='es'>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Error</title>");
            out.println("<link rel='stylesheet' href='css/styles.css'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<div class='card message-card'>");
            out.println("<h2 class='error-title'>No se pudo registrar la reserva</h2>");
            out.println("<p class='message-text'>" + error + "</p>");
            out.println("<a class='btn btn-primary' href='index.html'>Volver al formulario</a>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        // Si todo está correcto, se crea la reserva y se guarda en la lista
        Reserva reserva = new Reserva(contadorId++, nombreUsuario, fechaReserva, espacioTrabajo, duracionHoras);
        listaReservas.add(reserva);

        // Se muestra la confirmación con los datos registrados
        out.println("<!DOCTYPE html>");
        out.println("<html lang='es'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Reserva Confirmada</title>");
        out.println("<link rel='stylesheet' href='css/styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<div class='card message-card'>");
        out.println("<h2 class='success-title'>Reserva registrada correctamente</h2>");
        out.println("<p><strong>Nombre:</strong> " + reserva.getNombreUsuario() + "</p>");
        out.println("<p><strong>Fecha:</strong> " + reserva.getFechaReserva() + "</p>");
        out.println("<p><strong>Espacio:</strong> " + reserva.getEspacioTrabajo() + "</p>");
        out.println("<p><strong>Duración:</strong> " + reserva.getDuracionHoras() + " hora(s)</p>");
        out.println("<div class='actions-inline'>");
        out.println("<a class='btn btn-primary' href='index.html'>Nueva reserva</a>");
        out.println("<a class='btn btn-secondary' href='ListaReservasServlet'>Ver lista de reservas</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}