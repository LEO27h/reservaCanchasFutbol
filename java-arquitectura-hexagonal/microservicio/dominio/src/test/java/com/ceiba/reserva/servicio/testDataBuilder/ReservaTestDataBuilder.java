package com.ceiba.reserva.servicio.testDataBuilder;

import com.ceiba.reserva.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {
    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private String capacidadCancha;

    public ReservaTestDataBuilder() {
        idReserva = 1234L;
        idUsuario = 123456789L;
        valorPagado = 80000;
        fechaDeJuego = LocalDateTime.now();
        capacidadCancha = "cancha futbol ocho";
    }

    public ReservaTestDataBuilder conValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
        return  this;
    }

    public Reserva build() {return new Reserva(idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha); }
}
