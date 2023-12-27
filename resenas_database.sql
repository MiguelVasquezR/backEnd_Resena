-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: resenas
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `autor`
--

DROP TABLE IF EXISTS `autor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autor` (
  `IDAutor` varchar(255) NOT NULL,
  `Nacionalidad` varchar(100) NOT NULL,
  `IDPersona` varchar(255) NOT NULL,
  PRIMARY KEY (`IDAutor`),
  KEY `IDPersona` (`IDPersona`),
  CONSTRAINT `autor_ibfk_1` FOREIGN KEY (`IDPersona`) REFERENCES `informacionpersonal` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autor`
--

LOCK TABLES `autor` WRITE;
/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
INSERT INTO `autor` VALUES ('0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38','Chilena','f50f1e5b-031c-4b77-bb91-3703fe6ac4b0'),('078070ae-ba21-4c52-91f3-b4e3a071cd42','Chileno','e4da87b2-890d-4b0a-979f-b679a35dd60f'),('0cb152c2-c8b7-4c80-99b5-2821ef5f77c8','Británica','e1cda7a5-7ea5-460a-845e-e968b47f50e0'),('3c7a888d-e199-4012-aac6-bf33a13e5e9b','Nigeriano','8e5bf10b-b540-47c1-974c-59b10190d06e'),('55d4d6a5-6325-4e0f-b241-c7f8997ce14e','Peruano','bfb3fe7b-fa6f-44f8-b349-21d781d3a00a'),('5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4','Mexicana','eb8df5aa-1ad8-42b9-9da0-1271dbd8c687'),('6b87be42-4988-4c5d-82cf-2b9e9f1200fb','Estadounidense','944be3e7-b26b-4c01-a689-e3b21f40ef67'),('7a9c8b14-682b-4ee1-8e90-50c554ce04c8','Mexicano','9d202fc3-b9fc-4d23-b0ce-442f59840d62'),('81a4c7a7-58d9-4ff7-986f-725a9e95020d','Español','a5df92dd-2a3a-46b5-8329-ef189f75a00f'),('8a20f7d8-2f47-44aa-9e91-f5ac54f54594','Estadounidense-China','bebc3b67-60a3-47d8-9db6-14e1ec08ed6d'),('8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222','Argentina','c19a3db4-e794-4ef1-b6ab-fd0d881dbf27'),('8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899','Checo-Alemán','ab20155b-27a3-4e42-a0c3-8f80b5b3f9e1'),('9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d','Colombiano','18fdadbc-8b61-4d52-9b22-991a8f5e5c6d'),('9d2140b1-51e0-4c62-87e5-cc2079a2802e','Británica','621e9ac6-b9db-41b4-a400-bf4885d5a597'),('a0cb4a55-5b24-4e65-b485-0c0418e0f781','Mexicana','ee07b079-8c69-417a-b692-1b8bb601bc45'),('a1d575ed-67ea-40c7-b579-005d3d4f9a1c','Italiano','23ef7676-1b1e-4a02-8c67-9f82c5d7e87c'),('af38439b-992f-40c1-b471-96f8d9d36c1a','Argentina','87193eb0-2ba0-4590-b37b-64db8e1c1266'),('b85e4cd7-f603-4b6f-a008-b0806a6d5f1c','Estadounidense','32f3f61a-0e1a-4f8f-aa3f-4704fe93f4fe'),('c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19','Chilena','3d180295-65c5-498e-bda9-4a2e1e2b39a7'),('cdfea0g1-s1a9-3a5c-b8a6-ae12eda90','Peruano','cd1ea9g8-s9a7-4a6c-b7a5-ae01eda88'),('e057865e-6a64-4324-9da1-dc8b42e27a2d','Mexicano','a8b77552-50e2-4a4d-86b3-1b062799e6b4'),('f4dd2d87-6121-46e7-8da2-6f8716e0b72b','Español','9f4bf65e-e10d-460c-bbc5-903d1ec660ed'),('f7dd37f4-18b1-4c85-b3ce-d9e7b117cb0d','Argentino','4e1ad4ed-5f80-4c3f-9c68-47c7c7330a50'),('f8485361-4d88-4935-ba76-55f3da2a7db4','Alemana','c80c4ea6-c20a-4b18-9f90-d3035d1a154c'),('fce5f648-ff97-44d9-aa5b-44d3e982f7ad','Argentino','7b79dd31-5cfc-4aef-9edc-6c7da5706e7f'),('fd52a226-88a8-44f2-8f5c-5316bf90e7f4','Brasileño','3b84b6e9-dc99-4a06-b9ea-5a692a416ec0'),('ffddc101-4f0e-43f8-aa5b-8c68390a6b3a','Mexicano','cd1e1186-7a7e-4a6c-b7a5-ae01eaff437e');
/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentario`
--

DROP TABLE IF EXISTS `comentario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comentario` (
  `IDComentario` varchar(255) NOT NULL,
  `Contenido` text NOT NULL,
  `FechaCreacion` date NOT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  `IDResena` varchar(255) NOT NULL,
  PRIMARY KEY (`IDComentario`),
  KEY `IDUsuario` (`IDUsuario`),
  KEY `IDResena` (`IDResena`),
  CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`),
  CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`IDResena`) REFERENCES `resena` (`IDResena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentario`
--

LOCK TABLES `comentario` WRITE;
/*!40000 ALTER TABLE `comentario` DISABLE KEYS */;
/*!40000 ALTER TABLE `comentario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foro`
--

DROP TABLE IF EXISTS `foro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `foro` (
  `IDForo` varchar(255) NOT NULL,
  `Opcion` varchar(255) NOT NULL,
  `Descripcion` text NOT NULL,
  `IDUsuario` varchar(255) DEFAULT NULL,
  `Nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDForo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foro`
--

LOCK TABLES `foro` WRITE;
/*!40000 ALTER TABLE `foro` DISABLE KEYS */;
INSERT INTO `foro` VALUES ('13c79dff-00c0-44f9-be5b-3e2d6581347c','Autor','test',NULL,'test'),('250ffea1-d8bd-4769-a14a-c317b4519632','Libro','descrcipcion',NULL,'Don quijote'),('76e60017-a94f-4b75-b36f-34fec19a211a','Autor','Desciprcion',NULL,'Miguel de Cervantes'),('ad85232a-cce7-4948-8c83-67e8b5f7ffe8','Libro','test3',NULL,'test3'),('b3bc6ee6-5f36-46ff-9d08-47474609e0ae','Genero','test2',NULL,'test2'),('f3dcee3c-6b52-44ba-911f-404f40d081b8','Autor','testV',NULL,'testV');
/*!40000 ALTER TABLE `foro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genero`
--

DROP TABLE IF EXISTS `genero`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genero` (
  `IDGenero` varchar(255) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Descripcion` text NOT NULL,
  PRIMARY KEY (`IDGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genero`
--

LOCK TABLES `genero` WRITE;
/*!40000 ALTER TABLE `genero` DISABLE KEYS */;
INSERT INTO `genero` VALUES ('ciencia_ficcion','Ciencia Ficción','El género de ciencia ficción es una forma de literatura que imagina posibles escenarios futuros o alternativos basados en el conocimiento científico y tecnológico. La ciencia ficción explora las implicaciones de los avances científicos o sociales en la vida humana, así como los dilemas éticos, morales o filosóficos que puedan surgir. La ciencia ficción se diferencia de otros géneros fantásticos en que sus argumentos se sustentan en una lógica racional y verosímil, aunque no necesariamente realista.\n	La ciencia ficción se originó en el siglo XX, como una forma de expresar las inquietudes y expectativas de una época marcada por el progreso científico y tecnológico. Algunos de los autores pioneros del género fueron Julio Verne, H. G. Wells y Mary Shelley. La ciencia ficción alcanzó su mayor popularidad en la segunda mitad del siglo XX, con autores como Isaac Asimov, Arthur C. Clarke y Ray Bradbury, y se extendió a otros medios como el cine, el cómic y los videojuegos.\n	La ciencia ficción abarca una gran variedad de temas, como los viajes espaciales, los encuentros con extraterrestres, los viajes en el tiempo, las realidades virtuales, las inteligencias artificiales, las distopías, las utopías, las mutaciones, el apocalipsis, etc. La ciencia ficción se puede clasificar en dos grandes vertientes: la ciencia ficción dura y la ciencia ficción blanda. La ciencia ficción dura es aquella que se basa en un rigor científico y tecnológico, mientras que la ciencia ficción blanda es aquella que se centra más en los aspectos sociales, culturales o psicológicos de la ficción. Dentro de la ciencia ficción también existen otros subgéneros con características propias, como el cyberpunk, el steampunk, el biopunk, el retrofuturismo, etc.\n	La ciencia ficción, además de entretener y estimular la imaginación, también tiene una función crítica y reflexiva sobre la realidad actual y las posibilidades del futuro. La ciencia ficción plantea cuestiones sobre el papel de la ciencia y la tecnología en la sociedad, los límites éticos y morales de la investigación, las consecuencias de la intervención humana en el medio ambiente, los conflictos entre diferentes culturas o civilizaciones, los derechos y deberes de los seres humanos y de otras formas de vida, etc. La ciencia ficción, en definitiva, es una forma de explorar el mundo y de cuestionar nuestra propia existencia.\n	'),('cuento','Cuento','En términos generales, un cuento es una narración breve que se enfoca en un incidente específico, con un número limitado de personajes y un desarrollo conciso de la trama. A menudo, está diseñado para capturar la atención del lector desde el principio y transmitir un mensaje o emoción de manera efectiva en un espacio reducido.\n	Si exploramos el desarrollo histórico del cuento, encontramos contribuciones notables en diferentes culturas. Los hermanos Grimm, con sus cuentos de hadas como \"Cenicienta\" o \"Blancanieves\", marcaron la literatura infantil y popularizaron la forma de cuento como la conocemos hoy.\n	En la literatura hispana, autores como Julio Cortázar, con su obra maestra \"Bestiario\", o Juan Rulfo, con \"Luvina\", han destacado por su habilidad para construir mundos intensos y evocadores en el formato breve del cuento.\n	La estructura del cuento a menudo incluye elementos como la introducción, el desarrollo del conflicto y la resolución, todo dentro de un marco limitado. Esto exige a los autores una economía de palabras y una precisión narrativa para transmitir su mensaje de manera efectiva.\n	Desde la perspectiva de la lingüística computacional, el análisis de cuentos puede revelar patrones narrativos, temas recurrentes y técnicas literarias específicas que contribuyen al impacto emocional y cognitivo de la obra.'),('ensayo','Ensayo','El ensayo es un género literario que se distingue por su carácter reflexivo y analítico sobre diversos temas. En contraste con formas de escritura más rígidas, el ensayo brinda a los autores una libertad considerable para expresar sus opiniones, ideas y puntos de vista de manera subjetiva. \n	Este género literario no se limita a estructuras fijas y permite una variedad temática que abarca desde cuestiones filosóficas y sociales hasta experiencias personales. La flexibilidad en su estructura, combinada con la libertad de estilo, otorga a cada ensayo una marca distintiva y única, reflejando la voz y la perspectiva del autor. \n    A través de la reflexión profunda y el análisis crítico, el ensayo invita al lector a explorar nuevas ideas y perspectivas, contribuyendo así al diálogo intelectual y a la comprensión más profunda de diversos temas. \n    La claridad en la expresión y la coherencia en la argumentación son valores importantes que caracterizan a un buen ensayo, que busca comunicar de manera efectiva las reflexiones del autor.\n    '),('memoria','Memoria','En la literatura de memoria, los autores exploran eventos y momentos significativos de sus propias vidas, compartiendo sus pensamientos, emociones y perspectivas. Estas obras a menudo abarcan desde la infancia hasta la adultez, y pueden centrarse en temas como el crecimiento personal, la identidad, las relaciones familiares, las experiencias culturales y sociales, entre otros.\n	Algunos ejemplos clásicos de literatura de memoria incluyen \"Las Confesiones\" de San Agustín, que es considerada una de las primeras autobiografías, y \"Memorias de Adriano\" de Marguerite Yourcenar, que adopta la voz del emperador romano Adriano.\n	En el ámbito de la literatura hispana, podríamos mencionar \"Vivir para contarla\" de Gabriel García Márquez, donde el autor colombiano comparte sus experiencias de infancia y juventud, o \"Palinuro de México\" de Fernando del Paso, una obra que mezcla la autobiografía con elementos surrealistas.\n	Este género literario es poderoso porque permite a los lectores conectarse personalmente con las experiencias del autor, ofreciendo una ventana a la vida y perspectivas individuales. '),('novela','Novela','La novela es un género literario extenso y complejo que ha evolucionado a lo largo de los siglos. Se caracteriza por contar historias ficticias o basadas en la realidad, desarrollando tramas complejas que exploran la condición humana, la sociedad y diversos aspectos de la vida. Es una forma de expresión artística que permite a los autores explorar personajes, conflictos y temas de manera profunda.\n		Si retrocedemos en el tiempo, podemos observar la contribución de varios autores clave en la definición y desarrollo de la novela. Cervantes, con su obra \"Don Quijote de la Mancha\", a menudo considerada la primera novela moderna, introdujo elementos como la metaficción y la exploración psicológica de los personajes.\n		En el siglo XIX, autores como Charles Dickens con \"Grandes esperanzas\" o Fiódor Dostoievski con \"Crimen y castigo\" continuaron expandiendo el alcance de la novela, abordando cuestiones sociales y psicológicas con detalle y profundidad.\n		En el siglo XX, vimos la diversificación de estilos y enfoques. Gabriel García Márquez, con \"Cien años de soledad\", introdujo el realismo mágico, mientras que James Joyce, con \"Ulises\", experimentó con técnicas narrativas innovadoras.\n		En el ámbito de la lingüística computacional, el análisis de textos novelísticos ha sido un campo interesante. Las herramientas computacionales permiten examinar patrones lingüísticos, estructuras narrativas y tendencias temáticas en grandes conjuntos de novelas, proporcionando una perspectiva única sobre la evolución del género a lo largo del tiempo.'),('no_ficcion','No Ficción',' En el ámbito del género de no ficción, diversos autores han aportado sus visiones a lo largo del tiempo, ofreciendo enfoques distintos sobre cómo se aborda la representación de la realidad. Tomemos, por ejemplo, a Truman Capote, cuya obra \"A Sangre Fría\" marcó el surgimiento del \"nuevo periodismo\". Capote fusionó elementos literarios con la investigación periodística, narrando un crimen real de manera novelada y detallada.\n	En contraste, el periodista y escritor George Orwell, famoso por \"1984\" y \"Rebelión en la Granja\", contribuyó al género de no ficción con su obra \"En el Camino a Wigan Pier\". En este libro, Orwell utiliza la observación directa y la participación en la vida de los mineros para analizar las condiciones sociales y económicas de la época, combinando el reportaje con elementos ensayísticos.\n	Susan Sontag, por otro lado, exploró la crítica cultural y la interpretación de la realidad en ensayos como \"Sobre la Fotografía\". Sontag examina cómo la fotografía influye en nuestra percepción de la realidad, planteando preguntas filosóficas sobre la verdad y la representación visual.\n	En el siglo XXI, autores como Malcolm Gladwell han popularizado el formato del ensayo narrativo con obras como \"Fueras de Serie\", donde combina datos y anécdotas para explorar patrones socioculturales. Gladwell busca explicar fenómenos complejos de manera accesible y atractiva.'),('poesia','Poesía','En términos generales, la poesía se caracteriza por su estructura métrica, ritmo y uso especial del lenguaje. A menudo, los poetas recurren a la metáfora, la simbolización y la musicalidad del lenguaje para transmitir sus mensajes de manera más evocadora y sugerente.\n	Desde los sonetos de William Shakespeare hasta los versos libres de Walt Whitman, la poesía ha evolucionado a lo largo de los siglos y ha sido utilizada para explorar una amplia gama de temas, desde el amor y la naturaleza hasta la crítica social y la introspección filosófica.\n	En la literatura hispana, grandes poetas como Federico García Lorca, Pablo Neruda y Octavio Paz han dejado una huella imborrable. Lorca, con su poesía surrealista y lírica, Neruda, con su intensidad emotiva y política, y Paz, con su profundidad filosófica, han enriquecido el panorama poético en español.\n	La poesía contemporánea también ha experimentado con nuevas formas y enfoques, incorporando voces diversas y desafiando las convenciones establecidas. La lingüística computacional también ha permitido analizar patrones y tendencias en la poesía, revelando conexiones y variaciones a lo largo del tiempo.'),('romance','Romance','El género del romance es una expresión literaria que se centra en las relaciones amorosas y la búsqueda del amor, explorando las complejidades emocionales y las vicisitudes del corazón humano. Las tramas románticas son el núcleo de estas historias, con conflictos y obstáculos que los personajes deben superar para alcanzar la felicidad romántica. El desarrollo de personajes, especialmente en términos de sus sentimientos y relaciones, es fundamental, y a menudo, las historias se desarrollan en entornos que realzan el ambiente romántico.\n	Dentro del romance, encontramos diversos subgéneros. El romance histórico se sitúa en el pasado, a menudo con detalles históricos precisos, mientras que el romance contemporáneo refleja las relaciones modernas. El romance paranormal incorpora elementos sobrenaturales o fantásticos, y el romance de época se ambienta en períodos específicos del pasado, destacando las costumbres de la época.\n	Grandes autores del romance han dejado una marca indeleble en la literatura. Jane Austen, con \"Orgullo y prejuicio\", es una autora clásica, mientras que Nicholas Sparks, con novelas emotivas como \"El cuaderno de Noah\", ha conquistado a muchos lectores contemporáneos. Julia Quinn, conocida por la serie \"Bridgerton\", es otra figura destacada en el género.'),('teatro','Teatro',' El género de dramaturgia o teatro ha sido abordado por diversos autores a lo largo de la historia, proporcionando perspectivas enriquecedoras sobre sus características y propósitos. Aristóteles, en su \"Poética\", considera al teatro como una imitación de la realidad que purga las emociones a través de la catarsis. Para él, la tragedia y la comedia son las dos formas fundamentales, destacando la importancia de la trama, el carácter y el lenguaje.\n	En contraste, Bertolt Brecht, influyente dramaturgo alemán, propuso un enfoque épico en el teatro, buscando la alienación del espectador para que este reflexione críticamente sobre los problemas sociales. Brecht abogó por la separación entre el actor y el personaje, utilizando técnicas como la ruptura de la cuarta pared.\n	Otro punto de vista relevante es el de Anton Chéjov, quien introdujo el realismo psicológico en la dramaturgia. Chéjov se centra en la vida cotidiana y los detalles mundanos para retratar la complejidad emocional de los personajes. Su obra \"La Gaviota\" es un ejemplo de cómo exploró la insatisfacción y las relaciones humanas con un tono melancólico.\n	En el siglo XX, el teatro del absurdo, representado por autores como Samuel Beckett, cuestionó la lógica convencional y la comunicación en un mundo aparentemente sin sentido. Obras como \"Esperando a Godot\" desafían las convenciones tradicionales y exploran la absurda naturaleza de la existencia humana.');
/*!40000 ALTER TABLE `genero` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generospublicados`
--

DROP TABLE IF EXISTS `generospublicados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generospublicados` (
  `IDGeneroPublicado` varchar(255) NOT NULL,
  `IDGenero` varchar(255) NOT NULL,
  `IDAutor` varchar(255) NOT NULL,
  PRIMARY KEY (`IDGeneroPublicado`),
  KEY `IDGenero` (`IDGenero`),
  KEY `IDAutor` (`IDAutor`),
  CONSTRAINT `generospublicados_ibfk_1` FOREIGN KEY (`IDGenero`) REFERENCES `genero` (`IDGenero`),
  CONSTRAINT `generospublicados_ibfk_2` FOREIGN KEY (`IDAutor`) REFERENCES `autor` (`IDAutor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generospublicados`
--

LOCK TABLES `generospublicados` WRITE;
/*!40000 ALTER TABLE `generospublicados` DISABLE KEYS */;
/*!40000 ALTER TABLE `generospublicados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `generosusuario`
--

DROP TABLE IF EXISTS `generosusuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `generosusuario` (
  `ID` varchar(255) NOT NULL,
  `IDUsuario` varchar(255) DEFAULT NULL,
  `IDGenero` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDUsuario` (`IDUsuario`),
  KEY `IDGenero` (`IDGenero`),
  CONSTRAINT `generosusuario_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`),
  CONSTRAINT `generosusuario_ibfk_2` FOREIGN KEY (`IDGenero`) REFERENCES `genero` (`IDGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `generosusuario`
--

LOCK TABLES `generosusuario` WRITE;
/*!40000 ALTER TABLE `generosusuario` DISABLE KEYS */;
INSERT INTO `generosusuario` VALUES ('ddb5a5a3-7e25-4bb5-8523-139ab43d3bf7','2fb437ec-0006-43c9-a26f-d9c73ad2410c','cuento');
/*!40000 ALTER TABLE `generosusuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagenperfil`
--

DROP TABLE IF EXISTS `imagenperfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imagenperfil` (
  `ID` varchar(255) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `IMAGEN` longblob DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagenperfil`
--

LOCK TABLES `imagenperfil` WRITE;
/*!40000 ALTER TABLE `imagenperfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `imagenperfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacionpersonal`
--

DROP TABLE IF EXISTS `informacionpersonal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informacionpersonal` (
  `ID` varchar(255) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `ApellidoPaterno` varchar(100) NOT NULL,
  `ApellidoMaterno` varchar(100) NOT NULL,
  `FechaNacimiento` date NOT NULL,
  `FechaDeceso` date DEFAULT NULL,
  `Biografia` text DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacionpersonal`
--

LOCK TABLES `informacionpersonal` WRITE;
/*!40000 ALTER TABLE `informacionpersonal` DISABLE KEYS */;
INSERT INTO `informacionpersonal` VALUES ('18fdadbc-8b61-4d52-9b22-991a8f5e5c6d','Gabriel','García','Márquez','1927-03-06','2014-04-17','Escritor colombiano, premio Nobel de Literatura en 1982.'),('23ef7676-1b1e-4a02-8c67-9f82c5d7e87c','Italo','Calvino','','1923-10-15','1985-09-19','Escritor italiano, autor de \"Las ciudades invisibles\" y \"El barón rampante\".'),('32719c88-334e-40ac-9510-a49f4e37fe15','test','test','test','2023-12-23',NULL,NULL),('32f3f61a-0e1a-4f8f-aa3f-4704fe93f4fe','John','Steinbeck','','1902-02-27','1968-12-20','Escritor estadounidense, autor de \"Las uvas de la ira\" y \"Al Este del Edén\".'),('3b84b6e9-dc99-4a06-b9ea-5a692a416ec0','Carlos','Drummond','de Andrade','1902-10-31','1987-08-17','Poeta brasileño, importante en la literatura del siglo XX.'),('3d180295-65c5-498e-bda9-4a2e1e2b39a7','Isabel','Allende','Llona','1942-08-02',NULL,'Escritora chilena, autora de \"La casa de los espíritus\".'),('4e1ad4ed-5f80-4c3f-9c68-47c7c7330a50','Jorge','Borges','Acevedo','1899-08-24','1986-06-14','Escritor argentino, autor de obras como \"Ficciones\" y \"El Aleph\".'),('621e9ac6-b9db-41b4-a400-bf4885d5a597','Virginia','Woolf','Stephen','1882-01-25','1941-03-28','Escritora británica, figura importante en la literatura modernista, autora de \"La señora Dalloway\".'),('7b79dd31-5cfc-4aef-9edc-6c7da5706e7f','Julio','Cortázar','Descotte','1914-08-26','1984-02-12','Escritor argentino, maestro del relato corto y la prosa poética.'),('87193eb0-2ba0-4590-b37b-64db8e1c1266','Alfonsina','Storni','Quesad','1892-05-29','1938-10-25','Poeta argentina, destacada figura del modernismo.'),('8e5bf10b-b540-47c1-974c-59b10190d06e','Wole','Soyinka','','1934-07-13',NULL,'Dramaturgo y escritor nigeriano, primer africano en recibir el Premio Nobel de Literatura en 1986.'),('944be3e7-b26b-4c01-a689-e3b21f40ef67','Langston','Hughes','','1902-02-01','1967-05-22','Poeta, novelista y activista estadounidense, figura destacada del Renacimiento de Harlem.'),('9d202fc3-b9fc-4d23-b0ce-442f59840d62','Juan','Rulfo','Vizcaíno','1917-05-16','1986-01-07','Escritor mexicano, conocido por \"Pedro Páramo\" y \"El llano en llamas\".'),('9f4bf65e-e10d-460c-bbc5-903d1ec660ed','Miguel','de Unamuno','y Jugo','1864-09-29','1936-12-31','Escritor y filósofo español, figura destacada de la Generación del 98.'),('a5df92dd-2a3a-46b5-8329-ef189f75a00f','Miguel','de Cervantes','Saavedra','1547-09-29','1616-04-22','Escritor español, autor de \"Don Quijote de la Mancha\", considerada la primera novela moderna.'),('a8b77552-50e2-4a4d-86b3-1b062799e6b4','Octavio','Paz','Lozano','1914-03-31','1998-04-19','Poeta, ensayista y diplomático mexicano, premio Nobel de Literatura en 1990.'),('ab20155b-27a3-4e42-a0c3-8f80b5b3f9e1','Franz','Kafka','','1883-07-03','1924-06-03','Escritor checo-alemán, conocido por sus obras como \"La metamorfosis\" y \"El proceso\".'),('bebc3b67-60a3-47d8-9db6-14e1ec08ed6d','Amy','Tan','','1952-02-19',NULL,'Escritora estadounidense-china, autora de \"El club de la buena estrella\" y \"El valle del asombro\".'),('bfb3fe7b-fa6f-44f8-b349-21d781d3a00a','Julio Ramón','Ribeyro','Zúñiga','1929-08-31','1994-12-04','Escritor peruano, conocido por sus cuentos y crónicas.'),('c19a3db4-e794-4ef1-b6ab-fd0d881dbf27','Alejandra','Pizarnik','','1936-04-29','1972-09-25','Poetisa y escritora argentina, conocida por su obra lírica y su poesía introspectiva.'),('c80c4ea6-c20a-4b18-9f90-d3035d1a154c','Anne','Frank','','1929-06-12','1945-03-12','Diarista judía alemana, autora del famoso \"Diario de Ana Frank\" durante la Segunda Guerra Mundial.'),('cd1e1186-7a7e-4a6c-b7a5-ae01eaff437e','Carlos','Fuentes','Macías','1928-11-11','2012-05-15','Escritor mexicano, destacado representante de la literatura latinoamericana.'),('cd1ea9g8-s9a7-4a6c-b7a5-ae01eda88','Mario','Vargas','Llosa','1936-03-28',NULL,'Escritor peruano, premio Nobel de Literatura en 2010.'),('e1cda7a5-7ea5-460a-845e-e968b47f50e0','Agatha','Christie','Miller','1890-09-15','1976-01-12','Escritora británica de novelas policíacas, creadora del famoso detective Hercule Poirot.'),('e4da87b2-890d-4b0a-979f-b679a35dd60f','Pablo','Neruda','Ricardo Reyes','1904-07-12','1973-09-23','Poeta chileno, premio Nobel de Literatura en 1971.'),('eb8df5aa-1ad8-42b9-9da0-1271dbd8c687','Rosario','Castellanos','Figueroa','1925-05-25','1974-08-07','Escritora y poetisa mexicana, una de las voces más importantes de la literatura femenina.'),('ee07b079-8c69-417a-b692-1b8bb601bc45','Laura','Esquivel','Valdés','1950-09-30',NULL,'Escritora y novelista mexicana, conocida por \"Como agua para chocolate\".'),('f50f1e5b-031c-4b77-bb91-3703fe6ac4b0','Gabriela','Mistral','Vicuña','1889-04-07','1957-01-10','Poetisa chilena, primera latinoamericana en recibir el Premio Nobel de Literatura en 1945.');
/*!40000 ALTER TABLE `informacionpersonal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `IDLibro` varchar(255) NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `Foto` varchar(255) NOT NULL,
  `NumPag` int(11) DEFAULT NULL,
  `FechaPublicacion` date NOT NULL,
  `Idioma` varchar(100) NOT NULL,
  `Editorial` varchar(255) NOT NULL,
  `IDAutor` varchar(255) NOT NULL,
  `IDGenero` varchar(255) NOT NULL,
  PRIMARY KEY (`IDLibro`),
  KEY `IDAutor` (`IDAutor`),
  KEY `IDGenero` (`IDGenero`),
  CONSTRAINT `libro_ibfk_1` FOREIGN KEY (`IDAutor`) REFERENCES `autor` (`IDAutor`),
  CONSTRAINT `libro_ibfk_2` FOREIGN KEY (`IDGenero`) REFERENCES `genero` (`IDGenero`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES ('1','Cien años de soledad','cien anos de soledad',400,'1967-05-30','Español','Editorial XYZ','9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d','ciencia_ficcion'),('10','Sentimiento del mundo','Sentimiento del mundo',180,'1940-07-12','Español','Editorial XYZ','fd52a226-88a8-44f2-8f5c-5316bf90e7f4','poesia'),('11','La rosa del pueblo','La rosa del pueblo',150,'1945-11-28','Español','Editorial ABC','fd52a226-88a8-44f2-8f5c-5316bf90e7f4','poesia'),('12','Claro enigma','Claro enigma',220,'1951-04-05','Español','Editorial 123','fd52a226-88a8-44f2-8f5c-5316bf90e7f4','poesia'),('13','La casa de los espíritus','La casa de los espíritus',400,'1982-06-12','Español','Editorial XYZ','c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19','ciencia_ficcion'),('14','Eva Luna','Eva Luna',350,'1987-09-18','Español','Editorial ABC','c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19','ciencia_ficcion'),('15','Paula','Paula',300,'1994-03-05','Español','Editorial 123','c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19','memoria'),('16','Ficciones','Ficciones',250,'1944-08-10','Español','Editorial XYZ','f7dd37f4-18b1-4c85-b3ce-d9e7b117cb0d','ciencia_ficcion'),('17','El Aleph','El Aleph',180,'1949-05-15','Español','Editorial ABC','f7dd37f4-18b1-4c85-b3ce-d9e7b117cb0d','cuento'),('19','La ciudad y los perros','La ciudad y los perros',400,'1963-10-28','Español','Editorial XYZ','cdfea0g1-s1a9-3a5c-b8a6-ae12eda90','novela'),('2','El otoño del patriarca','El otoño del patriarca',300,'1975-09-15','Español','Editorial ABC','9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d','ciencia_ficcion'),('20','La fiesta del chivo','La fiesta del chivo',350,'2000-03-10','Español','Editorial ABC','cdfea0g1-s1a9-3a5c-b8a6-ae12eda90','memoria'),('21','Conversación en La Catedral','Conversación en La Catedral',320,'1969-06-15','Español','Editorial 123','cdfea0g1-s1a9-3a5c-b8a6-ae12eda90','ciencia_ficcion'),('22','La señora Dalloway','La señora Dalloway',250,'1925-05-14','Español','Editorial XYZ','9d2140b1-51e0-4c62-87e5-cc2079a2802e','ciencia_ficcion'),('23','Al faro','Al faro',300,'1927-09-20','Español','Editorial ABC','9d2140b1-51e0-4c62-87e5-cc2079a2802e','novela'),('24','Orlando','Orlando',200,'1928-11-11','Español','Editorial 123','9d2140b1-51e0-4c62-87e5-cc2079a2802e','ciencia_ficcion'),('25','Rayuela','Rayuela',350,'1963-07-28','Español','Editorial XYZ','fce5f648-ff97-44d9-aa5b-44d3e982f7ad','ciencia_ficcion'),('26','Final del juego','Final del juego',180,'1956-12-15','Español','Editorial ABC','fce5f648-ff97-44d9-aa5b-44d3e982f7ad','cuento'),('27','Bestiario','Bestiario',220,'1951-04-05','Español','Editorial 123','fce5f648-ff97-44d9-aa5b-44d3e982f7ad','ciencia_ficcion'),('28','La inquietud del rosal','La inquietud del rosal',150,'1916-08-22','Español','Editorial XYZ','af38439b-992f-40c1-b471-96f8d9d36c1a','poesia'),('29','Irremediablemente','Irremediablemente',120,'1919-03-10','Español','Editorial ABC','af38439b-992f-40c1-b471-96f8d9d36c1a','poesia'),('3','Crónica de una muerte anunciada','Crónica de una muerte anunciada',200,'1981-03-22','Español','Editorial 123','9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d','novela'),('30','Mundo de siete pozos','Mundo de siete pozos',200,'1934-11-15','Español','Editorial 123','af38439b-992f-40c1-b471-96f8d9d36c1a','poesia'),('31','El hombre muerto','El hombre muerto',200,'1972-08-18','Español','Editorial XYZ','3c7a888d-e199-4012-aac6-bf33a13e5e9b','teatro'),('32','Las estaciones de la locura','Las estaciones de la locura',180,'1981-11-25','Español','Editorial ABC','3c7a888d-e199-4012-aac6-bf33a13e5e9b','poesia'),('33','Ake: Los años de la infancia','Ake:Los años de la infancia',300,'1981-04-15','Español','Editorial 123','3c7a888d-e199-4012-aac6-bf33a13e5e9b','memoria'),('36','El camino de los sueños','El camino de los sueños',200,'1941-09-30','Español','Editorial 123','6b87be42-4988-4c5d-82cf-2b9e9f1200fb','novela'),('37','Pedro Páramo','Pedro Páramo',250,'1955-06-10','Español','Editorial XYZ','7a9c8b14-682b-4ee1-8e90-50c554ce04c8','ciencia_ficcion'),('38','El llano en llamas','El llano en llamas',180,'1953-03-15','Español','Editorial ABC','7a9c8b14-682b-4ee1-8e90-50c554ce04c8','cuento'),('39','Juan Rulfo: Otras miradas','Otras miradas',220,'2002-11-20','Español','Editorial 123','7a9c8b14-682b-4ee1-8e90-50c554ce04c8','memoria'),('4','El barón rampante','El barón rampante',250,'1957-10-10','Español','Editorial XYZ','a1d575ed-67ea-40c7-b579-005d3d4f9a1c','ciencia_ficcion'),('40','Niebla','Niebla',300,'1914-09-30','Español','Editorial XYZ','f4dd2d87-6121-46e7-8da2-6f8716e0b72b','novela'),('41','San Manuel Bueno, mártir','San Manuel Bueno,mártir',150,'1933-02-15','Español','Editorial ABC','f4dd2d87-6121-46e7-8da2-6f8716e0b72b','ciencia_ficcion'),('42','Del sentimiento trágico de la vida','Del sentimiento trágico de la vida',220,'1913-11-25','Español','Editorial 123','f4dd2d87-6121-46e7-8da2-6f8716e0b72b','ensayo'),('43','Don Quijote de la Mancha','Don Quijote de la Mancha',500,'1605-01-16','Español','Editorial XYZ','81a4c7a7-58d9-4ff7-986f-725a9e95020d','novela'),('44','Rinconete y Cortadillo','Rinconete Cortadillo',100,'1613-11-12','Español','Editorial ABC','81a4c7a7-58d9-4ff7-986f-725a9e95020d','novela'),('45','La Galatea','La Galatea',250,'1585-04-01','Español','Editorial 123','81a4c7a7-58d9-4ff7-986f-725a9e95020d','novela'),('46','El laberinto de la soledad','El laberinto de la soledad',200,'1950-09-30','Español','Editorial XYZ','e057865e-6a64-4324-9da1-dc8b42e27a2d','ensayo'),('47','Piedra de sol','Piedra de sol',150,'1957-02-15','Español','Editorial ABC','e057865e-6a64-4324-9da1-dc8b42e27a2d','poesia'),('48','In Light of India','In Light of India',300,'1995-06-20','Inglés','Editorial 123','e057865e-6a64-4324-9da1-dc8b42e27a2d','ensayo'),('49','La metamorfosis','La metamorfosis',150,'1915-10-15','Español','Editorial XYZ','8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899','ciencia_ficcion'),('5','Las ciudades invisibles','Las ciudades invisibles',180,'1972-05-20','Español','Editorial ABC','a1d575ed-67ea-40c7-b579-005d3d4f9a1c','no_ficcion'),('50','El proceso','El proceso',250,'1925-04-26','Español','Editorial ABC','8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899','novela'),('51','El castillo','El castillo',200,'1926-06-20','Español','Editorial 123','8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899','ciencia_ficcion'),('52','El club de la buena estrella','El club de la buena estrella',300,'1989-03-10','Español','Editorial XYZ','8a20f7d8-2f47-44aa-9e91-f5ac54f54594','ciencia_ficcion'),('54','El arco iris de la gravedad','El arco iris de la gravedad',180,'1995-07-28','Español','Editorial 123','8a20f7d8-2f47-44aa-9e91-f5ac54f54594','ciencia_ficcion'),('55','Los gallinazos sin plumas','Los gallinazos sin plumas',120,'1954-11-12','Español','Editorial XYZ','55d4d6a5-6325-4e0f-b241-c7f8997ce14e','cuento'),('56','La palabra del mudo','La palabra del mudo',150,'1953-06-10','Español','Editorial ABC','55d4d6a5-6325-4e0f-b241-c7f8997ce14e','cuento'),('57','Silvio en El Rosedal','Silvio en El Rosedal',200,'1965-03-20','Español','Editorial 123','55d4d6a5-6325-4e0f-b241-c7f8997ce14e','novela'),('58','Los trabajos y las noches','Los trabajos y las noches',180,'1965-07-28','Español','Editorial XYZ','8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222','poesia'),('59','La condesa sangrienta','La condesa sangrienta',150,'1971-09-15','Español','Editorial ABC','8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222','memoria'),('6','Si una noche de invierno un viajero','Si una noche de invierno un viajero',320,'1979-08-30','Español','Editorial 123','a1d575ed-67ea-40c7-b579-005d3d4f9a1c','no_ficcion'),('60','Árbol de Diana','Árbol de Diana',220,'1962-11-25','Español','Editorial 123','8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222','poesia'),('61','El diario de Ana Frank','El Diario de Ana Frank',250,'1947-06-25','Español','Editorial XYZ','f8485361-4d88-4935-ba76-55f3da2a7db4','memoria'),('62','Cuentos de la casa de atrás','Cuentos de la casa de atrás',180,'1959-09-10','Español','Editorial ABC','f8485361-4d88-4935-ba76-55f3da2a7db4','cuento'),('64','La región más transparente','La región más transparente',400,'1958-08-30','Español','Editorial XYZ','ffddc101-4f0e-43f8-aa5b-8c68390a6b3a','ciencia_ficcion'),('65','La muerte de Artemio Cruz','La muerte de Artemio Cruz',350,'1962-02-15','Español','Editorial ABC','ffddc101-4f0e-43f8-aa5b-8c68390a6b3a','novela'),('66','Gringo viejo','Gringo viejo',320,'1985-06-20','Español','Editorial 123','ffddc101-4f0e-43f8-aa5b-8c68390a6b3a','memoria'),('67','Asesinato en el Orient Express','Asesinato en el Orient Express',250,'1934-01-28','Español','Editorial XYZ','0cb152c2-c8b7-4c80-99b5-2821ef5f77c8','novela'),('68','Diez negritos','Diez negritos',180,'1939-03-10','Español','Editorial ABC','0cb152c2-c8b7-4c80-99b5-2821ef5f77c8','ciencia_ficcion'),('69','El asesinato de Roger Ackroyd','El asesinato de Roger Ackroyd',220,'1926-11-25','Español','Editorial 123','0cb152c2-c8b7-4c80-99b5-2821ef5f77c8','novela'),('7','Las uvas de la ira','Las uvas de la ira',350,'1939-04-14','Español','Editorial XYZ','b85e4cd7-f603-4b6f-a008-b0806a6d5f1c','ciencia_ficcion'),('70','Veinte poemas de amor y una canción desesperada','Veinte poemas de amor y una canción desesperada',150,'1924-09-30','Español','Editorial XYZ','078070ae-ba21-4c52-91f3-b4e3a071cd42','poesia'),('71','Canto general','Canto general',300,'1950-02-15','Español','Editorial ABC','078070ae-ba21-4c52-91f3-b4e3a071cd42','ciencia_ficcion'),('72','Confieso que he vivido','Confieso que he vivido',220,'1974-06-20','Español','Editorial 123','078070ae-ba21-4c52-91f3-b4e3a071cd42','memoria'),('73','Oficio de tinieblas','Oficio de tinieblas',200,'1962-07-28','Español','Editorial XYZ','5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4','poesia'),('74','Balún Canán','Balún Canán',250,'1957-09-15','Español','Editorial ABC','5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4','novela'),('75','Mujer que sabe latín... sabe un montón de cosas','Mujer que sabe latín... sabe un montón de cosas',180,'1973-11-25','Español','Editorial 123','5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4','ensayo'),('76','Como agua para chocolate','Como agua para chocolate',250,'1989-03-30','Español','Editorial XYZ','a0cb4a55-5b24-4e65-b485-0c0418e0f781','ciencia_ficcion'),('77','La ley del amor','La ley del amor',300,'1995-08-15','Español','Editorial ABC','a0cb4a55-5b24-4e65-b485-0c0418e0f781','ciencia_ficcion'),('78','Tan veloz como el deseo','Tan veloz como el deseo',220,'2001-06-20','Español','Editorial 123','a0cb4a55-5b24-4e65-b485-0c0418e0f781','novela'),('79','Lagar','Lagar',150,'1954-11-12','Español','Editorial XYZ','0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38','poesia'),('8','De ratones y hombres','De ratones y hombres',200,'1937-02-15','Español','Editorial ABC','b85e4cd7-f603-4b6f-a008-b0806a6d5f1c','novela'),('80','Desolación','Desolación',120,'1922-09-15','Español','Editorial ABC','0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38','poesia'),('81','Lagar II','Lagar II',200,'1954-03-20','Español','Editorial 123','0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38','poesia'),('9','Al este del Edén','Al este del Edén',450,'1952-09-30','Español','Editorial 123','b85e4cd7-f603-4b6f-a008-b0806a6d5f1c','teatro');
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libroenlista`
--

DROP TABLE IF EXISTS `libroenlista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libroenlista` (
  `IDLibroLista` varchar(255) NOT NULL,
  `IDLista` varchar(255) NOT NULL,
  `IDLibro` varchar(255) NOT NULL,
  PRIMARY KEY (`IDLibroLista`),
  KEY `IDLista` (`IDLista`),
  KEY `IDLibro` (`IDLibro`),
  CONSTRAINT `libroenlista_ibfk_1` FOREIGN KEY (`IDLista`) REFERENCES `lista` (`IDLista`),
  CONSTRAINT `libroenlista_ibfk_2` FOREIGN KEY (`IDLibro`) REFERENCES `libro` (`IDLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libroenlista`
--

LOCK TABLES `libroenlista` WRITE;
/*!40000 ALTER TABLE `libroenlista` DISABLE KEYS */;
/*!40000 ALTER TABLE `libroenlista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lista`
--

DROP TABLE IF EXISTS `lista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lista` (
  `IDLista` varchar(255) NOT NULL,
  `CantidadLibros` int(11) NOT NULL,
  `Privacidad` varchar(255) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Descripcion` text NOT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  `FOTO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDLista`),
  KEY `IDUsuario` (`IDUsuario`),
  KEY `FOTO` (`FOTO`),
  CONSTRAINT `lista_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`),
  CONSTRAINT `lista_ibfk_2` FOREIGN KEY (`FOTO`) REFERENCES `imagenperfil` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lista`
--

LOCK TABLES `lista` WRITE;
/*!40000 ALTER TABLE `lista` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

DROP TABLE IF EXISTS `notificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notificacion` (
  `IDNotificacion` varchar(255) NOT NULL,
  `Contenido` text NOT NULL,
  `Foto` blob NOT NULL,
  `IDUsuarioDestino` varchar(255) NOT NULL,
  PRIMARY KEY (`IDNotificacion`),
  KEY `IDUsuarioDestino` (`IDUsuarioDestino`),
  CONSTRAINT `notificacion_ibfk_1` FOREIGN KEY (`IDUsuarioDestino`) REFERENCES `usuario` (`IDUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participanteforo`
--

DROP TABLE IF EXISTS `participanteforo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participanteforo` (
  `IDParticipanteForo` varchar(255) NOT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  `IDFoto` varchar(255) NOT NULL,
  `FechaAgregar` date NOT NULL,
  PRIMARY KEY (`IDParticipanteForo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participanteforo`
--

LOCK TABLES `participanteforo` WRITE;
/*!40000 ALTER TABLE `participanteforo` DISABLE KEYS */;
/*!40000 ALTER TABLE `participanteforo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `publicacion`
--

DROP TABLE IF EXISTS `publicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `publicacion` (
  `Comentario` varchar(255) DEFAULT NULL,
  `ReaccionLike` int(11) DEFAULT NULL,
  `ReaccionDislike` int(11) DEFAULT NULL,
  `IDForo` varchar(255) DEFAULT NULL,
  `IDUsuario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `publicacion`
--

LOCK TABLES `publicacion` WRITE;
/*!40000 ALTER TABLE `publicacion` DISABLE KEYS */;
INSERT INTO `publicacion` VALUES (NULL,0,0,NULL,'2fb437ec-0006-43c9-a26f-d9c73ad2410c');
/*!40000 ALTER TABLE `publicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reacciones`
--

DROP TABLE IF EXISTS `reacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reacciones` (
  `IDReaccion` varchar(255) NOT NULL,
  `FechaReaccion` date NOT NULL,
  `TipoReaccion` varchar(255) NOT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  `IDResena` varchar(255) NOT NULL,
  PRIMARY KEY (`IDReaccion`),
  KEY `IDUsuario` (`IDUsuario`),
  KEY `IDResena` (`IDResena`),
  CONSTRAINT `reacciones_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`),
  CONSTRAINT `reacciones_ibfk_2` FOREIGN KEY (`IDResena`) REFERENCES `resena` (`IDResena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reacciones`
--

LOCK TABLES `reacciones` WRITE;
/*!40000 ALTER TABLE `reacciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `reacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `redsocial`
--

DROP TABLE IF EXISTS `redsocial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `redsocial` (
  `IDRed` varchar(255) NOT NULL,
  `URL` varchar(255) DEFAULT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  PRIMARY KEY (`IDRed`),
  KEY `IDUsuario` (`IDUsuario`),
  CONSTRAINT `redsocial_ibfk_1` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `redsocial`
--

LOCK TABLES `redsocial` WRITE;
/*!40000 ALTER TABLE `redsocial` DISABLE KEYS */;
/*!40000 ALTER TABLE `redsocial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resena`
--

DROP TABLE IF EXISTS `resena`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resena` (
  `IDResena` varchar(255) NOT NULL,
  `FechaPublicada` date NOT NULL,
  `Puntuacion` int(11) NOT NULL,
  `Contenido` text NOT NULL,
  `IDLibro` varchar(255) NOT NULL,
  `IDUsuario` varchar(255) NOT NULL,
  PRIMARY KEY (`IDResena`),
  KEY `IDLibro` (`IDLibro`),
  KEY `IDUsuario` (`IDUsuario`),
  CONSTRAINT `resena_ibfk_1` FOREIGN KEY (`IDLibro`) REFERENCES `libro` (`IDLibro`),
  CONSTRAINT `resena_ibfk_2` FOREIGN KEY (`IDUsuario`) REFERENCES `usuario` (`IDUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resena`
--

LOCK TABLES `resena` WRITE;
/*!40000 ALTER TABLE `resena` DISABLE KEYS */;
/*!40000 ALTER TABLE `resena` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `IDUsuario` varchar(255) NOT NULL,
  `NombreUsuario` varchar(100) NOT NULL,
  `Correo` varchar(255) NOT NULL,
  `Contrasena` varchar(100) NOT NULL,
  `IDPersona` varchar(255) NOT NULL,
  `FOTO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`IDUsuario`),
  KEY `IDPersona` (`IDPersona`),
  KEY `FOTO` (`FOTO`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`IDPersona`) REFERENCES `informacionpersonal` (`ID`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`FOTO`) REFERENCES `imagenperfil` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('2fb437ec-0006-43c9-a26f-d9c73ad2410c','test','test@test','test','32719c88-334e-40ac-9510-a49f4e37fe15',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-26 17:50:04
