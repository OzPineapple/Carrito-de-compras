CREATE DATABASE TiendaDeepWeb;

USE TiendaDeepWeb;

CREATE TABLE Usuario(
    id_usu int not null auto_increment,
    Nombre varchar(15) not null,
    Contraseña varchar(15) not null
);

CREATE TABLE Producto(
    id_pro int not null auto_increment,
    Nombre varchar(15) not null,
    Descripción text, 
    Precio float(15,2)
);
