import consultas.Consulta;
import consultorios.Consultorio;
import hospital.Hospital;
import medicos.Medico;
import pacientes.Paciente;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner leer=new Scanner(System.in);
        Consulta consulta=new Consulta();
        Hospital hospital=new Hospital();

        String FechaHora, nombre, apellidos, fechaNac, telefono, tipoSangre, rfc, id;
        char sexo;
        int opc=0, piso, numeroCons;

        while(opc!=13){
            System.out.println("\n---------MENÚ-----------");
            System.out.println("1. Registrar paciente.");
            System.out.println("2. Registrar médico.");
            System.out.println("3. Registrar consultorio.");
            System.out.println("4. Registrar consulta.");
            System.out.println("5. Mostrar pacientes.");
            System.out.println("6. Mostras médicos.");
            System.out.println("7. Mostrar consultorios.");
            System.out.println("8. Mostrar consultas.");
            System.out.println("9. Mostrar paciente por ID.");
            System.out.println("10. Mostrar médico por ID.");
            System.out.println("11. Mostrar consultorio por ID.");
            System.out.println("13. Salir.");
            opc=leer.nextInt();

            switch(opc) {

                case 1:
                    id = hospital.generarIDpaciente();
                    System.out.println("\n--------REGISTRAR PACIENTE--------");
                    System.out.print("Ingresar nombre: ");
                    nombre = leer.next();
                    System.out.print("Ingresar apellidos: ");
                    apellidos = leer.next();
                    System.out.print("Ingresar fecha de nacimiento (aaaa/mm/dd): ");
                    fechaNac = leer.next();
                    System.out.print("Ingresar tipo de sangre: ");
                    tipoSangre = leer.next();
                    System.out.print("Ingresar sexo: ");
                    sexo=(char) System.in.read();
                    System.out.print("Ingresar teléfono: ");
                    telefono = leer.next();

                    Paciente paciente = new Paciente(id, nombre, apellidos, fechaNac, telefono, tipoSangre, sexo);
                    hospital.registrarPaciente(paciente);
                    System.out.println("\n Se registró un nuevo paciente");
                    break;

                case 2:
                    System.out.println("\n--------REGISTRAR MÉDICO--------");
                    System.out.print("Ingresar nombre: ");
                    nombre=leer.next();
                    System.out.print("Ingresar apellidos: ");
                    apellidos=leer.next();
                    System.out.print("Ingresar fecha de nacimiento (aaaa/mm/dd): ");
                    fechaNac=leer.next();
                    System.out.print("Ingresar número de teléfono: ");
                    telefono=leer.next();
                    System.out.println("Ingresar RFC: ");
                    rfc=leer.next();
                    id= hospital.generarIDMedico(apellidos, fechaNac);
                    System.out.println(id);
                    Medico medico=new Medico(id, nombre, apellidos, fechaNac, telefono, rfc);
                    medico.setNombre(nombre);
                    medico.setApellidos(apellidos);
                    medico.setFechaNacimiento(fechaNac);
                    medico.setTelefono(telefono);
                    medico.setRfc(rfc);
                    medico.setId(id);
                    hospital.registrarMedico(medico);
                    System.out.println("\nSe registró un nuevo médico");
                    break;
                    case 3:
                    System.out.println("\n--------REGISTRAR CONSULTORIO--------");
                    id= hospital.generarIDConsultorio();
                    System.out.print("Ingresar piso donde se encuentra el consultorio: ");
                    piso = leer.nextInt();
                    System.out.print("Ingresar numero de consultorio: ");
                    numeroCons = leer.nextInt();

                    Consultorio consultorio = new Consultorio(id, piso, numeroCons);
                    consultorio.setPiso(piso);
                    consultorio.setNumeroConsultorio(numeroCons);
                    hospital.registrarConsultorio(consultorio);
                    System.out.println("\nSe registró un nuevo consultorio");
                    break;

                case 4:
                    System.out.println("\n--------REGISTRAR CONSULTA--------");
                    System.out.print("Ingresar fecha y hora de la consulta: ");
                    FechaHora = leer.next();
                    consulta.setFechaHora(FechaHora);
                    System.out.print("Ingresar paciente: ");

                    System.out.print("Ingresar consultorio: ");
                    break;
                    case 5:

                    System.out.println("\n--------MOSTRAR PACIENTES--------");
                    hospital.mostrarPaciente();
                    break;

                case 6:
                    System.out.println("\n--------MOSTRAR MÉDICOS--------");
                    hospital.mostrarMedicos();
                    break;

                case 7:
                    System.out.println("\n--------MOSTRAR CONSULTORIO--------");
                    hospital.mostrarConsultorios();
                    break;

                case 8:

                    break;

                case 9:
                    System.out.println("\n---------MOSTRAR PACIENTE------------");
                    System.out.print("Ingresa el ID del paciente al que se desea buscar: ");
                    String idBuscarPaciente=leer.next();
                    hospital.mostrarPacientePorID(idBuscarPaciente);
                    break;

                    case 10:
                    System.out.println("\n--------MOSTRAR MÉDICOS--------");
                    System.out.print("Ingresa el ID del medico al que se desea buscar: ");
                    String idBuscar=leer.next();
                    hospital.mostrarMedicoPorID(idBuscar);
                    break;

                case 11:
                    System.out.println("\n--------MOSTRAR CONSULTORIO--------");
                    System.out.print("Ingresa el ID del consultorio al que se desea buscar: ");
                    idBuscar=leer.next();
                    hospital.mostrarConsultorioPorID(idBuscar);
                    break;

                case 13:
                    System.out.println("\nCuide de su salud");
                    break;

                default:
                    System.out.println("\nOpción invalida");
            }
        }
    }
}


