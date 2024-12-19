package persistencia;

import java.sql.*;
import java.util.*;
import recursos.conexion.conexion;
import negocio.Candidato;

public class CandidatoDAO {
    public List<Candidato> obtenerCandidatos() throws SQLException {
        List<Candidato> lista = new ArrayList<>();
        Connection conn = conexion.obtenerConexion();
        String query = "SELECT * FROM candidato";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            lista.add(new Candidato(
                rs.getString("cedula"),
                rs.getString("nombre"),
                rs.getDate("fecha_nacimiento")
            ));
        }
        conn.close();
        return lista;
    }

    public void insertarCandidato(Candidato candidato) throws SQLException {
        Connection conn = conexion.obtenerConexion();
        String query = "INSERT INTO candidato VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, candidato.getCedula());
        stmt.setString(2, candidato.getNombre());
        stmt.setDate(3, new java.sql.Date(candidato.getFechaNacimiento().getTime()));
        stmt.executeUpdate();
        conn.close();
    }
}
