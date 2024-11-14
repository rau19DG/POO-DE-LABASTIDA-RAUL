import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class ListaDeTareas {
    private static final String FILE_NAME = "tareas.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    escribirTarea(scanner);
                    break;
                case 2:
                    leerTareas();
                    break;
                case 3:
                    System.out.println("Programa terminado.");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Escribir tarea");
        System.out.println("2. Leer tareas");
        System.out.println("3. Terminar");
    }

    private static void escribirTarea(Scanner scanner) {
        System.out.print("Ingrese la tarea: ");
        String tarea = scanner.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(tarea + "\n");
            System.out.println("Tarea guardada.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar la tarea.");
            e.printStackTrace();
        }
    }

    private static void leerTareas() {
        System.out.println("\nTareas guardadas:");
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer las tareas.");
            e.printStackTrace();
        }
    }
}
