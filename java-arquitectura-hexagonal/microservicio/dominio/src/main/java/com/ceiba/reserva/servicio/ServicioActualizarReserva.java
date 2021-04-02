package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.dominio.excepcion.ExcepcionReservaPagada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";
    private static final String LA_RESERVA_YA_FUE_PAGADA = "La reserva ya fue pagada";
    private static final String PAGO_COMPLETADO = "S";
    private static final Boolean ES_CREAR_RESERVA = false;

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Double valorPagado, Long idReserva) {
        this.validarExistenciaPrevia(idReserva);
        Reserva reserva = repositorioReserva.obtener(idReserva);
        this.validarReservaPagada(reserva);
        reserva.abonar(valorPagado);
        reserva.validarPagoCompletado();
        reserva.aplicarDescuento(this.encontrarOcurrenciasPorUsuario(reserva), ES_CREAR_RESERVA, reserva.getPagoCompletado());
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(Long idReserva) {
        boolean existe = this.repositorioReserva.existe(idReserva);
        if (!existe) {
            throw new ExcepcionReservaNoEncontrada(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private Long encontrarOcurrenciasPorUsuario(Reserva reserva) {
        return this.repositorioReserva.ocurrenciasPorUsuario(reserva.getIdUsuario(), PAGO_COMPLETADO);
    }

    private void validarReservaPagada(Reserva reserva) {
        if (this.repositorioReserva.reservaFuePagada(reserva.getIdReserva(), PAGO_COMPLETADO)) {
            throw new ExcepcionReservaPagada(LA_RESERVA_YA_FUE_PAGADA);
        }
    }
}
