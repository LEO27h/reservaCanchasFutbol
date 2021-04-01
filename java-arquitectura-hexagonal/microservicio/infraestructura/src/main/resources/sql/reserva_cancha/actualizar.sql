update reserva_cancha
set valorPagado = :valorPagado,
    pagoCompletado = :pagoCompletado
where idReserva = :idReserva