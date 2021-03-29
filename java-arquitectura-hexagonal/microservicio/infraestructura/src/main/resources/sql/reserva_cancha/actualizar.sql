update reserva_cancha
set valorPagado = :valorPagado,
	reservasConsecutivas = :reservasConsecutivas,
    capacidadCancha = :capacidadCancha
where idReserva = :idReserva