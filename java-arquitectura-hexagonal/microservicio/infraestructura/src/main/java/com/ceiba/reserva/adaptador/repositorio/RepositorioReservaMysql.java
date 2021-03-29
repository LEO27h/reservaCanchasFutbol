package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.modelo.entidad.Reserva;
import com.ceiba.reserva.puerto.repositorio.RepositorioReserva;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioReservaMysql implements RepositorioReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva_cancha", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="reserva_cancha", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="reserva_cancha", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="reserva_cancha", value="existe")
    private static String sqlExiste;

//    @SqlStatement(namespace="reserva_cancha", value="existeExcluyendoId")
//    private static String sqlExisteExcluyendoId;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) { return this.customNamedParameterJdbcTemplate.crear(reserva,sqlCrear);}

    @Override
    public boolean existe(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public void eliminar(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, mapSqlParameterSource);
    }

}
