public abstract class Envio {
    private double costoBase;
    private double peso;

    public Envio(double costoBase, double peso){
        this.costoBase=costoBase;
        this.peso=peso;
    }
    public double getCostoBase(){
        return costoBase;
    }
    public double getPeso(){
        return peso;
    }
    public abstract String calcularTiempoYCostoEntrega();
    public void validarPeso(){
        if(peso<=0){
            System.out.println("Error: El peso debe ser mayor que cero");
        } else{
            System.out.println("Peso validado: "+peso+"kg");
        }
    }
    
}
