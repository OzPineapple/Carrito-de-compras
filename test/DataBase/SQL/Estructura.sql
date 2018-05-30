DROP DATABASE IF EXISTS TiendaDeepWeb;

CREATE DATABASE IF NOT EXISTS TiendaDeepWeb CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci; 

USE TiendaDeepWeb;

CREATE TABLE Usuario(
    id_usu int not null auto_increment,
    Nombre varchar(30) not null,
    Contrasena varchar(30) not null,
    Rango int not null,
    PRIMARY KEY(id_usu),
    UNIQUE (Nombre)
);

CREATE TABLE Producto(
    id_pro int not null auto_increment,
    Nombre varchar(15) not null,
    Descripcion text,
    Precio float(15,2),
    PRIMARY KEY(id_pro)
);

CREATE TABLE Ticket(
    id_tick int not null auto_increment,
    Fecha Date not null,
    ip varchar(15),
    PRIMARY KEY(id_tick)
);
CREATE TABLE DetalleTicket (
  id_Dtick int NOT NULL AUTO_INCREMENT,
  id_pro int NOT NULL,
  Cantidad int NOT NULL,
  id_tick int NOT NULL,
  PRIMARY KEY (id_Dtick),
  FOREIGN KEY (id_pro) REFERENCES Producto(id_pro)
  ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (id_tick) REFERENCES Ticket(id_tick) 
  ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE M_DT(
    id_MDT int not null auto_increment,
    id_tick int not null,
    id_Dtick int not null,
    PRIMARY KEY(id_MDT),
    FOREIGN KEY(id_tick) REFERENCES Ticket(id_tick)
    ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(id_Dtick) REFERENCES DetalleTicket(id_Dtick)
    ON DELETE CASCADE ON UPDATE CASCADE
);

DROP USER IF EXISTS "CajeroDeepWeb"@"localhost";

CREATE USER "CajeroDeepWeb"@"localhost" IDENTIFIED BY 'd33pw33b';

GRANT EXECUTE, SELECT ON TiendaDeepWeb.* TO "CajeroDeepWeb"@"localhost" IDENTIFIED BY 'd33pw33b';

    
 