CREATE DATABASE sag;
USE sag;
CREATE TABLE hatos(
    idHato int(10) NOT NULL PRIMARY KEY, 
    arete varchar(100) NOT NULL, 
    idRaza int(10) NOT NULL, 
    idLote int(10) NOT NULL, 
    idRancho int(10) NOT NULL, 
    sexo varchar(1) NOT NULL, 
    idEstatus int(10) NOT NULL,
    descripcionHato varchar(150) NOT NULL,
    idUsuarioAlta int(10) NOT NULL, 
    fechaAlta date NOT NULL, 
    idUsuarioEditor int(10) NOT NULL,
    fechaEdicion date NOT NULL,
    fechaBaja date NOT NULL,
    varchar motivoBaja NOT NULL,
    FOREIGN KEY (idLote) REFERENCES lote(idLote),
    FOREIGN KEY (idRancho) REFERENCES rancho(idRancho),
    FOREIGN KEY (idUsuarioAlta) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idUsuarioEditor) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idEstatus) REFERENCES catalogo(idCatalogo));

CREATE TABLE cria(
    idCria int(10) PRIMARY KEY NOT NULL, 
    idHatoMadre int(10) NOT NULL, 
    sexo int(10) NOT NULL, 
    fechaNacimiento date NOT NULL, 
    idRaza int(10) NOT NULL, 
    idEstatus int(10) NOT NULL, 
    observaciones varchar(250),
    idUsuarioAlta int(10) NOT NULL, 
    fechaAlta date NOT NULL, 
    idUsuarioEditor int(10) NOT NULL,
    fechaEdicion date NOT NULL,
    fechaBaja date NOT NULL,
    FOREIGN KEY (idHatoMadre) REFERENCES hatos(idHato),
    FOREIGN KEY (idEstatus) REFERENCES ,
    FOREIGN KEY (idUsuarioAlta) REFERENCES usuarios(idUsuario));

CREATE TABLE consulta(
    idConsulta int(10) PRIMARY KEY NOT NULL,
    idHatoTratado int(10) NOT NULL,
    veterinario varchar(100) NOT NULL, 
    fechaAtencion date NOT NULL, 
    observaciones varchar(250), 
    motivoAtencion varchar(250) NOT NULL,
    FOREIGN KEY (idHatoTratado) REFERENCES hatos(idHato));

CREATE TABLE lote(
    idLote int(10) PRIMARY KEY NOT NULL, 
    nombre varchar(150) NOT NULL, 
    descripcion varchar(200) NOT NULL, 
    idEstatus int(10) NOT NULL,
    idRancho int(10) NOT NULL,
    idUsuarioAlta int(10) NOT NULL,
    fechaAlta date NOT NULL,
    idUsuarioEditor int(10),
    fechaEdicion date,
    FOREIGN KEY (idEstatus) REFERENCES catalogo(idCatalogo),
    FOREIGN KEY (idRancho) REFERENCES rancho(idRancho),
    FOREIGN KEY (idUsuarioAlta) REFERENCES usuarios(idUsuario));

CREATE TABLE rancho(
    idRancho int(10) NOT NULL AUTO_INCREMENT, 
    nombre varchar(50) NOT NULL,
    dirección  varchar(150) NOT NULL, 
    encargado varchar(150) NOT NULL,
    idUsuarioAlta int(10) NOT NULL,
    fechaAlta date NOT NULL,
    idUsuarioEditor int(10),
    fechaEdicion date);

create table traspasos(
idTraspaso int(10) not null auto_increment primary key,
idLoteAnterior int(10) not null,
idLoteDestino int(10) not null,
fechaCancelacion date not null,
motivoCancelacion varchar(250) not null,
idRancho int(10) not null,
idUsuarioAlta int(10) not null,
fechaAlta date not null,
idUsuarioEditor int(10) not null,
fechaEdicion date not null,
foreign key (idLoteAnterior) references lote(idLote),
foreign key (idLoteDestino) references lote(idLote),
foreign key (idRancho) references rancho(idRancho),
foreign key (idUsuarioAlta) references usuarios(idUsuario),
foreign key (idUsuarioEditor) references usuarios(idUsuario)
);

CREATE TABLE usuarios(
    idUsuario int(10) AUTO_INCREMENT NOT NULL PRIMARY KEY,
    nombre varchar(150) NOT NULL,
    apellidoPaterno varchar(150) NOT NULL,
    apellidoMaterno varchar(150) NOT NULL,
    celular varchar(10) NOT NULL,
    usuario varchar(50) NOT NULL,
    contrasena varchar(200) NOT NULL,
    idRol int(10) NOT NULL,
    idEstatus int(10) NOT NULL,
    idRancho int(10) NOT NULL,
    idUsuarioAlta int(10) NOT NULL,
    fechaAlta date NOT NULL,
    idUsuarioEditor int(10),
    fechaEdicion date),
    FOREIGN KEY (idRol) REFERENCES catalogo(idCatalogo),
    FOREIGN KEY (idEstatus) REFERENCES catalogo(idCatalogo),
    FOREIGN KEY (idRancho) REFERENCES rancho(idRancho),
    FOREIGN KEY (idUsuarioAlta) REFERENCES usuarios(idUsuario),
    FOREIGN KEY (idUsuarioEditor) REFERENCES usuarios(idUsuario);

CREATE TABLE catalogo(
    idCatalogo int(10) PRIMARY KEY NOT NULL, 
    idCategoria int(10), 
    nombre varchar(100) NOT NULL, 
    activo char(255) NOT NULL,
    PRIMARY KEY(idCatalogo), 
    FOREIGN KEY (idCategoria)  REFERENCES catalogo(idCatalogo));

INSERT INTO usuarios (
idUsuario, nombre, apellidoPaterno, apellidoMaterno, celular, usuario, contrasena, idRol, idEstatus, idRancho, idUsuarioAlta, fechaAlta, idUsuarioEditor, fechaEdicion) 
VALUES (0, "Yadelí", "López", "Puntualidad", "2961192001", "yayis", "yayis", 201, 101, 1, 1, "2023-05-07", null, null)
(0, "Evelyn", "López", "Aguilar", "2961067823", "eve", "eve", 202, 101, 1, 1, "2023-05-07", null, null)
(0, "Marco", "Ferrer", "Estevez", "2283914579", "marco", "marco", 201, 101, 1, 1, "2023-05-08", null, null)
(0, "Fernando", "Cruz", "Olivarez", "2273018721", "fernando", "fernando", 202, 101, 1, 2, "2023-05-07", null, null)
(0, "Barbara", "Millicent", "Roberts", "2961192001", "yayis", "yayis", 201, 101, 1, 1, "2023-05-07", null, null);

insert into catalogo(idCatalogo, idCategoria, nombre, activo) 
values
(1, null, "Estatus actividad", "S"),
(2, null, "Rol de sistema", "S"),
(3, null, "Raza", "S"),
(101, 1, "Activo", "S"),
(102, 1, "Inactivo", "S"),
(201, 2, "Administrador", "S"),
(202, 2, "Ganadero", "S"),
(301, 3, "Simmental", "S"),
(301, 3, "Brangus", "S"),
(301, 3, "Limousin", "S"),
(301, 3, "Belgian Blue", "S"),
(301, 3, "Nelore", "S"),
(301, 3, "Romagnola", "S"),
(301, 3, "Marchigiana", "S"),
(301, 3, "Holstein", "S");

Procedimientos almacenados:
