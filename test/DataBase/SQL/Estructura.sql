CREATE DATABASE IF EXISTS TiendaDeepWeb; 

USE TiendaDeepWeb;

CREATE TABLE Usuario(
    id_usu int not null auto_increment,
    Nombre varchar(15) not null,
    Contraseña varchar(15) not null,
    PRIMARY KEY(id_usu)
);

CREATE TABLE Producto(
    id_pro int not null auto_increment,
    Nombre varchar(15) not null,
    Descripción text, 
    Precio float(15,2),
    PRIMARY KEY(id_pro)
);

CREATE TABLE Ticket(
    id_tick int not null auto_increment,
    Fecha Date not null,
    ip varchar(15),
    PRIMARY KEY(id_tick)
);

CREATE TABLE DetalleTicket(
    id_Dtick int not null auto_increment,
    id_usu int not null,
    id_pro int not null,
    PRIMARY KEY(id_Dtick),
    FOREIGN KEY(id_usu) REFERENCES Usuario(id_usu)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_pro) REFERENCES Producto(id_pro)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE M_DT(
    id_MDT int not null auto_increment,
    id_tick int not null,
    id_Dtick int not null,
    PRIMARY KEY(id_MDT),
    FOREIGN KEY(id_tick) REFERENCES Ticket(id_tick)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_Dtick) REFERENCES DetalleTick(id_Dtick)
    ON DELETE CASCADE ON UPDATE CASCADE
);
