package src;

public class Motocicleta implements MedioTrasnporte {
    @Override
  public  void acelerar (double velocidad){
if(velocidad>(VELOCIDAD_MAXIMA/5)){
    System.out.println("ALERTA");
} else{


    System.out.println(VELOCIDAD_MAXIMA);
}
    
}
@Override
 public void arrancar() {
 }
}
 
