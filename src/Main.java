import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro(
                "Cien años de soledad",
                "Gabriel García Márquez",
                "001",
                "Novela",
                1967,
                3
        );

        Libro libro2 = new Libro(
                "El principito",
                "Antoine de Saint-Exupéry",
                "002",
                "Fantasía",
                1943,
                2
        );

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);

        Libro libro3 = new Libro(
                "Otro libro",
                "Otro autor",
                "001",
                "Novela",
                2020,
                1
        );

        boolean agregado = biblioteca.agregarLibro(libro3);

        if (agregado) {
            System.out.println("El libro fue agregado.");
        } else {
            System.out.println("No se puede agregar: el código ya existe.");
        }

        // Buscar por título
        ArrayList<Libro> resultadosTitulo =
                biblioteca.buscarPorTitulo("Cien años de soledad");

        for (Libro libro : resultadosTitulo) {
            System.out.println("Encontrado por título: " + libro.getTitulo());
        }

        // Buscar por autor
        ArrayList<Libro> resultados =
                biblioteca.buscarPorAutor("Gabriel García Márquez");

        for (Libro libro : resultados) {
            System.out.println("Encontrado por autor: " + libro.getTitulo());
        }

        // Buscar por código
        Libro resultadoCodigo = biblioteca.buscarPorCodigo("001");

        if (resultadoCodigo != null) {
            System.out.println("Encontrado por código: " + resultadoCodigo.getTitulo());
        }

        // Prestar y devolver
        biblioteca.prestarLibro("001");
        biblioteca.devolverLibro("001");

        // Probar préstamos hasta llegar a 0 copias
        biblioteca.prestarLibro("002");
        biblioteca.prestarLibro("002");
        biblioteca.prestarLibro("002");

        System.out.println("Copias de El principito: " + libro2.getCopias());

        // Buscar un libro que no existe
        Libro libroNoEncontrado = biblioteca.buscarPorCodigo("999");

        if (libroNoEncontrado == null) {
            System.out.println("El libro no fue encontrado.");
        }

        // Mostrar todos los libros
        biblioteca.mostrarLibros();

        // Eliminar un libro

        biblioteca.eliminarLibro("001");
        System.out.println("Después de eliminar el libro:");
        biblioteca.mostrarLibros();
    }
}