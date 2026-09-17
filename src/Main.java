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

        biblioteca.agregarLibro(libro1);

        ArrayList<Libro> resultadosTitulo = biblioteca.buscarPorTitulo("Cien años de soledad");

        for (Libro libro : resultadosTitulo) {
            System.out.println("Encontrado por título: " + libro.getTitulo());
        }

        Libro resultadoCodigo = biblioteca.buscarPorCodigo("001");

        if (resultadoCodigo != null) {
            System.out.println("Encontrado por código: " + resultadoCodigo.getTitulo());
        }

        ArrayList<Libro> resultados = biblioteca.buscarPorAutor("Gabriel García Márquez");

        for (Libro libro : resultados) {
            System.out.println("Encontrado: " + libro.getTitulo());
        }

        biblioteca.prestarLibro("001");
        biblioteca.devolverLibro("001");

        biblioteca.mostrarLibros();
    }
}