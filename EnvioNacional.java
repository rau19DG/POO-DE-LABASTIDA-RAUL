public class EnvioNacional extends Envio {
    private double distanciaKm;

    public EnvioNacional(double costoBase, double peso,double distanciaKm){
        super(costoBase, peso);
        this.distanciaKm=distanciaKm;
    }
    @Override
    public String calcularTiempoYCostoEntrega(){
        int tiempoEntrega=1+(int)(distanciaKm/200);
        double costoTotal= getCostoBase();
    if(getPeso()>5){
        costoTotal+=getCostoBase()*0.05;

    }
    return "Envio Nacional -Costo Total: $"+ costoTotal+", Tiempo de Entrega:"+tiempoEntrega+"dias";
    }
}
