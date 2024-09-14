public class Main {
    public static void main(String[] args) {
        // Crear algunos cursos
        Curso curso1 = new Curso("Matemáticas", "M101", "Prof. García");
        Curso curso2 = new Curso("Historia", "H202", "Prof. Ramírez");

        // Crear un estudiante
        Estudiante estudiante1 = new Estudiante("Juan Pérez", "E12345");

        // Agregar cursos al estudiante
        estudiante1.agregarCurso(curso1);
        estudiante1.agregarCurso(curso2);

        // Mostrar la información del estudiante y sus cursos
        estudiante1.mostrarInformacion();
    }
}

    

