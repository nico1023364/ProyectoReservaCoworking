<%@page import="java.util.List"%>
<%@page import="model.Reserva"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Reservas</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <!-- Esta página muestra todas las reservas guardadas.
         También permite eliminar una reserva desde la misma tabla. -->
    
    <div class="container">
        <div class="card">
            <h1>Lista de Reservas</h1>
            <p class="subtitle">Aquí se muestran todas las reservas registradas en el sistema.</p>

            <%
                List<Reserva> reservas = (List<Reserva>) request.getAttribute("reservas");
                if (reservas == null || reservas.isEmpty()) {
            %>
                <div class="empty-box">
                    <p>No hay reservas registradas en este momento.</p>
                </div>
            <%
                } else {
            %>
                <div class="table-container">
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Nombre del usuario</th>
                            <th>Fecha de reserva</th>
                            <th>Espacio reservado</th>
                            <th>Duración</th>
                            <th>Acción</th>
                        </tr>

                        <%
                            for (Reserva r : reservas) {
                        %>
                        <tr>
                            <td><%= r.getId() %></td>
                            <td><%= r.getNombreUsuario() %></td>
                            <td><%= r.getFechaReserva() %></td>
                            <td><%= r.getEspacioTrabajo() %></td>
                            <td><%= r.getDuracionHoras() %> hora(s)</td>
                            <td>
                                <form action="EliminarReservaServlet" method="post">
                                    <input type="hidden" name="idReserva" value="<%= r.getId() %>">
                                    <button type="submit" class="btn btn-danger btn-small">Eliminar</button>
                                </form>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            <%
                }
            %>

            <div class="actions">
                <a href="index.html" class="btn btn-primary">Volver al formulario</a>
            </div>
        </div>
    </div>
</body>
</html>