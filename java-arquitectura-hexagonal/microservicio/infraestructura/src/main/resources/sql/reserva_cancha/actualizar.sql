update reserva_cancha
set valorPagado = :valorPagado,
	reservasConsecutivas = :reservasConsecutivas
where idReserva = :idReserva