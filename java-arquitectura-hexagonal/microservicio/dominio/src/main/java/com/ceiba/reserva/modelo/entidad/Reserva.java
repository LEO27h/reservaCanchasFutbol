package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reserva {
    private int idReserva;
    private int idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private int reservasConsecutivas;
    private String capacidadCancha;

    public Reserva(int idReserva, int idUsuario, double valorPagado, LocalDateTime fechaDeJuego, int reservasConsecutivas, String capacidadCancha) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.valorPagado = valorPagado;
        this.fechaDeJuego = fechaDeJuego;
        this.reservasConsecutivas = reservasConsecutivas;
        this.capacidadCancha = capacidadCancha;
    }
}
