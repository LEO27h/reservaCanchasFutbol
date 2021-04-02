package com.ceiba.reserva.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Reserva {

    private static final String EL_VALOR_TOTAL_SOBREPASA_EL_COSTO_DE_LA_CANCHA = "El valor total sobrepasa el costo de la cancha";
    private static final String EL_VALOR_NO_CUMPLE_CON_LA_CONDICION_MINIMA_DE_ABONO_PARA_LA_CANCHA = "El valor no cumple con la condición mínima de abono para la cancha";

    private static final int CONDICION_RESERVAS_CONSECUTIVAS_PARA_DESCUENTO = 3;
    private static final int RESERVA_ACTUAL = 1;
    private static final int SIN_EXISTENCIA_DE_RESGISTROS = 0;
    private static final double COSTO_CANCHA_FUTBOL_OCHO = 150000;
    private static final double COSTO_CANCHA_FUTBOL_CINCO = 100000;
    private static final double PORCETANJE_DESCUENTO_FUTBOL_OCHO = 0.3;
    private static final double PORCETANJE_DESCUENTO_FUTBOL_CINCO = 0.15;
    private static final String TIPO_CANCHA_FUTBOL_OCHO = "cancha futbol ocho";
    private static final String SI = "S";
    private static final String NO = "N";

    private Long idReserva;
    private Long idUsuario;
    private double valorPagado;
    private LocalDateTime fechaDeJuego;
    private String capacidadCancha;
    private String pagoCompletado;

    public Reserva(Long idReserva, Long idUsuario, double valorPagado, LocalDateTime fechaDeJuego, String capacidadCancha, String pagoCompletado) {

        ValidadorArgumento.validarValorMaximoCancha(valorPagado, capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? COSTO_CANCHA_FUTBOL_OCHO : COSTO_CANCHA_FUTBOL_CINCO, EL_VALOR_TOTAL_SOBREPASA_EL_COSTO_DE_LA_CANCHA);
        ValidadorArgumento.validarAbonoMinimoCancha(valorPagado, capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? COSTO_CANCHA_FUTBOL_OCHO : COSTO_CANCHA_FUTBOL_CINCO, EL_VALOR_NO_CUMPLE_CON_LA_CONDICION_MINIMA_DE_ABONO_PARA_LA_CANCHA);

        this.idReserva = idReserva;
        this.idUsuario = idUsuario;
        this.valorPagado = valorPagado;
        this.fechaDeJuego = fechaDeJuego;
        this.capacidadCancha = capacidadCancha;
        this.pagoCompletado = pagoCompletado;
    }

    public void abonar(Double valorAAbonar) {
        ValidadorArgumento.validarValorMaximoCancha(valorPagado + valorAAbonar, capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? COSTO_CANCHA_FUTBOL_OCHO : COSTO_CANCHA_FUTBOL_CINCO, EL_VALOR_TOTAL_SOBREPASA_EL_COSTO_DE_LA_CANCHA);
        valorPagado += valorAAbonar;
    }

    public boolean aplicaDescuentoFutbolOcho(Long ocurrenciasPorUsuario, Boolean llamadoDesdeCrearReserva) {
        boolean aplicaDescuento = false;
        if (llamadoDesdeCrearReserva) {
            aplicaDescuento = (ocurrenciasPorUsuario + RESERVA_ACTUAL) % CONDICION_RESERVAS_CONSECUTIVAS_PARA_DESCUENTO == 0 ? true : false;
        }else {
            aplicaDescuento = (ocurrenciasPorUsuario - RESERVA_ACTUAL) % CONDICION_RESERVAS_CONSECUTIVAS_PARA_DESCUENTO == 0 ? true : false;
        }
        return aplicaDescuento;
    }

    public void aplicarDescuentoPorCancha(Long cantidadOcurrenciasPorUsuario) {
        if (esCanchaFutbolOcho()) {
            valorPagado = valorPagado - (valorPagado * PORCETANJE_DESCUENTO_FUTBOL_OCHO);
        } else if (cantidadOcurrenciasPorUsuario != SIN_EXISTENCIA_DE_RESGISTROS) {
            valorPagado = valorPagado - (valorPagado * PORCETANJE_DESCUENTO_FUTBOL_CINCO);
        }
    }

    public void aplicarDescuento(Long cantidadOcurrenciasPorUsuario, Boolean llamadoDesdeCrearReserva, String pagoCompletado) {
        if (pagoCompletado.equals(SI)) {
            if (esCanchaFutbolOcho()) {
                if (aplicaDescuentoFutbolOcho(cantidadOcurrenciasPorUsuario, llamadoDesdeCrearReserva)) {
                    aplicarDescuentoPorCancha(cantidadOcurrenciasPorUsuario);
                }
            } else {
                aplicarDescuentoPorCancha(cantidadOcurrenciasPorUsuario);
            }
        }
    }

    public boolean esCanchaFutbolOcho() {
        boolean esFutbolOcho = false;
        esFutbolOcho = capacidadCancha.equals(TIPO_CANCHA_FUTBOL_OCHO) ? true : false;
        return esFutbolOcho;
    }

    public void validarPagoCompletado() {
        boolean completo = false;
        if (esCanchaFutbolOcho()) {
            completo = valorPagado == COSTO_CANCHA_FUTBOL_OCHO ? true : false;
        } else {
            completo = valorPagado == COSTO_CANCHA_FUTBOL_CINCO ? true : false;
        }
        setearPagoCompletado(completo);
    }

    public Boolean fechaCancelacionValida(LocalDateTime fechaDeJuego){
        Boolean cumpleCondicion = false;
        int compareTo  = fechaDeJuego.compareTo(LocalDateTime.now());
        return cumpleCondicion;
    }

    public void setearPagoCompletado(Boolean completo) {
        pagoCompletado = completo ? SI : NO;
    }

    public void condicionPagoNoCompletado(){
        pagoCompletado = NO;
    }

    public void condicionpagoCompletado(){
        pagoCompletado = SI;
    }
}
