USE RESENAS;

select * from libro;

INSERT INTO Libro (IDLibro, Titulo, Foto, NumPag, FechaPublicacion, Idioma, IDAutor, IDGenero, Editorial)
VALUES
("1", 'Cien años de soledad', 'cien anos de soledad', 400, '1967-05-30', 'Español', '9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d', 'ciencia_ficcion', 'Editorial XYZ'),
("2", 'El otoño del patriarca', 'El otoño del patriarca', 300, '1975-09-15', 'Español', '9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d', 'ciencia_ficcion', 'Editorial ABC'),
("3", 'Crónica de una muerte anunciada', 'Crónica de una muerte anunciada', 200, '1981-03-22', 'Español', '9a46b70e-cdd7-4b52-aa42-3a512c2f0f5d', 'novela', 'Editorial 123'),

("4", 'El barón rampante', 'El barón rampante', 250, '1957-10-10', 'Español', 'a1d575ed-67ea-40c7-b579-005d3d4f9a1c', 'ciencia_ficcion', 'Editorial XYZ'),
("5", 'Las ciudades invisibles', 'Las ciudades invisibles', 180, '1972-05-20', 'Español', 'a1d575ed-67ea-40c7-b579-005d3d4f9a1c', 'no_ficcion', 'Editorial ABC'),
("6", 'Si una noche de invierno un viajero', 'Si una noche de invierno un viajero', 320, '1979-08-30', 'Español', 'a1d575ed-67ea-40c7-b579-005d3d4f9a1c', 'no_ficcion', 'Editorial 123'),

("7", 'Las uvas de la ira', 'Las uvas de la ira', 350, '1939-04-14', 'Español', 'b85e4cd7-f603-4b6f-a008-b0806a6d5f1c', 'ciencia_ficcion', 'Editorial XYZ'),
("8", 'De ratones y hombres', 'De ratones y hombres', 200, '1937-02-15', 'Español', 'b85e4cd7-f603-4b6f-a008-b0806a6d5f1c', 'novela', 'Editorial ABC'),
("9", 'Al este del Edén', 'Al este del Edén', 450, '1952-09-30', 'Español', 'b85e4cd7-f603-4b6f-a008-b0806a6d5f1c', 'teatro', 'Editorial 123'),

("10", 'Sentimiento del mundo', 'Sentimiento del mundo', 180, '1940-07-12', 'Español', 'fd52a226-88a8-44f2-8f5c-5316bf90e7f4', 'poesia', 'Editorial XYZ'),
("11", 'La rosa del pueblo', 'La rosa del pueblo', 150, '1945-11-28', 'Español', 'fd52a226-88a8-44f2-8f5c-5316bf90e7f4', 'poesia', 'Editorial ABC'),
("12", 'Claro enigma', 'Claro enigma', 220, '1951-04-05', 'Español', 'fd52a226-88a8-44f2-8f5c-5316bf90e7f4', 'poesia', 'Editorial 123'),

("13", 'La casa de los espíritus', 'La casa de los espíritus', 400, '1982-06-12', 'Español', 'c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19', 'ciencia_ficcion', 'Editorial XYZ'),
("14", 'Eva Luna', 'Eva Luna', 350, '1987-09-18', 'Español', 'c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19', 'ciencia_ficcion', 'Editorial ABC'),
("15", 'Paula', 'Paula', 300, '1994-03-05', 'Español', 'c8f6b2ea-c5b3-428b-a5e9-03d65d3f6f19', 'memoria', 'Editorial 123'),

("16", 'Ficciones', 'Ficciones', 250, '1944-08-10', 'Español', 'f7dd37f4-18b1-4c85-b3ce-d9e7b117cb0d', 'ciencia_ficcion', 'Editorial XYZ'),
("17", 'El Aleph', 'El Aleph', 180, '1949-05-15', 'Español', 'f7dd37f4-18b1-4c85-b3ce-d9e7b117cb0d', 'cuento', 'Editorial ABC'),

