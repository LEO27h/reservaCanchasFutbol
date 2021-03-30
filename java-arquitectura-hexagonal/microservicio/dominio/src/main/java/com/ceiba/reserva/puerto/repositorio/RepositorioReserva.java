package com.ceiba.reserva.puerto.repositorio;

import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioReserva {
    /**
     * Permite crear un usuario
     * @param reserva
     * @return el id generado
     */
    Long  crear(Reserva reserva);

    /**
     * Verifica si existe reserva asociada al idReserva
     * @param idReserva
     * @return
     */
    boolean existe(Long idReserva);

    /**
     * Permite actualizar los datos de un reserva
     * @param reserva
     */
    void actualizar(Reserva reserva);

    /**
     * Retorna objeto tipo Reserva asociado con el idReserva recibido
     * @param idReserva
     * @return
     */
    Reserva obtener(Long idReserva);


    /**
     * Permite eliminar el registro de una reserva por medio de su id
     * @param idReserva
     */
    void eliminar(Long idReserva);

}
