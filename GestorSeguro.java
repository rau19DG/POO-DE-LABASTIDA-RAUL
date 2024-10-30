public class GestorSeguro {
    public static void main(String[] args) {
        Seguro seguroAuto = new SeguroAuto("Juan Perez", 20000, 24);
        Seguro seguroHogar = new SeguroHogar("Maria Lopez", 150000, true);
        Seguro seguroVida = new SeguroVida("Carlos Garcia", 50000, 65);

        System.out.println("Detalles del Seguro de Auto:");
        seguroAuto.detallesSeguro();
        System.out.println();

        System.out.println("Detalles del Seguro de Hogar:");
        seguroHogar.detallesSeguro();
        System.out.println();

        System.out.println("Detalles del Seguro de Vida:");
        seguroVida.detallesSeguro();
    }
}
