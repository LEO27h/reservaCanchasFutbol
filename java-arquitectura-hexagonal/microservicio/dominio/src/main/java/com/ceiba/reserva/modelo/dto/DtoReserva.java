package com.ceiba.reserva.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoReserva {
    private int idReserva;
    private int idUsuario;
    private double valorPagado;
    private LocalDateTime fechaUltimoPago;
}
