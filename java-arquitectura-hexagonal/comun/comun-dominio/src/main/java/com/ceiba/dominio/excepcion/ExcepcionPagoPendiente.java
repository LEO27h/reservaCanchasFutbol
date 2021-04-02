package com.ceiba.dominio.excepcion;

public class ExcepcionPagoPendiente extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ExcepcionPagoPendiente(String message) {super(message); }
}
