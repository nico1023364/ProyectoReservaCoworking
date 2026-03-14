package model;

import java.io.Serializable;

// Esta clase representa una reserva.
// Aquí se guardan los datos básicos que el usuario ingresa en el formulario.
public class Reserva implements Serializable {
    
    private int id;
    private String nombreUsuario;
    private String fechaReserva;
    private String espacioTrabajo;
    private int duracionHoras;

    public Reserva() {
    }

    public Reserva(int id, String nombreUsuario, String fechaReserva, String espacioTrabajo, int duracionHoras) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fechaReserva = fechaReserva;
        this.espacioTrabajo = espacioTrabajo;
        this.duracionHoras = duracionHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEspacioTrabajo() {
        return espacioTrabajo;
    }

    public void setEspacioTrabajo(String espacioTrabajo) {
        this.espacioTrabajo = espacioTrabajo;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }
}