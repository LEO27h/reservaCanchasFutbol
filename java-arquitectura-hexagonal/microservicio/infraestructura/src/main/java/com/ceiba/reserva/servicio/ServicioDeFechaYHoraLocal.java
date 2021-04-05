package com.ceiba.reserva.servicio;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServicioDeFechaYHoraLocal implements ServicioDeFechaYHora{

    @Override
    public LocalDateTime actual() {
        return LocalDateTime.now();
    }
}
