package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private String capacidadCancha;
    private String pagoCompletado;
}
