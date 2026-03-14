# ProyectoReservaCoworking

## Descripción
Este proyecto corresponde a una aplicación web backend desarrollada con Java Servlets para gestionar reservas de espacios en un coworking.

El sistema permite registrar reservas, validar que los datos estén completos, mostrar la lista de reservas almacenadas y eliminar reservas desde la misma lista.

Para esta solución se utilizó almacenamiento en memoria, tal como lo permite el enunciado de la actividad.

---

## Tecnologías utilizadas
- Java
- Java Servlets
- JSP
- HTML
- CSS
- Apache Tomcat
- NetBeans 19
- Maven

---

## Requisitos previos
Para ejecutar el proyecto se necesita:

- JDK 8 o superior
- Apache Tomcat 8 o compatible
- NetBeans 19

---

## Estructura del proyecto
El proyecto se organizó de acuerdo con lo solicitado en la actividad:

- `index.html`: formulario principal para registrar reservas
- `reservas.jsp`: página donde se muestra la lista de reservas
- `ReservaServlet.java`: procesa y valida el formulario
- `ListaReservasServlet.java`: envía la lista de reservas a la vista
- `EliminarReservaServlet.java`: elimina una reserva de la lista
- `Reserva.java`: clase que representa una reserva
- `styles.css`: archivo de estilos

---

## Funcionalidades implementadas

### Registro de reservas
Desde la página principal el usuario puede ingresar:
- Nombre del usuario
- Fecha de reserva
- Espacio de trabajo
- Duración en horas

### Validación de datos
El sistema verifica:
- Que todos los campos estén completos
- Que la duración sea numérica y mayor a cero
- Que la fecha no sea anterior al día actual

### Confirmación de reserva
Cuando la reserva se guarda correctamente, el sistema muestra una respuesta con los datos registrados.

### Lista de reservas
La aplicación muestra todas las reservas en una tabla.

### Eliminación de reservas
Cada reserva tiene un botón para eliminarla directamente desde la lista.

---

## Pasos para ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en NetBeans 19.
3. Verificar que Apache Tomcat esté configurado como servidor.
4. Ejecutar el proyecto desde NetBeans.
5. Abrir la aplicación en una URL similar a esta:

`http://localhost:8080/ParcialUno/index.html`

La ruta puede variar según el nombre configurado para el proyecto.

---

## Nota importante
Las reservas se almacenan en memoria, por lo tanto los datos se conservan únicamente mientras la aplicación esté en ejecución. Si el servidor se reinicia, la información se pierde.

---

## Informe breve sobre la solución
Para resolver el problema se desarrolló una aplicación web backend usando Java Servlets, JSP y HTML, desplegada en Apache Tomcat. La solución se organizó siguiendo la estructura solicitada en la actividad, con una página principal para registrar reservas, un servlet para procesarlas, un servlet para listar las reservas y otro servlet para eliminarlas.

Primero se construyó el formulario principal en `index.html`, donde el usuario puede ingresar su nombre, seleccionar la fecha, elegir el espacio de trabajo y definir la duración de la reserva. Luego se implementó `ReservaServlet`, encargado de recibir los datos, validarlos y guardar cada reserva en una lista en memoria. También se programó una respuesta de confirmación cuando la reserva se registra correctamente, y mensajes de error amigables cuando hay campos vacíos o datos inválidos.

Después se desarrolló `ListaReservasServlet`, que toma las reservas almacenadas y las envía a `reservas.jsp` para mostrarlas en una tabla. En esa misma vista se añadió la opción de eliminar una reserva usando `EliminarReservaServlet`.

Uno de los principales desafíos fue ajustar el proyecto para que cumpliera exactamente con la estructura y condiciones planteadas en la actividad. También fue importante implementar validaciones claras para que el usuario pudiera corregir fácilmente cualquier error en el formulario.

Finalmente, se agregó una hoja de estilos CSS para mejorar la presentación visual del sistema y se incluyeron comentarios sencillos en el código para facilitar su comprensión.

---

## Autor
Nombre del estudiante: Nicolas Obando
