package com.ceiba.dominio.excepcion;

public class ExcepcionValidarAbonoMinimoCancha extends RuntimeException{

    private static final long serialReservaCanchaUID = 1L;

    public ExcepcionValidarAbonoMinimoCancha(String message) {
        super(message);
    }
}
