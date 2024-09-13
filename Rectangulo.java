public class Rectangulo {
    public int calcularArea(int ancho, int alto){
        return ancho*alto;
}
public double calcularArea(double ancho, double alto){
    return ancho*alto;
}
    public  int calcularPerimetro ( int ancho, int alto){
        return 2 *(ancho + alto);
    }
    public double calcularPerimetro (double ancho, double alto){
        return 2 *(ancho + alto);

    }
    public static void main(String[] args) {
        Rectangulo rect=new Rectangulo();

        int areaInt=rect.calcularArea(5,10);
        int perimetroInt=rect.calcularPerimetro(5,10);
       System.out.println("Area (int): "+areaInt);
       System.out.println("Perimetro (int): "+perimetroInt);

       double areaDouble=rect.calcularArea(5.5,10.2 );
       double perimetroDouble=rect.calcularPerimetro(5.5,10.2);
       System.out.println("Area (double): "+areaDouble);
       System.out.println("Perimetro (double):"+perimetroDouble);
        

    }

    
}
