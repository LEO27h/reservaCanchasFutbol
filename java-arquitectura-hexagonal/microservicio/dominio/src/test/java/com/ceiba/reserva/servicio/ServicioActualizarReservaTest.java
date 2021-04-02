package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.dominio.excepcion.ExcepcionReservaPagada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testDataBuilder.ReservaTestDataBuilder;
import javafx.beans.binding.When;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarReservaTest {

    @Test
    public void validarReservaExistenciaPreviaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarReserva.ejecutar(75000D, 1L), ExcepcionReservaNoEncontrada.class,"La reserva no existe en el sistema");
    }

    @Test
    public void validarReservaPagadaTest(){
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.obtener(Mockito.anyLong())).thenReturn(reserva);
        Mockito.when(repositorioReserva.reservaFuePagada(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarReserva servicioActualizarReserva = new ServicioActualizarReserva(repositorioReserva);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarReserva.ejecutar(Mockito.anyDouble(), Mockito.anyLong()), ExcepcionReservaPagada.class, "La reserva ya fue pagada");
    }

}
