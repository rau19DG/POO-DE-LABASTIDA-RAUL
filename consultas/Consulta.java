package consultas;

import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDateTime;

public class Consulta {
    public String id;
    public LocalDateTime fechaHora;
    public Paciente paciente;
    public Medico medico;
    public Consultorio consultorio;

    public Consulta(String id, LocalDateTime fechaHora, Paciente paciente, Medico medico, Consultorio consultorio) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.medico = medico;
        this.consultorio = consultorio;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public Consultorio getConsultorio() { return consultorio; }

    public String mostrarDatos() {
        return String.format("Id: %s  |  Fecha: %s  |  Id Paciente: %s  |  Paciente: %s  |  Id Medico: %s  |  Médico: %s  |  Piso Consultorio: %d  |  Numero Consultorio: %d",
                getId(),
                getFechaHora(),
                paciente.getId(),
                paciente.getNombre(),
                medico.getId(),
                medico.getNombre(),
                consultorio.getPiso(),
                consultorio.getNumeroConsultorio()
        );
    }
}