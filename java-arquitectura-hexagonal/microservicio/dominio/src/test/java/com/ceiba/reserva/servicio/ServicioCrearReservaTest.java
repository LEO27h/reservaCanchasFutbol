package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionPagoPendiente;
import com.ceiba.dominio.excepcion.ExcepcionValidarAbonoMinimoCancha;
import com.ceiba.dominio.excepcion.ExcepcionValidarValorMaximoCancha;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testDataBuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioCrearReservaTest {

    @Test
    public void validarValorMaximoCancha() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder();
        reservaTestDataBuilder.conValorPagado(160000);
        reservaTestDataBuilder.conCapacidadCancha("cancha futbol ocho");
        // act - assert
        BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValidarValorMaximoCancha.class, "El valor total sobrepasa el costo de la cancha");
    }

    @Test
    public void validarAbonoMinimoCancha() {
        //arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder();
        reservaTestDataBuilder.conValorPagado(74000);
        reservaTestDataBuilder.conCapacidadCancha("cancha futbol ocho");
        // act - assert
        BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValidarAbonoMinimoCancha.class, "El valor no cumple con la condición mínima de abono para la cancha");
    }

    @Test
    public void validarExistenciaPagoPendienteTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existePagoPendiente(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionPagoPendiente.class, "El usuario tiene un pago pendiente");
    }

}