("19", 'La ciudad y los perros', 'La ciudad y los perros', 400, '1963-10-28', 'Español', 'cdfea0g1-s1a9-3a5c-b8a6-ae12eda90', 'novela', 'Editorial XYZ'),
("20", 'La fiesta del chivo', 'La fiesta del chivo', 350, '2000-03-10', 'Español', 'cdfea0g1-s1a9-3a5c-b8a6-ae12eda90', 'memoria', 'Editorial ABC'),
("21", 'Conversación en La Catedral', 'Conversación en La Catedral', 320, '1969-06-15', 'Español', 'cdfea0g1-s1a9-3a5c-b8a6-ae12eda90', 'ciencia_ficcion', 'Editorial 123'),

("22", 'La señora Dalloway', 'La señora Dalloway', 250, '1925-05-14', 'Español', '9d2140b1-51e0-4c62-87e5-cc2079a2802e', 'ciencia_ficcion', 'Editorial XYZ'),
("23", 'Al faro', 'Al faro', 300, '1927-09-20', 'Español', '9d2140b1-51e0-4c62-87e5-cc2079a2802e', 'novela', 'Editorial ABC'),
("24", 'Orlando', 'Orlando', 200, '1928-11-11', 'Español', '9d2140b1-51e0-4c62-87e5-cc2079a2802e', 'ciencia_ficcion', 'Editorial 123'),

("25", 'Rayuela', 'Rayuela', 350, '1963-07-28', 'Español', 'fce5f648-ff97-44d9-aa5b-44d3e982f7ad', 'ciencia_ficcion', 'Editorial XYZ'),
("26", 'Final del juego', 'Final del juego', 180, '1956-12-15', 'Español', 'fce5f648-ff97-44d9-aa5b-44d3e982f7ad', 'cuento', 'Editorial ABC'),
("27", 'Bestiario', 'Bestiario', 220, '1951-04-05', 'Español', 'fce5f648-ff97-44d9-aa5b-44d3e982f7ad', 'ciencia_ficcion', 'Editorial 123'),

("28", 'La inquietud del rosal', 'La inquietud del rosal', 150, '1916-08-22', 'Español', 'af38439b-992f-40c1-b471-96f8d9d36c1a', 'poesia', 'Editorial XYZ'),
("29", 'Irremediablemente', 'Irremediablemente', 120, '1919-03-10', 'Español', 'af38439b-992f-40c1-b471-96f8d9d36c1a', 'poesia', 'Editorial ABC'),
("30", 'Mundo de siete pozos', 'Mundo de siete pozos', 200, '1934-11-15', 'Español', 'af38439b-992f-40c1-b471-96f8d9d36c1a', 'poesia', 'Editorial 123'),

("31", 'El hombre muerto', 'El hombre muerto', 200, '1972-08-18', 'Español', '3c7a888d-e199-4012-aac6-bf33a13e5e9b', 'teatro', 'Editorial XYZ'),
("32", 'Las estaciones de la locura', 'Las estaciones de la locura', 180, '1981-11-25', 'Español', '3c7a888d-e199-4012-aac6-bf33a13e5e9b', 'poesia', 'Editorial ABC'),
("33", 'Ake: Los años de la infancia', 'Ake:Los años de la infancia', 300, '1981-04-15', 'Español', '3c7a888d-e199-4012-aac6-bf33a13e5e9b', 'memoria', 'Editorial 123'),


("36", 'El camino de los sueños', 'El camino de los sueños', 200, '1941-09-30', 'Español', '6b87be42-4988-4c5d-82cf-2b9e9f1200fb', 'novela', 'Editorial 123'),

("37", 'Pedro Páramo', 'Pedro Páramo', 250, '1955-06-10', 'Español', '7a9c8b14-682b-4ee1-8e90-50c554ce04c8', 'ciencia_ficcion', 'Editorial XYZ'),
("38", 'El llano en llamas', 'El llano en llamas', 180, '1953-03-15', 'Español', '7a9c8b14-682b-4ee1-8e90-50c554ce04c8', 'cuento', 'Editorial ABC'),
("39", 'Juan Rulfo: Otras miradas', 'Otras miradas', 220, '2002-11-20', 'Español', '7a9c8b14-682b-4ee1-8e90-50c554ce04c8', 'memoria', 'Editorial 123'),

