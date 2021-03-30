package com.ceiba.reserva.comando.manejador;

import com.ceiba.reserva.comando.ComandoAbonoReserva;
import com.ceiba.reserva.comando.fabrica.FabricaReserva;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarReserva {

    private final ServicioActualizarReserva servicioActualizarReserva;

    public ManejadorActualizarReserva(ServicioActualizarReserva servicioActualizarReserva) {
        this.servicioActualizarReserva = servicioActualizarReserva;
    }

    public void ejecutar(ComandoAbonoReserva comandoAbonoReserva, Long idReserva) {
        this.servicioActualizarReserva.ejecutar(comandoAbonoReserva.getValorAbono(), idReserva);
    }
}
