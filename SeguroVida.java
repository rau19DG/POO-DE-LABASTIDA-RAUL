public class SeguroVida extends Seguro {
    private int edadTitular;

    public SeguroVida(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }

    @Override
    public double calcularPrima() {
        double prima = 400 + (0.015 * getValorAsegurado());
        if (edadTitular > 60) {
            prima *= 1.25; // Aplica recargo del 25%
        }
        return prima;
    }

    @Override
    public void detallesSeguro() {
        super.detallesSeguro();
        System.out.println("Edad del Titular: " + edadTitular + " años");
    }
}
    

