

public class Empleado {
    public double calcularSalario(double sueldoBase){
        return sueldoBase;
    }
    public double calcularSalario(double sueldoBase,double bonificacion){
     return sueldoBase+bonificacion;   
    }
    public double calcularSalario(double sueldoBase,double bonificacion,int horasExtra){
      return sueldoBase+bonificacion+(horasExtra*20);
    }
    public static void main(String[] args) {
        Empleado empleado=new Empleado();
    
    double salario1=empleado.calcularSalario(1000);
    System.out.println("Salario con sueldo base "+salario1);
    double salario2 = empleado.calcularSalario(1000, 200);
   System.out.println("Salario con sueldo base y bonificación: " + salario2);
   double salario3 = empleado.calcularSalario(1000, 200, 5);
   System.out.println("Salario con sueldo base, bonificación y horas extras: " + salario3); 
    }
}
