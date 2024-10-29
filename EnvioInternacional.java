public class EnvioInternacional extends Envio {
    private String destino;
    public EnvioInternacional(double costoBase, double peso, String destino){
        super(costoBase, peso);
        this.destino=destino;
    }
    @Override
    public String calcularTiempoYCostoEntrega(){
        int tiempoEntrega=10;
        if(getPeso()>10) {
          tiempoEntrega+=3;
        }
    
        double costoTotal=getCostoBase();
        if(destino.equalsIgnoreCase("internacional")){
            costoTotal+=getCostoBase()*0.20;
        }
    return "Envio Internacional - Costo Total: $"+costoTotal+", Tiempo de Entrega:"+tiempoEntrega+"dias";
    
    }
}


