DROP DATABASE RESENAS;
CREATE DATABASE IF NOT EXISTS RESENAS;
USE RESENAS;

-- Creación de las tablas

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

CREATE TABLE Resena (
    IDResena VARCHAR(255) PRIMARY KEY,
    FechaPublicada DATE NOT NULL,
    Puntuacion INT NOT NULL,
    Contenido TEXT NOT NULL,
    IDLibro VARCHAR(255) NOT NULL,
    IDUsuario VARCHAR(255) NOT NULL,
    FOREIGN KEY (IDLibro) REFERENCES Libro(IDLibro),
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

CREATE TABLE Foro (
    IDForo VARCHAR(255) PRIMARY KEY,
    Opcion VARCHAR(255) NOT NULL,
    Foto BLOB NOT NULL,
    Descripcion TEXT NOT NULL
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
    IDFoto VARCHAR(255) NOT NULL,
    FechaAgregar DATE NOT NULL
);



CREATE TABLE REDSOCIAL(
	IDRed VARCHAR(255) PRIMARY KEY, 
    URL VARCHAR(255),
    IDUsuario VARCHAR(255) NOT NULL,    
    foreign key (IDUsuario) references Usuario(IDUsuario)
);

-- Insertar generos de novela, cuento, poesia, memoria, romance, teatro, ciencia ficcion y no ficcion
INSERT INTO Genero (IDGenero, Nombre, Descripcion) VALUES
    (
    'novela', 
    'Novela', 
    'La novela es un género literario extenso y complejo que ha evolucionado a lo largo de los siglos. Se caracteriza por contar historias ficticias o basadas en la realidad, desarrollando tramas complejas que exploran la condición humana, la sociedad y diversos aspectos de la vida. Es una forma de expresión artística que permite a los autores explorar personajes, conflictos y temas de manera profunda.
		Si retrocedemos en el tiempo, podemos observar la contribución de varios autores clave en la definición y desarrollo de la novela. Cervantes, con su obra "Don Quijote de la Mancha", a menudo considerada la primera novela moderna, introdujo elementos como la metaficción y la exploración psicológica de los personajes.
		En el siglo XIX, autores como Charles Dickens con "Grandes esperanzas" o Fiódor Dostoievski con "Crimen y castigo" continuaron expandiendo el alcance de la novela, abordando cuestiones sociales y psicológicas con detalle y profundidad.
		En el siglo XX, vimos la diversificación de estilos y enfoques. Gabriel García Márquez, con "Cien años de soledad", introdujo el realismo mágico, mientras que James Joyce, con "Ulises", experimentó con técnicas narrativas innovadoras.
		En el ámbito de la lingüística computacional, el análisis de textos novelísticos ha sido un campo interesante. Las herramientas computacionales permiten examinar patrones lingüísticos, estructuras narrativas y tendencias temáticas en grandes conjuntos de novelas, proporcionando una perspectiva única sobre la evolución del género a lo largo del tiempo.'
),
	(
	'cuento',
	'Cuento', 
    'En términos generales, un cuento es una narración breve que se enfoca en un incidente específico, con un número limitado de personajes y un desarrollo conciso de la trama. A menudo, está diseñado para capturar la atención del lector desde el principio y transmitir un mensaje o emoción de manera efectiva en un espacio reducido.
	Si exploramos el desarrollo histórico del cuento, encontramos contribuciones notables en diferentes culturas. Los hermanos Grimm, con sus cuentos de hadas como "Cenicienta" o "Blancanieves", marcaron la literatura infantil y popularizaron la forma de cuento como la conocemos hoy.
	En la literatura hispana, autores como Julio Cortázar, con su obra maestra "Bestiario", o Juan Rulfo, con "Luvina", han destacado por su habilidad para construir mundos intensos y evocadores en el formato breve del cuento.
	La estructura del cuento a menudo incluye elementos como la introducción, el desarrollo del conflicto y la resolución, todo dentro de un marco limitado. Esto exige a los autores una economía de palabras y una precisión narrativa para transmitir su mensaje de manera efectiva.
	Desde la perspectiva de la lingüística computacional, el análisis de cuentos puede revelar patrones narrativos, temas recurrentes y técnicas literarias específicas que contribuyen al impacto emocional y cognitivo de la obra.'
),
	(
    'poesia', 
    'Poesía', 
    'En términos generales, la poesía se caracteriza por su estructura métrica, ritmo y uso especial del lenguaje. A menudo, los poetas recurren a la metáfora, la simbolización y la musicalidad del lenguaje para transmitir sus mensajes de manera más evocadora y sugerente.
	Desde los sonetos de William Shakespeare hasta los versos libres de Walt Whitman, la poesía ha evolucionado a lo largo de los siglos y ha sido utilizada para explorar una amplia gama de temas, desde el amor y la naturaleza hasta la crítica social y la introspección filosófica.
	En la literatura hispana, grandes poetas como Federico García Lorca, Pablo Neruda y Octavio Paz han dejado una huella imborrable. Lorca, con su poesía surrealista y lírica, Neruda, con su intensidad emotiva y política, y Paz, con su profundidad filosófica, han enriquecido el panorama poético en español.
	La poesía contemporánea también ha experimentado con nuevas formas y enfoques, incorporando voces diversas y desafiando las convenciones establecidas. La lingüística computacional también ha permitido analizar patrones y tendencias en la poesía, revelando conexiones y variaciones a lo largo del tiempo.'
),
	(
    'memoria', 
    'Memoria', 
    'En la literatura de memoria, los autores exploran eventos y momentos significativos de sus propias vidas, compartiendo sus pensamientos, emociones y perspectivas. Estas obras a menudo abarcan desde la infancia hasta la adultez, y pueden centrarse en temas como el crecimiento personal, la identidad, las relaciones familiares, las experiencias culturales y sociales, entre otros.
	Algunos ejemplos clásicos de literatura de memoria incluyen "Las Confesiones" de San Agustín, que es considerada una de las primeras autobiografías, y "Memorias de Adriano" de Marguerite Yourcenar, que adopta la voz del emperador romano Adriano.
	En el ámbito de la literatura hispana, podríamos mencionar "Vivir para contarla" de Gabriel García Márquez, donde el autor colombiano comparte sus experiencias de infancia y juventud, o "Palinuro de México" de Fernando del Paso, una obra que mezcla la autobiografía con elementos surrealistas.
	Este género literario es poderoso porque permite a los lectores conectarse personalmente con las experiencias del autor, ofreciendo una ventana a la vida y perspectivas individuales. '
),
	(
    'romance', 
    'Romance', 
    'El género del romance es una expresión literaria que se centra en las relaciones amorosas y la búsqueda del amor, explorando las complejidades emocionales y las vicisitudes del corazón humano. Las tramas románticas son el núcleo de estas historias, con conflictos y obstáculos que los personajes deben superar para alcanzar la felicidad romántica. El desarrollo de personajes, especialmente en términos de sus sentimientos y relaciones, es fundamental, y a menudo, las historias se desarrollan en entornos que realzan el ambiente romántico.
	Dentro del romance, encontramos diversos subgéneros. El romance histórico se sitúa en el pasado, a menudo con detalles históricos precisos, mientras que el romance contemporáneo refleja las relaciones modernas. El romance paranormal incorpora elementos sobrenaturales o fantásticos, y el romance de época se ambienta en períodos específicos del pasado, destacando las costumbres de la época.
	Grandes autores del romance han dejado una marca indeleble en la literatura. Jane Austen, con "Orgullo y prejuicio", es una autora clásica, mientras que Nicholas Sparks, con novelas emotivas como "El cuaderno de Noah", ha conquistado a muchos lectores contemporáneos. Julia Quinn, conocida por la serie "Bridgerton", es otra figura destacada en el género.'
),
	(
    'teatro', 
    'Teatro', 
    ' El género de dramaturgia o teatro ha sido abordado por diversos autores a lo largo de la historia, proporcionando perspectivas enriquecedoras sobre sus características y propósitos. Aristóteles, en su "Poética", considera al teatro como una imitación de la realidad que purga las emociones a través de la catarsis. Para él, la tragedia y la comedia son las dos formas fundamentales, destacando la importancia de la trama, el carácter y el lenguaje.
	En contraste, Bertolt Brecht, influyente dramaturgo alemán, propuso un enfoque épico en el teatro, buscando la alienación del espectador para que este reflexione críticamente sobre los problemas sociales. Brecht abogó por la separación entre el actor y el personaje, utilizando técnicas como la ruptura de la cuarta pared.
	Otro punto de vista relevante es el de Anton Chéjov, quien introdujo el realismo psicológico en la dramaturgia. Chéjov se centra en la vida cotidiana y los detalles mundanos para retratar la complejidad emocional de los personajes. Su obra "La Gaviota" es un ejemplo de cómo exploró la insatisfacción y las relaciones humanas con un tono melancólico.
	En el siglo XX, el teatro del absurdo, representado por autores como Samuel Beckett, cuestionó la lógica convencional y la comunicación en un mundo aparentemente sin sentido. Obras como "Esperando a Godot" desafían las convenciones tradicionales y exploran la absurda naturaleza de la existencia humana.'
),
	(
	'ciencia_ficcion', 
    'Ciencia Ficción', 
    'El género de ciencia ficción es una forma de literatura que imagina posibles escenarios futuros o alternativos basados en el conocimiento científico y tecnológico. La ciencia ficción explora las implicaciones de los avances científicos o sociales en la vida humana, así como los dilemas éticos, morales o filosóficos que puedan surgir. La ciencia ficción se diferencia de otros géneros fantásticos en que sus argumentos se sustentan en una lógica racional y verosímil, aunque no necesariamente realista.
	La ciencia ficción se originó en el siglo XX, como una forma de expresar las inquietudes y expectativas de una época marcada por el progreso científico y tecnológico. Algunos de los autores pioneros del género fueron Julio Verne, H. G. Wells y Mary Shelley. La ciencia ficción alcanzó su mayor popularidad en la segunda mitad del siglo XX, con autores como Isaac Asimov, Arthur C. Clarke y Ray Bradbury, y se extendió a otros medios como el cine, el cómic y los videojuegos.
	La ciencia ficción abarca una gran variedad de temas, como los viajes espaciales, los encuentros con extraterrestres, los viajes en el tiempo, las realidades virtuales, las inteligencias artificiales, las distopías, las utopías, las mutaciones, el apocalipsis, etc. La ciencia ficción se puede clasificar en dos grandes vertientes: la ciencia ficción dura y la ciencia ficción blanda. La ciencia ficción dura es aquella que se basa en un rigor científico y tecnológico, mientras que la ciencia ficción blanda es aquella que se centra más en los aspectos sociales, culturales o psicológicos de la ficción. Dentro de la ciencia ficción también existen otros subgéneros con características propias, como el cyberpunk, el steampunk, el biopunk, el retrofuturismo, etc.
	La ciencia ficción, además de entretener y estimular la imaginación, también tiene una función crítica y reflexiva sobre la realidad actual y las posibilidades del futuro. La ciencia ficción plantea cuestiones sobre el papel de la ciencia y la tecnología en la sociedad, los límites éticos y morales de la investigación, las consecuencias de la intervención humana en el medio ambiente, los conflictos entre diferentes culturas o civilizaciones, los derechos y deberes de los seres humanos y de otras formas de vida, etc. La ciencia ficción, en definitiva, es una forma de explorar el mundo y de cuestionar nuestra propia existencia.
	'
),
	(
	'no_ficcion', 
    'No Ficción', 
    ' En el ámbito del género de no ficción, diversos autores han aportado sus visiones a lo largo del tiempo, ofreciendo enfoques distintos sobre cómo se aborda la representación de la realidad. Tomemos, por ejemplo, a Truman Capote, cuya obra "A Sangre Fría" marcó el surgimiento del "nuevo periodismo". Capote fusionó elementos literarios con la investigación periodística, narrando un crimen real de manera novelada y detallada.
	En contraste, el periodista y escritor George Orwell, famoso por "1984" y "Rebelión en la Granja", contribuyó al género de no ficción con su obra "En el Camino a Wigan Pier". En este libro, Orwell utiliza la observación directa y la participación en la vida de los mineros para analizar las condiciones sociales y económicas de la época, combinando el reportaje con elementos ensayísticos.
	Susan Sontag, por otro lado, exploró la crítica cultural y la interpretación de la realidad en ensayos como "Sobre la Fotografía". Sontag examina cómo la fotografía influye en nuestra percepción de la realidad, planteando preguntas filosóficas sobre la verdad y la representación visual.
	En el siglo XXI, autores como Malcolm Gladwell han popularizado el formato del ensayo narrativo con obras como "Fueras de Serie", donde combina datos y anécdotas para explorar patrones socioculturales. Gladwell busca explicar fenómenos complejos de manera accesible y atractiva.'
),
	(
	'ensayo', 
    'Ensayo', 
    'El ensayo es un género literario que se distingue por su carácter reflexivo y analítico sobre diversos temas. En contraste con formas de escritura más rígidas, el ensayo brinda a los autores una libertad considerable para expresar sus opiniones, ideas y puntos de vista de manera subjetiva. 
	Este género literario no se limita a estructuras fijas y permite una variedad temática que abarca desde cuestiones filosóficas y sociales hasta experiencias personales. La flexibilidad en su estructura, combinada con la libertad de estilo, otorga a cada ensayo una marca distintiva y única, reflejando la voz y la perspectiva del autor. 
    A través de la reflexión profunda y el análisis crítico, el ensayo invita al lector a explorar nuevas ideas y perspectivas, contribuyendo así al diálogo intelectual y a la comprensión más profunda de diversos temas. 
    La claridad en la expresión y la coherencia en la argumentación son valores importantes que caracterizan a un buen ensayo, que busca comunicar de manera efectiva las reflexiones del autor.
    '
);

-- Verificar que los datos se hayan insertado correctamente
USE RESENAS;

SELECT * FROM informacionpersonal;
SELECT * FROM usuario;
SELECT * FROM generosusuario;
SELECT * FROM genero;
SELECT * FROM Lista;
SELECT * FROM Libro;

select * from IMAGENPERFIL;