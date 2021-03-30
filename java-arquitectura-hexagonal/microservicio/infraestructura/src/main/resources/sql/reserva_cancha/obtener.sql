select idReserva, idUsuario, valorPagado, fechaDeJuego, reservasConsecutivas, capacidadCancha
from reserva_cancha where idReserva = :idReserva