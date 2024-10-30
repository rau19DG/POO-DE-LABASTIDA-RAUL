public class SeguroAuto extends Seguro {
    private int edadTitular;
    
    public SeguroAuto(String nombreTitular, double valorAsegurado, int edadTitular) {
        super(nombreTitular, valorAsegurado);
        this.edadTitular = edadTitular;
    }
    @Override
    public double calcularPrima() {
        double prima = 300 + (0.05 * getValorAsegurado());
        if (edadTitular < 25) {
            prima *= 1.15; // Aplica recargo del 15%
        }
        return prima;
    }

    @Override
    public void detallesSeguro() {
        super.detallesSeguro();
        System.out.println("Edad del Titular: " + edadTitular + " años");
    }
}

    

