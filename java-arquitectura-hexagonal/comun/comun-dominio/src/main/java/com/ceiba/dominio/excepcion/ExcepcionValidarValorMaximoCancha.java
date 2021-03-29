package com.ceiba.dominio.excepcion;

public class ExcepcionValidarValorMaximoCancha extends RuntimeException{

    private static final long serialReservaCanchaUID = 1L;

    public ExcepcionValidarValorMaximoCancha (String message){
        super(message);
    }

}
