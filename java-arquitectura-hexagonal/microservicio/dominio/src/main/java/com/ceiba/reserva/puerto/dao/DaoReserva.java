package com.ceiba.reserva.puerto.dao;

import com.ceiba.reserva.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoReserva> listar();
}
