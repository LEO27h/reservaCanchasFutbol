insert into usuario(nombre,clave,fecha_creacion) values('test','1234',now());

insert into reserva_cancha (idUsuario, valorPagado, fechaDeJuego, capacidadCancha, pagoCompletado)
values (1, 75000D, now(), 'cancha futbol ocho', 'N');