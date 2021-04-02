package com.ceiba.dominio.excepcion;

public class ExcepcionNoCumpleCondicionCancelacion extends RuntimeException {
    public ExcepcionNoCumpleCondicionCancelacion(String message) {
        super(message);
    }
}
