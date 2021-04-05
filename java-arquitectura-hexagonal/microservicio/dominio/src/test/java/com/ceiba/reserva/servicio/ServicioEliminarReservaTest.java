package com.ceiba.reserva.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionNoCumpleCondicionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionReservaNoEncontrada;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import com.ceiba.reserva.servicio.testDataBuilder.ReservaTestDataBuilder;
import org.junit.Test;
import org.mockito.AdditionalMatchers;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ServicioEliminarReservaTest {

    @Test
    public void existePagoPendienteTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(false);
        ServicioDeFechaYHora fechaYHora = Mockito.mock(ServicioDeFechaYHora.class);
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva, fechaYHora);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarReserva.ejecutar(Mockito.anyLong()), ExcepcionReservaNoEncontrada.class, "La reserva no existe en el sistema");

    }

    @Test
    public void fechaCancelacionValida(){
        // arrange

        Reserva reserva = new ReservaTestDataBuilder()
                .conFechaDeJuego(LocalDateTime.of(2021, 03, 05, 18, 00))
                .build();
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioReserva.obtener(Mockito.anyLong())).thenReturn(reserva);
        ServicioDeFechaYHora fechaYHora = Mockito.mock(ServicioDeFechaYHora.class);
        Mockito.when(fechaYHora.actual()).thenReturn(LocalDateTime.of(2021, 03, 04, 23, 00));
        ServicioEliminarReserva servicioEliminarReserva = new ServicioEliminarReserva(repositorioReserva, fechaYHora);
        // act - assert
        BasePrueba.assertThrows(() -> servicioEliminarReserva.ejecutar(reserva.getIdReserva()), ExcepcionNoCumpleCondicionCancelacion.class, "La reserva no puede cancelarse con menos de un día de anticipación");
    }
}
