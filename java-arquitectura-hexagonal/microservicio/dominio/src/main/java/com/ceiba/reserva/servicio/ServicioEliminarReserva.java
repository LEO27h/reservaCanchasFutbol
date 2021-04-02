package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";

    private final RepositorioReserva repositorioReserva;

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long idReserva) {
        validarExistenciaPrevia(idReserva);
        Reserva reserva = this.repositorioReserva.obtener(idReserva);
        reserva.fechaCancelacionValida(reserva.getFechaDeJuego());
        this.repositorioReserva.eliminar(idReserva);
    }

    private void validarExistenciaPrevia(Long idReserva){
        boolean existe = this.repositorioReserva.existe(idReserva);
        if (!existe){
            throw new ExcepcionReservaNoEncontrada(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
