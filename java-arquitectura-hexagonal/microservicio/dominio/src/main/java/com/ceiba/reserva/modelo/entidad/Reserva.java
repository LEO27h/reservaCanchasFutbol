package com.ceiba.reserva.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reserva {

    private  static final String EL_VALOR_TOTAL_SOBREPASA_EL_COSTO_DE_LA_CANCHA = "El valor total sobrepasa el costo de la cancha";
    private  static final String EL_VALOR_NO_CUMPLE_CON_LA_CONDICION_MINIMA_DE_ABONO_PARA_LA_CANCHA = "El valor no cumple con la condición mínima de abono para la cancha";

    private static final double COSTO_CANCHA_FUTBOL_OCHO = 150000;
    private static final double COSTO_CANCHA_FUTBOL_CINCO = 100000;
    private static final String TIPO_CANCHA_FUTBOL_OCHO = "cancha futbol ocho";

    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private int reservasConsecutivas;
    private String capacidadCancha;

    public Reserva(Long idReserva, Long idUsuario, double valorPagado, LocalDateTime fechaDeJuego, int reservasConsecutivas, String capacidadCancha) {

        ValidadorArgumento.validarValorMaximoCancha(valorPagado, capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? COSTO_CANCHA_FUTBOL_OCHO : COSTO_CANCHA_FUTBOL_CINCO , EL_VALOR_TOTAL_SOBREPASA_EL_COSTO_DE_LA_CANCHA);
        ValidadorArgumento.validarAbonoMinimoCancha(valorPagado, capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? COSTO_CANCHA_FUTBOL_OCHO : COSTO_CANCHA_FUTBOL_CINCO, EL_VALOR_NO_CUMPLE_CON_LA_CONDICION_MINIMA_DE_ABONO_PARA_LA_CANCHA);

        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.valorPagado = valorPagado;
        this.fechaDeJuego = fechaDeJuego;
        this.reservasConsecutivas = reservasConsecutivas;
        this.capacidadCancha = capacidadCancha;
    }
}
