package hospital;

import consultas.Consulta;
import consultorios.Consultorio;
import medicos.Medico;
import pacientes.Paciente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Hospital {

    public ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public ArrayList<Medico> listaMedicos = new ArrayList<>();

    public ArrayList<Consulta> listaConsulta = new ArrayList<>();

    public ArrayList<Consultorio> listaConsultorio = new ArrayList<>();


    private ValidadorHospital validador = new ValidadorHospital();

    Random ran = new Random();

    public void registrarPaciente(Paciente paciente) {
        this.listaPacientes.add(paciente);
    }

    public void registrarMedico(Medico medico) {
        this.listaMedicos.add(medico);
    }

  /*  public void registrarConsulta(Consulta consulta) {
        // Paciente no tenga una consulta en esa fecha

        if (!validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getConsultorio().getNumeroConsultorio(), this.listaConsulta)) {
            System.out.println("Ya existe una consulta registrada para esa fecha");
            return;
        }

        this.listaConsulta.add(consulta);

        if (validador.validarDisponibilidadEnFecha(consulta.getFechaHora(), consulta.getMedico().getId(), this.listaConsulta)) {
            System.out.println("El medico no tiene disponibilidad para esa fecha");
            return;
        }
    }*/
    public void registrarConsultorio(Consultorio consultorio) {
        this.listaConsultorio.add(consultorio);
    }

    public void mostrarPaciente() {
        if (this.listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados :(");
            return;
        }
        for (Paciente paciente : this.listaPacientes) {
            System.out.println(paciente.mostrarDatos());
        }
    }

    private boolean validarDisponibilidadMedico(String fehcaDeseada, String idMedico) {
        for (Consulta consulta : listaConsulta) {
            if (consulta.getFechaHora().equals(fehcaDeseada) && consulta.getMedico().getId() == idMedico) {
                return false;
            }
        }

        return true;
    }

    public void mostrarConsultorios() {

        if (this.listaConsultorio.isEmpty()) {
            System.out.println("No hay consultorios registrados :(");
            return;
        }
        for (Consultorio consultorio : this.listaConsultorio) {

            consultorio.mostrarConsultorio();
        }
    }

    public void mostrarMedicos() {
        if (this.listaMedicos.isEmpty()) {
            System.out.println("\nNo hay médicos registrados :(");
            return;
        }
        for (Medico medico : this.listaMedicos) {

            medico.mostrarMedico();
        }
    }

    public String generarIDpaciente() {
        //P(paciente)-(año actual)-(mes actual)-longitud de la lista pacientes + 1)-(1-100000)
        LocalDate fecha = LocalDate.now();
        int añoActual = fecha.getYear();
        int mesActual = fecha.getMonthValue();
        int longitudPacientesMasUno = this.listaPacientes.size() + 1;
        int numeroAleatorio = ran.nextInt(1, 100000);

        String id = String.format("P%d%d%d%d", añoActual, mesActual, longitudPacientesMasUno, numeroAleatorio).toUpperCase();
        return id;
    }

    public String generarIDMedico(String apellidos, String FechaNac){
        //M-(Primeras dos letras de su apellido)-(último dígito de su año de nacimiento)-(Año actual)-(Número
        // aleatorio entre 50 y 700000)-(longitud de la lista de médicos + 1)

        LocalDate fecha = LocalDate.now();
        int añoActual = fecha.getYear();
        char PrimerLetra=apellidos.charAt(0);
        char SegundaLetra=apellidos.charAt(1);
        char digitoaño=FechaNac.charAt(3);
        int numero= ran.nextInt(50, 700000);
        int longitud= this.listaMedicos.size() + 1;

        String id= String.format("M%s%c%c%d%d%d", PrimerLetra,SegundaLetra,digitoaño,añoActual,numero,longitud).toUpperCase();
        return id;
    }
    public String generarIDConsultorio(){
        //C-(Longitud de la lista de consultorios + 1)-dia actual)-(añoactual)-numeroaleatorio entre 1 y 500000)

        LocalDate fecha = LocalDate.now();
        int diaActual = fecha.getDayOfMonth();
        int añoActual = fecha.getYear();
        int numero= ran.nextInt(1, 500000);
        int longitud= this.listaMedicos.size() + 1;

        String id= String.format("C%d%d%d%d", longitud,diaActual,añoActual,numero).toUpperCase();
        return id;
    }
    public void mostrarPacientePorID(String id) {
      Optional<Paciente> pacienteEncontrado = this.listaPacientes.stream().filter(paciente -> paciente.getId().equals(id)).findFirst();
            if (pacienteEncontrado.isPresent()) {
                System.out.print(pacienteEncontrado.get().mostrarDatos());
            }
            else {
                System.out.println("\nPaciente no encontrado.");
            }
     }
     public void mostrarMedicoPorID(String id) {
        Optional<Medico> medicoEncontrado = this.listaMedicos.stream().filter(medico -> medico.getId().equals(id)).findFirst();
        if (medicoEncontrado.isPresent()) {
            medicoEncontrado.get().mostrarMedico();
        }
        else {
            System.out.println("\nMédico no encontrado.");
        }
    }
    public void mostrarConsultorioPorID(String id) {
        Optional<Consultorio> consultorioEncontrado = this.listaConsultorio.stream().filter(consultorio -> consultorio.getId().equals(id)).findFirst();
        if (consultorioEncontrado.isPresent()) {
            consultorioEncontrado.get().mostrarConsultorio();
        }
        else {
            System.out.println("\nConsultorio no encontrado.");
        }
    }
}




