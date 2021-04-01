package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.reserva.comando.ComandoReserva;

import java.time.LocalDateTime;

public class ComandoReservaTestDataBuilder {
    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private String capacidadCancha;

    public ComandoReservaTestDataBuilder() {
        idReserva = 1234L;
        idUsuario = 123456789L;
        valorPagado = 80000D;
        fechaDeJuego = LocalDateTime.now();
        capacidadCancha = "cancha futbol ocho";
    }

    public ComandoReserva build() { return new ComandoReserva(idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha);}
}
