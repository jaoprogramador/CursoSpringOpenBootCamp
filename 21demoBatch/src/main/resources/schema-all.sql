DROP TABLE empleado IF EXISTS;


CREATE TABLE empleado (
	id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    dni VARCHAR(10) UNIQUE NOT NULL,
    sexo VARCHAR(10) CHECK (sexo IN ('Masculino', 'Femenino')) NOT NULL,
    profesion VARCHAR(100) NOT NULL
);
