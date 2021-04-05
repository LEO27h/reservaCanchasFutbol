package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionNoCumpleCondicionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioEliminarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";
    private static final String LA_RESERVA_SOLO_PUEDE_CANCELARSE_CON_MENOS_DE_UN_DIA_DE_ANTICIPACION = "La reserva no puede cancelarse con menos de un día de anticipación";
    private final RepositorioReserva repositorioReserva;
    private final ServicioDeFechaYHora fechaYHora;

    public ServicioEliminarReserva(RepositorioReserva repositorioReserva, ServicioDeFechaYHora fechaYHora) {
        this.repositorioReserva = repositorioReserva;
        this.fechaYHora = fechaYHora;
    }

    public void ejecutar(Long idReserva) {
        validarExistenciaPrevia(idReserva);
        Reserva reserva = this.repositorioReserva.obtener(idReserva);
        this.validarFechaCancelacion(reserva);
        this.repositorioReserva.eliminar(idReserva);
    }

    private void validarExistenciaPrevia(Long idReserva) {
        boolean existe = this.repositorioReserva.existe(idReserva);
        if (!existe) {
            throw new ExcepcionReservaNoEncontrada(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarFechaCancelacion(Reserva reserva) {
        if (!reserva.sePuedeCancelar(fechaYHora)) {
            throw new ExcepcionNoCumpleCondicionCancelacion(LA_RESERVA_SOLO_PUEDE_CANCELARSE_CON_MENOS_DE_UN_DIA_DE_ANTICIPACION);
        }
    }

}
