select idReserva, idUsuario, valorPagado, fechaDeJuego, capacidadCancha, pagoCompletado
from reserva_cancha where idReserva = :idReserva