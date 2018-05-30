
DELIMITER //

DROP PROCEDURE IF EXISTS anadirUsuario;

CREATE PROCEDURE anadirUsuario(IN nom varchar(15), IN contra varchar(30), IN ran int)
    BEGIN
        INSERT INTO Usuario (Nombre, Contrasena, Rango) VALUES(nom, contra, ran);
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
DROP PROCEDURE IF EXISTS eleminarUsuario;

CREATE PROCEDURE eleminarUsuario(IN idIn int)
    BEGIN
        DELETE FROM Usuario WHERE id_usu=idIn;
    END 
//
DELIMITER //
DROP FUNCTION IF EXISTS verificarUsuario; 
CREATE FUNCTION verificarUsuario(nomIn varchar(15), contraIn varchar(30)) RETURNS BIT
    BEGIN
        DECLARE contraBD varchar(30);
        SET contraBD := (SELECT Contrasena FROM Usuario WHERE nomIn=Nombre);
        IF contraBD = contraIn THEN
            RETURN 1;
        ELSE
            RETURN 0;
        END IF;
    END
//
DELIMITER //
DROP PROCEDURE IF EXISTS getUsuarioSesion;

CREATE PROCEDURE getUsuarioSesion(IN nomIn varchar(15), IN contraIn varchar(30))
    BEGIN
        SELECT * FROM Usuario WHERE id_usu = (SELECT id_usu FROM Usuario WHERE Nombre=nomIn);
    END 
//
DELIMITER //
DROP PROCEDURE IF EXISTS getAllUsuario;
CREATE PROCEDURE getAllUsuario()
    BEGIN
        SELECT * FROM Usuario;
    END //
DELIMITER ;