("40", 'Niebla', 'Niebla', 300, '1914-09-30', 'Español', 'f4dd2d87-6121-46e7-8da2-6f8716e0b72b', 'novela', 'Editorial XYZ'),
("41", 'San Manuel Bueno, mártir', 'San Manuel Bueno,mártir', 150, '1933-02-15', 'Español', 'f4dd2d87-6121-46e7-8da2-6f8716e0b72b', 'ciencia_ficcion', 'Editorial ABC'),
("42", 'Del sentimiento trágico de la vida', 'Del sentimiento trágico de la vida', 220, '1913-11-25', 'Español', 'f4dd2d87-6121-46e7-8da2-6f8716e0b72b', 'ensayo', 'Editorial 123'),

("43", 'Don Quijote de la Mancha', 'Don Quijote de la Mancha', 500, '1605-01-16', 'Español', '81a4c7a7-58d9-4ff7-986f-725a9e95020d', 'novela', 'Editorial XYZ'),
("44", 'Rinconete y Cortadillo', 'Rinconete Cortadillo', 100, '1613-11-12', 'Español', '81a4c7a7-58d9-4ff7-986f-725a9e95020d', 'novela', 'Editorial ABC'),
("45", 'La Galatea', 'La Galatea', 250, '1585-04-01', 'Español', '81a4c7a7-58d9-4ff7-986f-725a9e95020d', 'novela', 'Editorial 123'),

("46", 'El laberinto de la soledad', 'El laberinto de la soledad', 200, '1950-09-30', 'Español', 'e057865e-6a64-4324-9da1-dc8b42e27a2d', 'ensayo', 'Editorial XYZ'),
("47", 'Piedra de sol', 'Piedra de sol', 150, '1957-02-15', 'Español', 'e057865e-6a64-4324-9da1-dc8b42e27a2d', 'poesia', 'Editorial ABC'),
("48", 'In Light of India', 'In Light of India', 300, '1995-06-20', 'Inglés', 'e057865e-6a64-4324-9da1-dc8b42e27a2d', 'ensayo', 'Editorial 123'),

("49", 'La metamorfosis', 'La metamorfosis', 150, '1915-10-15', 'Español', '8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899', 'ciencia_ficcion', 'Editorial XYZ'),
("50", 'El proceso', 'El proceso', 250, '1925-04-26', 'Español', '8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899', 'novela', 'Editorial ABC'),
("51", 'El castillo', 'El castillo', 200, '1926-06-20', 'Español', '8d88f9d5-2e87-4c4e-9fe6-cb5bdfb5f899', 'ciencia_ficcion', 'Editorial 123'),

("52", 'El club de la buena estrella', 'El club de la buena estrella', 300, '1989-03-10', 'Español', '8a20f7d8-2f47-44aa-9e91-f5ac54f54594', 'ciencia_ficcion', 'Editorial XYZ'),
("54", 'El arco iris de la gravedad', 'El arco iris de la gravedad', 180, '1995-07-28', 'Español', '8a20f7d8-2f47-44aa-9e91-f5ac54f54594', 'ciencia_ficcion', 'Editorial 123'),

("55", 'Los gallinazos sin plumas', 'Los gallinazos sin plumas', 120, '1954-11-12', 'Español', '55d4d6a5-6325-4e0f-b241-c7f8997ce14e', 'cuento', 'Editorial XYZ'),
("56", 'La palabra del mudo', 'La palabra del mudo', 150, '1953-06-10', 'Español', '55d4d6a5-6325-4e0f-b241-c7f8997ce14e', 'cuento', 'Editorial ABC'),
("57", 'Silvio en El Rosedal', 'Silvio en El Rosedal', 200, '1965-03-20', 'Español', '55d4d6a5-6325-4e0f-b241-c7f8997ce14e', 'novela', 'Editorial 123'),

("58", 'Los trabajos y las noches', 'Los trabajos y las noches', 180, '1965-07-28', 'Español', '8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222', 'poesia', 'Editorial XYZ'),
("59", 'La condesa sangrienta', 'La condesa sangrienta', 150, '1971-09-15', 'Español', '8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222', 'memoria', 'Editorial ABC'),
("60", 'Árbol de Diana', 'Árbol de Diana', 220, '1962-11-25', 'Español', '8b1b51d1-7d1c-4c78-909d-1c6e1ee8c222', 'poesia', 'Editorial 123'),

