package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long idReserva = resultSet.getLong("idReserva");
        Long idUsuario = resultSet.getLong("idUsuario");
        double valorPagado = resultSet.getDouble("valorPagado");
        LocalDateTime fechaDeJuego = extraerLocalDateTime(resultSet, "fechaDeJuego");
        String capacidadCancha = resultSet.getString("capacidadCancha");

        return new DtoReserva(idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha);
    }

}
