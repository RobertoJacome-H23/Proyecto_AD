package presentacion.Biblioteca;

import javax.swing.*;
import negocio.BibliotecaNegocio;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AutorForm extends javax.swing.JFrame {
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;
    private JButton btnBuscar;

    public AutorForm() {
        setTitle("Módulo de Biblioteca - Gestión de Autores");
        setSize(500, 400); // Tamaño adecuado para una buena visibilidad
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Entrada de Autor
        panel.add(new JLabel("Nombre Autor:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Apellido Autor:"));
        txtApellido = new JTextField();
        panel.add(txtApellido);

        // Botones de Acciones
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");
        btnBuscar = new JButton("Buscar");

        panel.add(btnGuardar);
        panel.add(btnModificar);
        panel.add(btnEliminar);
        panel.add(btnBuscar);

        add(panel);

        // Acción al presionar Guardar
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            BibliotecaNegocio negocio = new BibliotecaNegocio();
            negocio.agregarAutor(nombre, apellido); // Código generado automáticamente
            JOptionPane.showMessageDialog(this, "Autor guardado exitosamente.");
        });

        // Acción al presionar Buscar
        btnBuscar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            BibliotecaNegocio negocio = new BibliotecaNegocio();
            ResultSet rs = negocio.buscarAutor(nombre, apellido);

            try {
                if (rs.next()) {
                    txtNombre.setText(rs.getString("nombre"));
                    txtApellido.setText(rs.getString("apellido"));
                    JOptionPane.showMessageDialog(this, "Autor encontrado.");
                } else {
                    JOptionPane.showMessageDialog(this, "Autor no encontrado.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error al buscar el autor: " + ex.getMessage());
            }
        });
        
        // Acción al presionar Modificar
        btnModificar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            BibliotecaNegocio negocio = new BibliotecaNegocio();
            negocio.modificarAutor(nombre, apellido);
            JOptionPane.showMessageDialog(this, "Autor modificado exitosamente.");
        });

        // Acción al presionar Eliminar
        btnEliminar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            BibliotecaNegocio negocio = new BibliotecaNegocio();
            negocio.eliminarAutor(nombre, apellido);
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Autor eliminado exitosamente.");
        });
        
        // Acción al presionar Guardar
        btnGuardar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();

            BibliotecaNegocio negocio = new BibliotecaNegocio();
            negocio.agregarAutor(nombre, apellido); // Código generado automáticamente
            JOptionPane.showMessageDialog(this, "Autor guardado exitosamente.");
        });

        // Botón de regresar
        JButton btnRegresar = new JButton("Regresar");
        panel.add(btnRegresar);

        btnRegresar.addActionListener(e -> {
            this.dispose(); // Cierra la ventana
        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            AutorForm form = new AutorForm();
            form.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
