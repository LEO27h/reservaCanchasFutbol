package com.ceiba.reserva.servicio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearReserva {

    private static final String LA_RESERVA_YA_EXISTE = "Ya se ha creado una reserva con anterioridad para el usuario";

    private final RepositorioReserva repositorioReserva;


    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public int ejecutar(Reserva reserva) {
        validarExistenciaPrevia(reserva);
        return this.repositorioReserva.crear(reserva);
    }

    private void validarExistenciaPrevia(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getIdReserva());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_RESERVA_YA_EXISTE);
        }
    }
}