("61", 'El diario de Ana Frank', 'El Diario de Ana Frank', 250, '1947-06-25', 'Español', 'f8485361-4d88-4935-ba76-55f3da2a7db4', 'memoria', 'Editorial XYZ'),
("62", 'Cuentos de la casa de atrás', 'Cuentos de la casa de atrás', 180, '1959-09-10', 'Español', 'f8485361-4d88-4935-ba76-55f3da2a7db4', 'cuento', 'Editorial ABC'),

("64", 'La región más transparente', 'La región más transparente', 400, '1958-08-30', 'Español', 'ffddc101-4f0e-43f8-aa5b-8c68390a6b3a', 'ciencia_ficcion', 'Editorial XYZ'),
("65", 'La muerte de Artemio Cruz', 'La muerte de Artemio Cruz', 350, '1962-02-15', 'Español', 'ffddc101-4f0e-43f8-aa5b-8c68390a6b3a', 'novela', 'Editorial ABC'),
("66", 'Gringo viejo', 'Gringo viejo', 320, '1985-06-20', 'Español', 'ffddc101-4f0e-43f8-aa5b-8c68390a6b3a', 'memoria', 'Editorial 123'),

("67", 'Asesinato en el Orient Express', 'Asesinato en el Orient Express', 250, '1934-01-28', 'Español', '0cb152c2-c8b7-4c80-99b5-2821ef5f77c8', 'novela', 'Editorial XYZ'),
("68", 'Diez negritos', 'Diez negritos', 180, '1939-03-10', 'Español', '0cb152c2-c8b7-4c80-99b5-2821ef5f77c8', 'ciencia_ficcion', 'Editorial ABC'),
("69", 'El asesinato de Roger Ackroyd', 'El asesinato de Roger Ackroyd', 220, '1926-11-25', 'Español', '0cb152c2-c8b7-4c80-99b5-2821ef5f77c8', 'novela', 'Editorial 123'),

("70", 'Veinte poemas de amor y una canción desesperada', 'Veinte poemas de amor y una canción desesperada', 150, '1924-09-30', 'Español', '078070ae-ba21-4c52-91f3-b4e3a071cd42', 'poesia', 'Editorial XYZ'),
("71", 'Canto general', 'Canto general', 300, '1950-02-15', 'Español', '078070ae-ba21-4c52-91f3-b4e3a071cd42', 'ciencia_ficcion', 'Editorial ABC'),
("72", 'Confieso que he vivido', 'Confieso que he vivido', 220, '1974-06-20', 'Español', '078070ae-ba21-4c52-91f3-b4e3a071cd42', 'memoria', 'Editorial 123'),

("73", 'Oficio de tinieblas', 'Oficio de tinieblas', 200, '1962-07-28', 'Español', '5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4', 'poesia', 'Editorial XYZ'),
("74", 'Balún Canán', 'Balún Canán', 250, '1957-09-15', 'Español', '5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4', 'novela', 'Editorial ABC'),
("75", 'Mujer que sabe latín... sabe un montón de cosas', 'Mujer que sabe latín... sabe un montón de cosas', 180, '1973-11-25', 'Español', '5c114f5d-b11f-4b8c-89e4-2ad3e3f8a0f4', 'ensayo', 'Editorial 123'),

("76", 'Como agua para chocolate', 'Como agua para chocolate', 250, '1989-03-30', 'Español', 'a0cb4a55-5b24-4e65-b485-0c0418e0f781', 'ciencia_ficcion', 'Editorial XYZ'),
("77", 'La ley del amor', 'La ley del amor', 300, '1995-08-15', 'Español', 'a0cb4a55-5b24-4e65-b485-0c0418e0f781', 'ciencia_ficcion', 'Editorial ABC'),
("78", 'Tan veloz como el deseo', 'Tan veloz como el deseo', 220, '2001-06-20', 'Español', 'a0cb4a55-5b24-4e65-b485-0c0418e0f781', 'novela', 'Editorial 123'),

("79", 'Lagar', 'Lagar', 150, '1954-11-12', 'Español', '0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38', 'poesia', 'Editorial XYZ'),
("80", 'Desolación', 'Desolación', 120, '1922-09-15', 'Español', '0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38', 'poesia', 'Editorial ABC'),
("81", 'Lagar II', 'Lagar II', 200, '1954-03-20', 'Español', '0370fb8e-b8a4-4e76-9b1d-ba4c3bbf3b38', 'poesia', 'Editorial 123');