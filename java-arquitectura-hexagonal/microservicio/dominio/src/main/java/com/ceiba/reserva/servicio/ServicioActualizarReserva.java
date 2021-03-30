package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;

public class ServicioActualizarReserva {

    private static final String LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA = "La reserva no existe en el sistema";

    private final RepositorioReserva repositorioReserva;

    public ServicioActualizarReserva(RepositorioReserva repositorioReserva) {
        this.repositorioReserva = repositorioReserva;
    }

    public void ejecutar(Double valorPagado, Long idReserva) {
        validarExistenciaPrevia(idReserva);
        Reserva reserva = repositorioReserva.obtener(idReserva);
        reserva.abonar(valorPagado);
        this.repositorioReserva.actualizar(reserva);
    }

    private void validarExistenciaPrevia(Long idReserva) {
        boolean existe = this.repositorioReserva.existe(idReserva);
        if(!existe) {
            throw new ExcepcionReservaNoEncontrada(LA_RESERVA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }



}
