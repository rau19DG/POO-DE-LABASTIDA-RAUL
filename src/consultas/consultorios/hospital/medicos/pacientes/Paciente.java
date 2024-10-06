package pacientes;

import java.util.Random;

public class Paciente {
    Random rand = new Random();

    public String id;
    public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    private String telefono;
    public String tipoSangre;
    public char sexo;

    public Paciente(String id, String nombre, String apellidos, String fechaNacimiento, String telefono, String tipoSangre, char sexo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.tipoSangre = tipoSangre;
        this.sexo = sexo;

    }
    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String mostrarDatos() {
        String datos = String.format(
            "\nId: %s \nNombre: %s \nApellidos: %s \nFecha de nacimientos: %s \nTipo de sangre: %s \nSexo: %s \nTelefono: %s",
            id, nombre, apellidos, fechaNacimiento, tipoSangre, sexo, telefono
            );
        return datos;
        }
}


