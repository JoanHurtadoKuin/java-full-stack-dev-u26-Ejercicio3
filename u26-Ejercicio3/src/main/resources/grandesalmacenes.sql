drop database if exists grandes_almacenes;
create database if not exists grandes_almacenes;

use grandes_almacenes;

drop table if exists productos;
drop table if exists maquinas_registradoras;
drop table if exists venta;

drop table if exists cajeros;
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

insert into cajeros values(default,"Joan");
insert into maquinas_registradoras values(default,1);
insert into productos values(default,"Producto1",300);
insert into venta values(default,1,1,1);

select * from cajeros;
select * from maquinas_registradoras;
select * from productos;
select * from venta;
