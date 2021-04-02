package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoCumpleCondicionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";
    private static final String LA_RESERVA_SOLO_PUEDE_CANCELARSE_CON_MENOS_DE_UN_DIA_DE_ANTICIPACION = "La reserva no puede cancelarse con menos de un día de anticipación";
    private final RepositorioReserva repositorioReserva;

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Long idReserva) {
        validarExistenciaPrevia(idReserva);
        Reserva reserva = this.repositorioReserva.obtener(idReserva);
        this.fechaCancelacionValida(reserva.fechaCancelacionValida(reserva.getFechaDeJuego()));
        this.repositorioReserva.eliminar(idReserva);
    }

    private void validarExistenciaPrevia(Long idReserva) {
        boolean existe = this.repositorioReserva.existe(idReserva);
        if (!existe) {
            throw new ExcepcionReservaNoEncontrada(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void fechaCancelacionValida(Boolean cumpleCondicion) {
        if (cumpleCondicion) {
            throw new ExcepcionNoCumpleCondicionCancelacion(LA_RESERVA_SOLO_PUEDE_CANCELARSE_CON_MENOS_DE_UN_DIA_DE_ANTICIPACION);
        }
    }

}
