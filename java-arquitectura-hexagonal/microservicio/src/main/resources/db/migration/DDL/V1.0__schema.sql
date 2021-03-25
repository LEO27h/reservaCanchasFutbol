create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table reserva_cancha (
 id_reserva int(11) not null auto_increment,
 id_usuario int(11) not null,
 valor_pagado double(6, 2),
 fecha_partido datetime null,
 reservas_consecutivas int(1),
 capacidad_cancha varchar(40),
 primary key (id_reserva)
);