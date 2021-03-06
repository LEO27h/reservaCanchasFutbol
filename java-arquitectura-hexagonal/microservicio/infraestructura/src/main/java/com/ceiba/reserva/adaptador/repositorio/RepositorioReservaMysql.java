package com.ceiba.reserva.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.reserva.adaptador.dao.MapeoReservaEntidad;
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

    @SqlStatement(namespace = "reserva_cancha", value = "existe")
    private static String sqlExiste;

    @SqlStatement(namespace = "reserva_cancha", value = "obtener")
    private static String sqlObtener;

    @SqlStatement(namespace = "reserva_cancha", value = "ocurrenciasPorUsuario")
    private static String sqlOcurrenciasPorUsuario;

    @SqlStatement(namespace = "reserva_cancha", value = "existePagoPendiente")
    private static String sqlExistePagoPendiente;

    @SqlStatement(namespace = "reserva_cancha", value = "reservaFuePagada")
    private static String sqlReservaFuePagada;

    public RepositorioReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Reserva reserva) {
        return this.customNamedParameterJdbcTemplate.crear(reserva, sqlCrear);
    }

    @Override
    public void actualizar(Reserva reserva) {
        this.customNamedParameterJdbcTemplate.actualizar(reserva, sqlActualizar);
    }

    @Override
    public Reserva obtener(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtener, mapSqlParameterSource, new MapeoReservaEntidad());
    }

    @Override
    public void eliminar(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, mapSqlParameterSource);
    }

    @Override
    public Long ocurrenciasPorUsuario(Long idUsuario, String pagoCompletado) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idUsuario", idUsuario);
        mapSqlParameterSource.addValue("pagoCompletado", pagoCompletado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlOcurrenciasPorUsuario, mapSqlParameterSource, Long.class);
    }

    @Override
    public boolean existe(Long idReserva) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, mapSqlParameterSource, Boolean.class);
    }

    @Override
    public boolean existePagoPendiente(Long idUsuario, String pagoCompletado) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idUsuario", idUsuario);
        mapSqlParameterSource.addValue("pagoCompletado", pagoCompletado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePagoPendiente, mapSqlParameterSource, Boolean.class);
    }

    public boolean reservaFuePagada(Long idReserva, String pagoCompletado) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idReserva", idReserva);
        mapSqlParameterSource.addValue("pagoCompletado", pagoCompletado);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlReservaFuePagada, mapSqlParameterSource, Boolean.class);
    }
}
