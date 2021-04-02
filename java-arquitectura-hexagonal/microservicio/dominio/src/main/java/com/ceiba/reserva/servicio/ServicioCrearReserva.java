package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionPagoPendiente;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;


public class ServicioCrearReserva {

    private static final String EL_USUARIO_TIENE_UN_PAGO_PENDIENTE = "El usuario tiene un pago pendiente";
    private static final String PAGO_COMPLETADO = "S";
    private static final String PAGO_NO_COMPLETADO = "N";
    private static final Boolean ES_CREAR_RESERVA = true;

    private final RepositorioReserva repositorioReserva;

    public ServicioCrearReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public Long ejecutar(Reserva reserva) {
        validarExistenciaPagoPendiente(reserva);
        reserva.validarPagoCompletado();
        reserva.aplicarDescuento(this.encontrarOcurrenciasPorUsuario(reserva), ES_CREAR_RESERVA, reserva.getPagoCompletado());
        return this.repositorioReserva.crear(reserva);
    }

    private Long encontrarOcurrenciasPorUsuario(Reserva reserva) {
//        reserva.condicionpagoCompletado();
        return this.repositorioReserva.ocurrenciasPorUsuario(reserva.getIdUsuario(), PAGO_COMPLETADO);
    }

    private void validarExistenciaPagoPendiente(Reserva reserva) {
//        reserva.condicionPagoNoCompletado();
        boolean existe = this.repositorioReserva.existePagoPendiente(reserva.getIdUsuario(), PAGO_NO_COMPLETADO);
        if (existe) {
            throw new ExcepcionPagoPendiente(EL_USUARIO_TIENE_UN_PAGO_PENDIENTE);
        }
    }
}
