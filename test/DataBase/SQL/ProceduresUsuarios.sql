
DROP PROCEDURE IF EXISTS añadirUsuario;

CREATE PROCEDURE añadirUsuario(IN nom varchar(15), IN contra varchar(30), IN ran int)
    BEGIN
        INSERT INTO Usuarios (Nombre, Contraseña, Rango) VALUES(nom, contra, ran);
    END

DROP PROCEDURE IF EXISTS actualizarUsuario;

CREATE PROCEDURE actualizarUsuario(IN id int, IN nom varchar(15), IN contra varchar(30), IN ran int)
    BEGIN
        UPDATE Usuario SET Nombre=nom, Contraseña=contra, Rango=ran WHERE id=id_usu;
    END

DROP PROCEDURE IF EXISTS eliminarUsuario;

CREATE PROCEDURE eleminarUsuario(IN id int)
    BEGIN
        DELETE Usuario WHERE id=id_usu;
    END

DROP PROCEDURE IF EXISTS getUsuario;

CREATE PROCEDURE getUsuarioSesion(IN nom varchar(15), IN contra varchar(30), OUT @id int, OUT @nom varchar(30), OUT @contra varchar(15), OUT @ran int)
    BEGIN
        DECLARE contraBD varchar(30) = SELECT Contraseña FROM Usuario WHERE nom=Nombre;
        IF contraBD == contra
            @id = SELECT id_usu FROM Usuario WHERE nom=Nombre;
            @nom = SELECT Nombre FROM Usuario WHERE @id=id_usu;
            @contra = SELECT Contraseña FROM Usuario WHERE @id=id_usu;
            @ran = SELECT Rango FROM Usuario WHERE @id=id_usu;
        ELSE
            @id = 0;
            @nom = "null";
            @contra = "null";
            @ran = 0;
        END IF
    END

CREATE PROCEDURE getAllUsuario()
    BEGIN
        SELECT * FROM Usuario;
    END