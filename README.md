# Sistema de Gestión de Biblioteca

## Descripción

Aplicación de escritorio desarrollada en Java para gestionar los libros de una biblioteca.

El proyecto utiliza programación orientada a objetos (POO) y Java Swing para crear la interfaz gráfica.

## Funcionalidades

- Crear libros.
- Mostrar todos los libros.
- Filtrar libros por autor.
- Eliminar libros.
- Validar campos obligatorios.
- Validar códigos de libros repetidos.
- Validar el año de publicación.
- Validar la cantidad de copias.

## Tecnologías

- Java
- Java Swing
- ArrayList
- HashMap
- Interfaz Prestable
- Git
- GitHub

## Estructura del proyecto

- `Libro`: representa los libros de la biblioteca y contiene sus datos.
- `Biblioteca`: administra la colección de libros y las operaciones principales.
- `Prestable`: define las operaciones de préstamo y devolución.
- `VentanaPrincipal`: contiene la interfaz gráfica de la aplicación.
- `Main`: inicia la aplicación.

## Programación Orientada a Objetos

El proyecto utiliza:

- Encapsulamiento mediante atributos privados y métodos getters y setters.
- Constructores para crear objetos `Libro`.
- Métodos para organizar las diferentes operaciones.
- Una interfaz llamada `Prestable` para definir el comportamiento de préstamo y devolución.

## Estructuras de datos

- `ArrayList` para almacenar los libros.
- `HashMap` para buscar los libros mediante su código.

## Cómo ejecutar el proyecto

1. Abrir el proyecto en IntelliJ IDEA.
2. Abrir la clase `Main.java`.
3. Ejecutar el método `main`.
4. Se abrirá la ventana de Gestión de Biblioteca.

## Autor

Proyecto realizado para el Taller Práctico de Java - Programación Orientada a Objetos.