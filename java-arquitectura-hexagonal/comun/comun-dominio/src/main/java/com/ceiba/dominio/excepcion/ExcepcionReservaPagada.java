package com.ceiba.dominio.excepcion;

public class ExcepcionReservaPagada extends RuntimeException {
    public ExcepcionReservaPagada(String message) {
        super(message);
    }
}
