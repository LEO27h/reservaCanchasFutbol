create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table reserva_cancha (
 idReserva BIGINT(11) not null auto_increment,
 idUsuario BIGINT(11) not null,
 valorPagado double(8, 2),
 fechaDeJuego datetime null,
 capacidadCancha varchar(40),
 pagoCompletado varchar(1),
 primary key (idReserva)
);