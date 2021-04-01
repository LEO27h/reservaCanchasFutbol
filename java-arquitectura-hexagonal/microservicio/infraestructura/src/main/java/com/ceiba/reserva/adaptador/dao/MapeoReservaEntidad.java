package com.ceiba.reserva.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.reserva.modelo.entidad.Reserva;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoReservaEntidad implements RowMapper<Reserva>, MapperResult {


    @Override
    public Reserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idReserva = resultSet.getLong("idReserva");
        Long idUsuario = resultSet.getLong("idUsuario");
        double valorPagado = resultSet.getDouble("valorPagado");
        LocalDateTime fechaDeJuego = extraerLocalDateTime(resultSet, "fechaDeJuego");
        String capacidadCancha = resultSet.getString("capacidadCancha");
        String pagoCompletado = resultSet.getString("pagoCompletado");

        return new Reserva(idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha, pagoCompletado);
    }
}
