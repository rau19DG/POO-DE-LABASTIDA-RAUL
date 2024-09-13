public class PruebaCoche {
    public static void main(String[]args){
        Coche coche1=new Coche("Toyota","Corollla",2010);
        Coche coche2=new Coche("Ford","Mustang",2015);
        Coche coche3=new Coche("Honda","Civic",2018);
        coche1.mostrarInformacion();
        coche2.mostrarInformacion();
        coche3.mostrarInformacion();

        int añoActual=2024;
        System.out.println("Edad del coche 1: "+ coche1.calcularEdadCoche
        (añoActual)+ " años");
        System.out.println("Edad del coche 2: "+coche2.calcularEdadCoche
        (añoActual)+ " años");
        System.out.println("Edad del coche 3: "+ coche3.calcularEdadCoche
        (añoActual)+" años");


    }


}
