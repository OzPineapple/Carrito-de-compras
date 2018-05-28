
DELIMITER //

DROP PROCEDURE IF EXISTS anadirUsuario;

CREATE PROCEDURE anadirUsuario(IN nom varchar(15), IN contra varchar(30), IN ran int)
    BEGIN
        INSERT INTO Usuarios (Nombre, Contrasena, Rango) VALUES(nom, contra, ran);
    END 
//
DELIMITER //
DROP PROCEDURE IF EXISTS actualizarUsuario;

CREATE PROCEDURE actualizarUsuario(IN id int, IN nom varchar(15), IN contra varchar(30), IN ran int)
    BEGIN
        UPDATE Usuario SET Nombre=nom, Contrasena=contra, Rango=ran WHERE id=id_usu;
    END 
//

DELIMITER //
DROP PROCEDURE IF EXISTS eliminarUsuario;

CREATE PROCEDURE eleminarUsuario(IN idIn int)
    BEGIN
        DELETE FROM Usuario WHERE id_usu=idIn;
    END 
//

DELIMITER //
DROP PROCEDURE IF EXISTS getUsuario;

CREATE PROCEDURE getUsuarioSesion(IN nomIn varchar(15), IN contraIn varchar(30), OUT id int, OUT nom varchar(30), OUT contra varchar(15), OUT ran int)
    BEGIN
        DECLARE contraBD varchar(30);
        SET contraBD := (SELECT Contrasena FROM Usuario WHERE nomIn=Nombre);
        IF contraBD = contraIn THEN
            SET id := (SELECT id_usu FROM Usuario WHERE nom=Nombre);
            SET nom := (SELECT Nombre FROM Usuario WHERE id=id_usu);
            SET contra := (SELECT Contrasena FROM Usuario WHERE id=id_usu);
            SET ran := (SELECT Rango FROM Usuario WHERE id=id_usu);
        END IF;
    END 
//
DELIMITER //
DROP PROCEDURE IF EXISTS getAllUsuario;
CREATE PROCEDURE getAllUsuario()
    BEGIN
        SELECT * FROM Usuario;
    END //
DELIMITER ;