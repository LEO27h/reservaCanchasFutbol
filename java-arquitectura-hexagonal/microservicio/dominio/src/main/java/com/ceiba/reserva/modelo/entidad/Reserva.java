package com.ceiba.reserva.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reserva {
    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaUltimoPago;

    public Reserva(Long idReserva, Long idUsuario, double valorPagado, LocalDateTime fechaUltimoPago) {
        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.valorPagado = valorPagado;
        this.fechaUltimoPago = fechaUltimoPago;
    }
}
