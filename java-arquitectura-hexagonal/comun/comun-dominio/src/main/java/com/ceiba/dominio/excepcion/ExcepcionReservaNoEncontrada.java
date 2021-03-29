package com.ceiba.dominio.excepcion;

public class ExcepcionReservaNoEncontrada extends RuntimeException{


    public ExcepcionReservaNoEncontrada(String message) {
        super(message);
    }
}
