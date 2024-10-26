package menu;

import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import usuarios.administradores.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.utils.Rol;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.SimpleTimeZone;

public class MenuAdministrador {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n*** SISTEMA HOSPITAL ***");
        System.out.println("\n** Menu **");
        System.out.println("1.- Registrar Pacientes");
        System.out.println("2.- Registrar Medicos");
        System.out.println("3.- Registrar Consultorio");
        System.out.println("4.- Registrar Consulta");
        System.out.println("5.- Mostrar Pacientes");
        System.out.println("6.- Mostrar Medicos");
        System.out.println("7.- Mostrar Consultorios");
        System.out.println("8.- Mostrar Consultas");
        System.out.println("9.- Buscar Paciente por Id");
        System.out.println("10. Buscar Medico por Id");
        System.out.println("11. Buscar Consultorio por Id");
        System.out.println("12. Registrar administrador");
        System.out.println("13. Mostrar administradores");
        System.out.println("14. Mostrar mi Información");
        System.out.println("15. Salir");

        System.out.print("Selecciona una opción: ");
        return scanner.nextInt();
    }

    public void procesaeDatosMenu(int opcion, Hospital hospital, Administrador admin) {
        switch (opcion) {
            case 1:
                System.out.println("\n--Seleccionaste la opción de registrar pacientes--");

                String id = hospital.generarIdPaciente();

                ArrayList<String> datosPaciente = this.obtenerDatosComun(Rol.PACIENTE);

                String nombrePaciente = datosPaciente.get(0);
                String apellidosPaciente = datosPaciente.get(1);
                LocalDate fechaNacimientoPaciente = LocalDate.parse(datosPaciente.get(2));
                String telefonoPaciente = datosPaciente.get(3);
                String contraseniaPaciente = datosPaciente.get(4);

                System.out.print("Ingresa el tipo de sangre: ");
                String tipoSangre = scanner.nextLine();

                scanner.nextLine();

                System.out.print("Ingresa el sexo: ");
                String sexo2 = scanner.nextLine();
                char sexo = sexo2.charAt(0);

                /*String telefono = null;

                while (telefono == null){
                    System.out.print("Ingresa el numero de telefono: ");
                    telefono = scanner.nextLine();

                    if (!hospital.validarTelefonoPaciente(telefono)) {
                        System.out.println("\nYa exixte un paciente con el mismo numero de telefono, intente de nuevo\n");
                        telefono = null;
                    }
                }*/

                Paciente paciente = new Paciente(id, nombrePaciente, apellidosPaciente, fechaNacimientoPaciente, tipoSangre, sexo, telefonoPaciente, contraseniaPaciente);
                hospital.registrarPacientes(paciente);

                hospital.listaUsuarios.add(paciente);

                System.out.println("Paciente registrado exitosamente");
                break;
            case 2:
                System.out.println("\n--Seleccionaste la opción de registrar usuarios.medicos--");

                ArrayList<String> datosMedico = this.obtenerDatosComun(Rol.PACIENTE);

                String nombreMedicos = datosMedico.get(0);
                String apellidosMedico = datosMedico.get(1);
                LocalDate fechaNacimientoMedico = LocalDate.parse(datosMedico.get(2));
                String telefonoMedico = datosMedico.get(3);
                String contraseniaMedico = datosMedico.get(4);

                /*String telMedico = null;

                while (telMedico == null) {
                    System.out.print("Ingresa el telefono del medico: ");
                    telMedico = scanner.nextLine();

                    if (!hospital.validarTelefonoMedico(telMedico)) {
                        System.out.println("\nYa existe un medico con el mismo numero de telefono, Intente de nuevo\n");
                        telMedico = null;
                    }
                }*/

                String rfcMedico = null;

                while (rfcMedico == null) {
                    System.out.print("Ingresa el rfc del medico: ");
                    rfcMedico = scanner.nextLine();

                    if (!hospital.validarRFCMedico(rfcMedico)) {
                        System.out.println("\nYa exixte un medico con el mismo rfc, Intente de nuevo");
                        rfcMedico = null;
                    }
                }

                String idMedico= hospital.generarIdMedico(apellidosMedico, String.valueOf(fechaNacimientoMedico.getYear()));

                Medico medico = new Medico(idMedico,nombreMedicos,apellidosMedico,fechaNacimientoMedico,telefonoMedico,rfcMedico, contraseniaMedico);
                hospital.registrarMedico(medico);

                hospital.listaUsuarios.add(medico);

                System.out.println("Medico registrado exitosamente");
                break;
            case 3:
                System.out.println("\n--Seleccionaste la opción de registrar consultorio--");

                String idConsultorio=hospital.generarIdConsultorio();

                System.out.print("\nIngrese el piso del consultorio: ");
                int pisoConsultorio =scanner.nextInt();

                System.out.print("Ingrese el numero de consultorio: ");
                int numeroConsultorio = scanner.nextInt();

                Consultorio consultorio = new Consultorio(idConsultorio,pisoConsultorio,numeroConsultorio);
                hospital.registrarConsultorio(consultorio);

                System.out.println("Consultorio registrado exitosamente");
                break;
            case 4:
                System.out.println("\n--Seleccionaste la opción de registrar consulta--");

                String idConsulta = hospital.generarIdConsulta();

                LocalDateTime fechaConsulta = null;

                while (fechaConsulta == null) {
                    System.out.print("\nIngresa el día de la consnulta deseada: ");
                    int diaConsulta = scanner.nextInt();

                    System.out.print("Ingresar el mes de la consullta deseada: ");
                    int mesConsulta = scanner.nextInt();

                    System.out.print("Ingresa el año de la consulta deseada: ");
                    int anioConsulta = scanner.nextInt();

                    System.out.print("Ingresa la hora de la consulta: ");
                    int horaConsulta = scanner.nextInt();

                    System.out.print("Ingresa los minutos de la consulta: ");
                    int minutosConsulta = scanner.nextInt();

                    fechaConsulta = LocalDateTime.of(anioConsulta, mesConsulta, diaConsulta, horaConsulta, minutosConsulta);

                    if (!hospital.validarFechaConsulta(fechaConsulta)) {
                        System.out.println("La fecha no puede estar en el pasado");
                        fechaConsulta = null;
                    }
                }

                Paciente pacienteConsulta = null;

                scanner.nextLine();

                while (pacienteConsulta == null) {
                    System.out.print("Ingresa el id del paciente: ");
                    String pacienteId = scanner.nextLine();

                    pacienteConsulta = hospital.obtenerPacientePorId(pacienteId);

                    if (pacienteConsulta == null) {
                        System.out.println("\nPaciente no encontrado, Intenta de nuevo\n");
                    }
                }

                Medico medicoConsulta = null;

                while (medicoConsulta == null) {
                    System.out.print("Ingresa el id del medico: ");
                    String medicoId = scanner.nextLine();

                    medicoConsulta = hospital.obtenerMedicoPorId(medicoId);

                    if (medicoConsulta == null) {
                        System.out.println("\nMedico no encontrado, Intenta de nuevo\n");
                    }
                }

                Consultorio consultorioConsulta = null;

                while (consultorioConsulta == null) {
                    System.out.print("Ingresa el id del consultorio: ");
                    String consultorioId = scanner.nextLine();

                    consultorioConsulta = hospital.obtenerConsultorioPorId(consultorioId);

                    if (consultorioConsulta == null) {
                        System.out.println("\nConsultorio no encontrado, Intenta de nuevon");
                    }
                }

                Consulta consulta = new Consulta(idConsulta, fechaConsulta, pacienteConsulta, medicoConsulta, consultorioConsulta);
                hospital.registrarConsulta(consulta);

                System.out.println("Consulta registrada exitosamente");
                break;
            case 5:
                System.out.println("\n--Seleccionaste la opción de mostrar usuarios.pacientes--");
                hospital.mostrarPacientes();
                break;
            case 6:
                System.out.println("\n--Seleccionaste la opción de mostrar usuarios.medicos--");
                hospital.mostrarMedicos();
                break;
            case 7:
                System.out.println("\n--Seleccionaste la opción de mostrar consultorios--");
                hospital.mostrarConsultorio();
                break;
            case 8:
                System.out.println("\n--Seleccionaste la opción de mostrar consultas--");
                hospital.mostrarConsultas();
                break;
            case 9:
                System.out.println("\n--Seleccionaste la opción de buscar Paciente mediante la ID--");

                System.out.println("\nIngresa el Id del paciente que deseas buscar");
                String idPaciente = scanner.nextLine();

                hospital.mostrarPacienteID(idPaciente);
                break;
            case 10:
                System.out.println("\n--Seleccionaste la opción de buscar usuarios.medicos mediante la ID--");

                System.out.println("Ingresa el Id del medico que deseas buscar: ");
                String idMedico2 = scanner.nextLine();

                hospital.mostrarMedicoPorId(idMedico2);
                break;
            case 11:
                System.out.println("\n--Seleccionaste la opción de buscar consultorio mediante la ID--");

                System.out.println("Ingresa el Id del consultorio que deseas buscar: ");
                String idConsultorio2= scanner.nextLine();

                hospital.mostrarConsultorioPorId(idConsultorio2);
                break;
            case 12:
                System.out.println("\nAccediste a la opcion de registrar un administrador");
                scanner.nextLine();

                System.out.println("Ingresa el nombre: ");
                String nombreAdmin = scanner.nextLine();


                System.out.println("Ingresa los apellidos: ");
                String apellidosAdmin = scanner.nextLine();

                System.out.println("Ingresa la contrasenia: ");
                String contraseniaAdmin = scanner.nextLine();

                System.out.println("Ingresa el año de nacimiento: ");
                int anioNacimientoAdmin = scanner.nextInt();

                System.out.println("Ingresa el mes de nacimiento: ");
                int mesNacimientoAdmin = scanner.nextInt();

                System.out.println("Ingresa el dia de nacimiento: ");
                int diaNacimientoAdmin = scanner.nextInt();
                scanner.nextLine();

                LocalDate fechaNacimientoAdmin = LocalDate.of(anioNacimientoAdmin,mesNacimientoAdmin,diaNacimientoAdmin);

                String telefonoAdmin = null;
                while(telefonoAdmin == null) {
                    System.out.println("Ingresa el telefono: ");
                    telefonoAdmin = scanner.nextLine();
                    Administrador telefonoAdmin1 = hospital.obtenerTelefonoAdmin(telefonoAdmin);
                    if(telefonoAdmin1 != null) {
                        System.out.println("\nYa existe ese numero de telefono, intenta con otro\n");
                        telefonoAdmin = null;
                    }
                }

                String rfcAdmin = null;
                while(rfcAdmin == null) {
                    System.out.println("Ingresa el RFC: ");
                    rfcAdmin = scanner.nextLine();
                    Administrador rfcAdmin1 = hospital.obtenerRfcAdmin(rfcAdmin);
                    if(rfcAdmin1 != null) {
                        System.out.println("\nYa existe ese RFC, intenta con otro\n");
                        rfcAdmin = null;
                    }
                }

                System.out.println("Ingresa tu sueldo quincenal: ");
                double sueldo = scanner.nextDouble();

                System.out.println("Ingresa los anios que llevas laborando: ");
                int antiguedad = scanner.nextInt();

                String idAdmin = hospital.generarIdAdmin(apellidosAdmin,String.valueOf(fechaNacimientoAdmin));

                Administrador administrador = new Administrador(idAdmin,nombreAdmin,apellidosAdmin,fechaNacimientoAdmin,telefonoAdmin, contraseniaAdmin,sueldo,rfcAdmin,antiguedad);
                hospital.registrarAdministrador(administrador);

                hospital.listaAdministradores.add(administrador);

                break;
            case 13:
                hospital.mostrarAdministradores();
                break;
            case 14:
                System.out.println("\n-- Mi Información --\n");
                System.out.println(admin.mostrarDatos());
            case 15:
                System.out.println("\n--Seleccionaste la opcion de salir--");
                System.out.println("*HASTA LUEGO*");
                return;
        }
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
        String tipoUsuario = rol == Rol.PACIENTE ? "paciente" : rol == Rol.MEDICO ? "médico" : "administrador";
        ArrayList<String> datosEnComun = new ArrayList<>();

        System.out.print(String.format("Ingresa el nombre del %s: ", tipoUsuario));
        String nombre = scanner.nextLine();
        datosEnComun.add(nombre);

        System.out.print(String.format("Ingresa el apellido del %s: ", tipoUsuario));
        String apellido = scanner.nextLine();
        datosEnComun.add(apellido);

        System.out.print(String.format("Ingresa el año de nacimiento del %s: ", tipoUsuario));
        int anio = scanner.nextInt();

        System.out.print(String.format("Ingresa el mes de nacimiento del %s: ", tipoUsuario));
        int mes = scanner.nextInt();

        System.out.print(String.format("Ingresa el día de nacimiento del %s: ", tipoUsuario));
        int dia = scanner.nextInt();

        LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
        datosEnComun.add(fechaNacimiento.toString());

        System.out.print(String.format("Ingresa el numero de telefono %s: ", tipoUsuario));
        String telefono = scanner.nextLine();
        datosEnComun.add(telefono);

        System.out.print(String.format("Ingrese la contraseña del %s: ", tipoUsuario));
        String contraseniaPaciente = scanner.nextLine();
        datosEnComun.add(contraseniaPaciente);

        return datosEnComun;
    }
}