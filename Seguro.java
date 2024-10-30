public abstract class Seguro {
    private String nombreTitular;
    private double valorAsegurado;

    public Seguro(String nombreTitular,double valorAsegurado){
        this.nombreTitular=nombreTitular;
        this.valorAsegurado=valorAsegurado;
 }
 public String getNombreTitular(){
    return nombreTitular;
 }
 public double getValorAsegurado(){
    return valorAsegurado;
 }
    public abstract double calcularPrima();
    public void detallesSeguro() {
        System.out.println("Titular: " + getNombreTitular());
        System.out.println("Valor Asegurado: $" + getValorAsegurado());
        System.out.println("Prima Anual: $" + calcularPrima());
    }


}
