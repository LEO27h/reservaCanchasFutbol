package com.ceiba.reserva.comando.manejador;

import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarReserva {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarReserva(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idReserva) {
        this.servicioEliminarUsuario.ejecutar(idReserva);
    }
}