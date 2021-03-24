package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioReserva {
    /**
     * Permite crear un usuario
     * @param reserva
     * @return el id generado
     */
    Long crear(Reserva reserva);


    /**
     *
     * @param reserva
     */
    void actualizar(Reserva reserva);


    /**
     *
     * @param idReserva
     */
    void eliminar(Long idReserva);

}
