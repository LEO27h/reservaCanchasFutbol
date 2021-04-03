package com.ceiba.reserva.servicio.testDataBuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ReservaTestDataBuilder {
    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private String capacidadCancha;
    private String pagoCompletado;

    public ReservaTestDataBuilder() {
        idReserva = 1234L;
        idUsuario = 123456789L;
        valorPagado = 80000;
        fechaDeJuego = LocalDateTime.now();
        capacidadCancha = "cancha futbol ocho";
        pagoCompletado = "N";
    }

    public ReservaTestDataBuilder conValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
        return this;
    }

    public ReservaTestDataBuilder conCapacidadCancha(String capacidadCancha) {
        this.capacidadCancha = capacidadCancha;
        return this;
    }

    public ReservaTestDataBuilder conFechaDeJuego(LocalDateTime fechaDeJuego){
        this.fechaDeJuego = fechaDeJuego;
        return this;
    }

    public Reserva build() {
        return new Reserva(idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha, pagoCompletado);
    }
}
