import java.util.ArrayList;
public class Biblioteca {

    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public ArrayList<Libro> obtenerLibros() {
        return libros;
    }

    public ArrayList<Libro> buscarPorAutor(String autor) {

        ArrayList<Libro> encontrados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getAutor().equals(autor)) {
                encontrados.add(libro);
            }
        }

        return encontrados;
    }
    public ArrayList<Libro> buscarPorTitulo(String titulo) {

        ArrayList<Libro> encontrados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().equals(titulo)) {
                encontrados.add(libro);
            }
        }

        return encontrados;
    }

    public Libro buscarPorCodigo(String codigo) {

        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }

        return null;
    }

    public void eliminarLibro(String codigo) {

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getCodigo().equals(codigo)) {
                libros.remove(i);
                return;
            }
        }
    }

    public boolean prestarLibro(String codigo) {

        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                if (libro.getCopias() > 0) {
                    libro.setCopias(libro.getCopias() - 1);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean devolverLibro(String codigo) {

        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                libro.setCopias(libro.getCopias() + 1);
                return true;
            }
        }

        return false;
    }

    public void mostrarLibros() {

        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Código: " + libro.getCodigo());
            System.out.println("Género: " + libro.getGenero());
            System.out.println("Año: " + libro.getAño());
            System.out.println("Copias: " + libro.getCopias());
            System.out.println("----------------------");
        }
    }
}
