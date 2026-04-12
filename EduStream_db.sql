-- 1. Creación de la Base de Datos
CREATE DATABASE IF NOT EXISTS edustream_db;
USE edustream_db;

-- 2. Tabla de Usuarios (Aplica Herencia en Java: Estudiante/Profesor)
CREATE TABLE usuarios (
id_usuario INT AUTO_INCREMENT PRIMARY KEY,
nombre VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
rol ENUM('ESTUDIANTE', 'PROFESOR') NOT NULL,
fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 3. Tabla de Cursos (Gestionada por el Profesor)
CREATE TABLE cursos (
id_curso INT AUTO_INCREMENT PRIMARY KEY,
nombre_curso VARCHAR(150) NOT NULL,
descripcion TEXT,
id_profesor INT,
FOREIGN KEY (id_profesor) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

-- 4. Tabla de Inscripciones (Relación Muchos a Muchos entre Estudiante y Curso)
CREATE TABLE inscripciones (
id_inscripcion INT AUTO_INCREMENT PRIMARY KEY,
id_estudiante INT,
id_curso INT,
fecha_inscripcion DATE,
FOREIGN KEY (id_estudiante) REFERENCES usuarios(id_usuario) ON DELETE CASCADE,
FOREIGN KEY (id_curso) REFERENCES cursos(id_curso) ON DELETE CASCADE
);

-- 5. Datos de Prueba para iniciar el proyecto

-- usuarios de prueba
INSERT INTO usuarios (nombre, email, password, rol) VALUES
('Admin Profesor', 'profe@edustream.com', '123456', 'PROFESOR'),
('Juan Estudiante', 'juan@correo.com', '123456', 'ESTUDIANTE'),
('ADMIN', 'soporte1@utc.ac.cr', 'admin', 'PROFESOR'),
('ADMIN', 'soporte2@utc.ac.cr', 'admin', 'PROFESOR');

-- cursos de prueba
INSERT INTO cursos (nombre_curso, descripcion, id_profesor) VALUES
('Java SE Avanzado', 'Dominio de POO y colecciones.', 1),
('Desarrollo Web con Java EE', 'Servlets, JSP y JDBC.', 1);

-- inscripcion de prueba 
INSERT INTO inscripciones (id_estudiante, id_curso, fecha_inscripcion) 
VALUES (2, 1, CURDATE());
