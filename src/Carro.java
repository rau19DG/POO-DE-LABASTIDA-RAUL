package src;

public class Carro implements MedioTrasnporte {
    
    @Override
    public  void acelerar (double velocidad){
        if(velocidad>VELOCIDAD_MAXIMA/2){
            System.out.println("Velocidad maxia alcanzada");
        }else{
            System.out.println("Flujo normal");
        }
  
    
    
      
  }
  @Override
   public void arrancar() {
   }
}
