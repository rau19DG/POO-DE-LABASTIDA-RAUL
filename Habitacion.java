public class Habitacion {
    private final String tipo;
    private final double precioPorNoche;
    private boolean disponible;

    public Habitacion(String tipo, double precioPorNoche) {
        this.tipo = tipo;
        this.precioPorNoche = precioPorNoche;
        this.disponible = true;
    }

    public void reservar(int noches) throws HabitacionNoDisponibleException, NumeroDeNochesInvalidoException {
        if (!disponible) {
            throw new HabitacionNoDisponibleException("La habitacion no esta disponible.");
        }
        if (noches < 1) {
            throw new NumeroDeNochesInvalidoException("El numero de noches debe ser al menos 1.");
        }
        disponible = false;
        System.out.println("Reserva exitosa para " + noches + " noches.");
        System.out.println("Costo total de la reserva: " + (noches * precioPorNoche));
    }

    public void liberar() {
        disponible = true;
        System.out.println("La habitacion ha sido liberada y está disponible nuevamente.");
    }

    public void mostrarDetalles() {
        System.out.println("Tipo de habitacion: " + tipo);
        System.out.println("Precio por noche: " + precioPorNoche);
        System.out.println("Disponibilidad: " + (disponible ? "Disponible" : "No disponible"));
        System.out.println();
    }

    public boolean isDisponible() {
        return disponible;
    }
}

class HabitacionNoDisponibleException extends Exception {
    public HabitacionNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}

class NumeroDeNochesInvalidoException extends Exception {
    public NumeroDeNochesInvalidoException(String mensaje) {
        super(mensaje);
    }
}