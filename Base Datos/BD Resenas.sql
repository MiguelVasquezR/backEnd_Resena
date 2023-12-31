DROP DATABASE RESENAS;
CREATE DATABASE IF NOT EXISTS RESENAS;
USE RESENAS;

CREATE TABLE InformacionPersonal (
    ID VARCHAR(255) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    ApellidoPaterno VARCHAR(100) NOT NULL,
    ApellidoMaterno VARCHAR(100) NOT NULL,
    FechaNacimiento DATE NOT NULL,
    FechaDeceso DATE,
    Biografia TEXT
);

CREATE TABLE IMAGENPERFIL(
	ID VARCHAR(255) PRIMARY KEY,
    NOMBRE VARCHAR(255),
    IMAGEN LONGBLOB
);

CREATE TABLE IMAGEAUTOR(
	ID VARCHAR(255) PRIMARY KEY,
    NOMBRE VARCHAR(255),
    IMAGEN LONGBLOB
);

CREATE TABLE Usuario (
    IDUsuario VARCHAR(255) PRIMARY KEY,
    NombreUsuario VARCHAR(100) NOT NULL,
    Correo VARCHAR(255) NOT NULL,
    Contrasena VARCHAR(100) NOT NULL,
    IDPersona VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDPersona) REFERENCES InformacionPersonal(ID),
    FOTO VARCHAR(255), 
    FOREIGN KEY (FOTO) REFERENCES IMAGENPERFIL(ID)
);

CREATE TABLE Genero (
    IDGenero VARCHAR(255) PRIMARY KEY,
    Nombre VARCHAR(100) NOT NULL,
    Descripcion TEXT NOT NULL
);

CREATE TABLE GenerosUsuario(
	ID VARCHAR(255) PRIMARY KEY, 
    IDUsuario VARCHAR(255),
    IDGenero VARCHAR(255),
    FOREIGN KEY (IDUsuario) REFERENCES Usuario (IDUsuario),
    FOREIGN KEY (IDGenero) REFERENCES Genero (IDGenero)
);

CREATE TABLE Autor (
    IDAutor VARCHAR(255) PRIMARY KEY,
    Nacionalidad VARCHAR(100) NOT NULL,
    IDPersona VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDPersona) REFERENCES InformacionPersonal(ID)
);

CREATE TABLE Libro (
    IDLibro VARCHAR(255) PRIMARY KEY,
    Titulo VARCHAR(100) NOT NULL,
    Foto VARCHAR(255) NOT NULL,
    NumPag INT,
    FechaPublicacion DATE NOT NULL,
    Idioma VARCHAR(100) NOT NULL,
    Editorial VARCHAR(255) NOT NULL,
    IDAutor VARCHAR(255) NOT NULL,
    IDGenero VARCHAR(255) NOT NULL,    
    FOREIGN KEY (IDAutor) REFERENCES Autor(IDAutor),
    FOREIGN KEY (IDGenero) REFERENCES Genero(IDGenero)
);

CREATE TABLE GenerosPublicados (
    IDGeneroPublicado VARCHAR(255) PRIMARY KEY,
    IDGenero VARCHAR(255) NOT NULL,
    IDAutor VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDGenero) REFERENCES Genero(IDGenero),
    FOREIGN KEY (IDAutor) REFERENCES Autor(IDAutor)
);

CREATE TABLE Resena(
	IDResena VARCHAR(255) PRIMARY KEY,
    FechaPublicada DATE NOT NULL,
    Puntuacion INT NOT NULL,
    Contenido TEXT NOT NULL,
    NombreLibro VARCHAR(255) NOT NULL,
    NombreAutor VARCHAR(255) NOT NULL,
    Idioma VARCHAR(255) NOT NULL,
    Editorial VARCHAR(255) NOT NULL,
    FotoID VARCHAR(255) NOT NULL,
	IDUsuario VARCHAR(255) NOT NULL,
	FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario)
);

CREATE TABLE Lista (
    IDLista VARCHAR(255) PRIMARY KEY,
    CantidadLibros INT NOT NULL,
    Privacidad VARCHAR(255) NOT NULL,    
    Nombre VARCHAR(255) NOT NULL,
    Descripcion TEXT NOT NULL,    
    IDUsuario VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario),
    FOTO VARCHAR(255), 
    FOREIGN KEY (FOTO) REFERENCES IMAGENPERFIL(ID)
);

CREATE TABLE Comentario (
    IDComentario VARCHAR(255) PRIMARY KEY,
    Contenido TEXT NOT NULL,
    FechaCreacion DATE NOT NULL,
    IDUsuario VARCHAR(255) NOT NULL,
    IDResena VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario),
    FOREIGN KEY (IDResena) REFERENCES Resena(IDResena)
);

CREATE TABLE foro (
  IDForo varchar(255) PRIMARY KEY NOT NULL,
  Opcion varchar(255) NOT NULL,
  Descripcion text NOT NULL,  
  Nombre varchar(255) DEFAULT NULL,  
  IDFoto varchar(255),
  IDUsuario varchar(255) Not NULL,
  FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario)
);

CREATE TABLE Notificacion (
    IDNotificacion VARCHAR(255) PRIMARY KEY,
    Contenido TEXT NOT NULL,
    Foto BLOB NOT NULL,
    IDUsuarioDestino VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDUsuarioDestino) REFERENCES Usuario(IDUsuario)
);

CREATE TABLE Reacciones (
    IDReaccion VARCHAR(255) PRIMARY KEY,
    FechaReaccion DATE NOT NULL,
    TipoReaccion VARCHAR(255) NOT NULL,
    IDUsuario VARCHAR(255) NOT NULL,
    IDResena VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario),
    FOREIGN KEY (IDResena) REFERENCES Resena(IDResena)
);

CREATE TABLE LibroEnLista (
    IDLibroLista VARCHAR(255) PRIMARY KEY,
    IDLista VARCHAR(255) NOT NULL,
    IDLibro VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDLista) REFERENCES Lista(IDLista),
    FOREIGN KEY (IDLibro) REFERENCES Libro(IDLibro)
);

CREATE TABLE ParticipanteForo (
    IDParticipanteForo VARCHAR(255) PRIMARY KEY,
    IDUsuario VARCHAR(255) NOT NULL,
    IDForo VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDUsuario) REFERENCES Usuario(IDUsuario),
    FOREIGN KEY (IDForo) REFERENCES foro(IDForo)
);

CREATE TABLE publicacion (
  Comentario varchar(255) DEFAULT NULL,
  ReaccionLike int(11) DEFAULT NULL,
  ReaccionDislike int(11) DEFAULT NULL,
  IDForo varchar(255) DEFAULT NULL,
  IDUsuario varchar(255) DEFAULT NULL
);

CREATE TABLE REDSOCIAL(
	IDRed VARCHAR(255) PRIMARY KEY, 
    URL VARCHAR(255),
    IDUsuario VARCHAR(255) NOT NULL,    
    foreign key (IDUsuario) references Usuario(IDUsuario)
);

CREATE TABLE SEGUIDOR(
	IDSeguidor VARCHAR(255) PRIMARY KEY,
    IDUserOrigin VARCHAR(255) NOT NULL,
    IDUserFollow VARCHAR(255) NOT NULL,
    foreign key (IDUserOrigin) references Usuario(IDUsuario),
    foreign key (IDUserFollow) references Usuario(IDUsuario)
);