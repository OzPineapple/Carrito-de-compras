DROP PROCEDURE IF EXISTS añadirUsuario;

CREATE PROCEDURE añadirUsuario(IN nom, IN contra)
    BEGIN
        INSERT INTO Usuarios (Nombre, Contraseña) VALUES(nom, contra);
    END

DROP PROCEDURE IF EXISTS actualizarUsuario;

CREATE PROCEDURE actualizarUsuario(IN id, IN nom, IN contra)
    BEGIN
        UPDATE Usuario SET Nombre=nom, Contraseña=contra WHERE id=id_usu;
    END

DROP PROCEDURE IF EXISTS eliminarUsuario;

CREATE PROCEDURE eleminarUsuario(IN id)
    BEGIN
        
    