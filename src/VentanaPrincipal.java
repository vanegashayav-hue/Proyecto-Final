import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JPanel panelPrincipal;
    private JTable tablaLibros;

    private JTextField campoTitulo;
    private JTextField campoAutor;
    private JTextField campoCodigo;
    private JTextField campoGenero;
    private JTextField campoAño;
    private JTextField campoCopias;

    private Biblioteca biblioteca;

    public VentanaPrincipal() {

        biblioteca = new Biblioteca();

        setTitle("Gestión de Biblioteca");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel(new BorderLayout(10, 10));
        add(panelPrincipal);

        // Título
        JLabel titulo = new JLabel("Gestión de Biblioteca");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        // Formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));

        // Título del libro
        JPanel filaTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaTitulo.add(new JLabel("Título:"));
        campoTitulo = new JTextField(15);
        filaTitulo.add(campoTitulo);

        // Autor
        JPanel filaAutor = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaAutor.add(new JLabel("Autor:"));
        campoAutor = new JTextField(15);
        filaAutor.add(campoAutor);

        // Código
        JPanel filaCodigo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaCodigo.add(new JLabel("Código:"));
        campoCodigo = new JTextField(15);
        filaCodigo.add(campoCodigo);

        // Género
        JPanel filaGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaGenero.add(new JLabel("Género:"));
        campoGenero = new JTextField(15);
        filaGenero.add(campoGenero);

        // Año
        JPanel filaAño = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaAño.add(new JLabel("Año:"));
        campoAño = new JTextField(15);
        filaAño.add(campoAño);

        // Copias
        JPanel filaCopias = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filaCopias.add(new JLabel("Copias:"));
        campoCopias = new JTextField(15);
        filaCopias.add(campoCopias);

        panelFormulario.add(filaTitulo);
        panelFormulario.add(filaAutor);
        panelFormulario.add(filaCodigo);
        panelFormulario.add(filaGenero);
        panelFormulario.add(filaAño);
        panelFormulario.add(filaCopias);

        // Panel superior: título + formulario
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));

        panelSuperior.add(titulo);
        panelSuperior.add(panelFormulario);

        panelPrincipal.add(panelSuperior, BorderLayout.NORTH);

        // Botones
        JPanel panelBotones = new JPanel();

        JButton botonAgregar = new JButton("Agregar libro");
        JButton botonFiltrar = new JButton("Filtrar por autor");
        JButton botonMostrar = new JButton("Mostrar todos");
        JButton botonEliminar = new JButton("Eliminar libro");

        panelBotones.add(botonAgregar);
        panelBotones.add(botonFiltrar);
        panelBotones.add(botonMostrar);
        panelBotones.add(botonEliminar);

        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Tabla
        String[] columnas = {
                "Título",
                "Autor",
                "Código",
                "Género",
                "Año",
                "Copias"
        };

        tablaLibros = new JTable(
                new javax.swing.table.DefaultTableModel(columnas, 0)
        );

        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);

        // AGREGAR LIBRO
        botonAgregar.addActionListener(e -> {

            String tituloLibro = campoTitulo.getText().trim();
            String autorLibro = campoAutor.getText().trim();
            String codigoLibro = campoCodigo.getText().trim();
            String generoLibro = campoGenero.getText().trim();
            String añoTexto = campoAño.getText().trim();
            String copiasTexto = campoCopias.getText().trim();

            if (tituloLibro.isEmpty() || autorLibro.isEmpty()
                    || codigoLibro.isEmpty() || generoLibro.isEmpty()
                    || añoTexto.isEmpty() || copiasTexto.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "Todos los campos son obligatorios."
                );
                return;
            }

            try {

                int año = Integer.parseInt(añoTexto);
                int copias = Integer.parseInt(copiasTexto);

                int añoActual = java.time.Year.now().getValue();

                if (año > añoActual) {
                    JOptionPane.showMessageDialog(
                            this,
                            "El año no puede ser mayor al año actual."
                    );
                    return;
                }

                if (copias < 0) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Las copias no pueden ser negativas."
                    );
                    return;
                }

                Libro libro = new Libro(
                        tituloLibro,
                        autorLibro,
                        codigoLibro,
                        generoLibro,
                        año,
                        copias
                );

                if (!biblioteca.agregarLibro(libro)) {

                    JOptionPane.showMessageDialog(
                            this,
                            "Ya existe un libro con ese código."
                    );
                    return;
                }

                JOptionPane.showMessageDialog(
                        this,
                        "Libro agregado correctamente."
                );

                actualizarTabla(biblioteca.obtenerLibros());
                limpiarCampos();

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "El año y las copias deben ser números."
                );
            }
        });

        // MOSTRAR TODOS
        botonMostrar.addActionListener(e -> {
            actualizarTabla(biblioteca.obtenerLibros());
        });

        // FILTRAR POR AUTOR
        botonFiltrar.addActionListener(e -> {

            String autor = JOptionPane.showInputDialog(
                    this,
                    "Ingrese el nombre del autor:"
            );

            if (autor == null || autor.trim().isEmpty()) {
                return;
            }

            ArrayList<Libro> librosFiltrados =
                    biblioteca.buscarPorAutor(autor.trim());

            if (librosFiltrados.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this,
                        "No se encontraron libros de ese autor."
                );

                return;
            }

            actualizarTabla(librosFiltrados);

            JOptionPane.showMessageDialog(
                    this,
                    "Filtro aplicado correctamente."
            );
        });

        // ELIMINAR LIBRO
        botonEliminar.addActionListener(e -> {

            int filaSeleccionada = tablaLibros.getSelectedRow();

            if (filaSeleccionada == -1) {

                JOptionPane.showMessageDialog(
                        this,
                        "Seleccione un libro de la tabla para eliminar."
                );

                return;
            }

            String codigo = tablaLibros
                    .getValueAt(filaSeleccionada, 2)
                    .toString();

            int respuesta = JOptionPane.showConfirmDialog(
                    this,
                    "¿Está seguro de eliminar este libro?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (respuesta == JOptionPane.YES_OPTION) {

                biblioteca.eliminarLibro(codigo);

                actualizarTabla(biblioteca.obtenerLibros());

                JOptionPane.showMessageDialog(
                        this,
                        "Libro eliminado correctamente."
                );
            }
        });
    }

    private void actualizarTabla(ArrayList<Libro> libros) {

        javax.swing.table.DefaultTableModel modelo =
                (javax.swing.table.DefaultTableModel) tablaLibros.getModel();

        modelo.setRowCount(0);

        for (Libro libro : libros) {

            modelo.addRow(new Object[]{
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getCodigo(),
                    libro.getGenero(),
                    libro.getAño(),
                    libro.getCopias()
            });
        }
    }

    private void limpiarCampos() {

        campoTitulo.setText("");
        campoAutor.setText("");
        campoCodigo.setText("");
        campoGenero.setText("");
        campoAño.setText("");
        campoCopias.setText("");
    }
}