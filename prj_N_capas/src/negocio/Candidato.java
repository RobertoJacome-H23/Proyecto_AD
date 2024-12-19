package negocio;

import java.util.Date;

public class Candidato {
    private String cedula;
    private String nombre;
    private Date fechaNacimiento;

    public Candidato(String cedula, String nombre, Date fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
}
