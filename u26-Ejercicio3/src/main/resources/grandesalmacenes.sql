drop table if exists cajeros;
drop table if exists productos;
drop table if exists maquinas_registradoras;
drop table if exists venta;

create table cajeros(
codigo int auto_increment primary key,
nom_apels varchar(255)
);

create table productos(
codigo int auto_increment primary key,
nombre varchar(100),
precio int
);

drop table if exists maquinas_registradoras;
create table maquinas_registradoras(
codigo int auto_increment primary key,
piso int
);

create table venta(
codigo int auto_increment primary key,
cajero int,
maquina int,
producto int,
Key(cajero),
foreign key(cajero) references cajeros(codigo)
on delete restrict on update cascade,
Key(maquina),
foreign key(maquina) references maquinas_registradoras(codigo)
on delete restrict on update cascade,
Key(producto),
foreign key(producto) references productos(codigo)
on delete restrict on update cascade
);
