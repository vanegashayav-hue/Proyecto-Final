public class Libro {

        private String titulo;
        private String autor;
        private String codigo;
        private String genero;
        private int año;
        private int copias;

    public Libro(String titulo, String autor, String codigo, String genero, int año, int copias) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.genero = genero;
        this.año = año;
        this.copias = copias;
    }
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAño() {
        return año;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
}
