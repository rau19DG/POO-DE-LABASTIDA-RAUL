public class CalculadoraImpuestos {
    public double calcularImpuestos(int ingresos) {
        return ingresos + (ingresos * 0.15); 
    }

    
    public double calcularImpuestos(int ingresos, double porcentajeImpuestos) {
        return ingresos * (porcentajeImpuestos / 100); 
    }


    public double calcularImpuestos(double dividendos, double porcentajeImpuestos, double exencion) {
        double impuestos = dividendos * (porcentajeImpuestos / 100); 

        
        return impuestos > exencion ? impuestos - exencion : 0;
    }

    public static void main(String[] args) {
        CalculadoraImpuestos calculadora = new CalculadoraImpuestos();

        
        double resultado1 = calculadora.calcularImpuestos(1000);
        System.out.println("Impuestos con solo ingresos: " + resultado1); 

        
        double resultado2 = calculadora.calcularImpuestos(2000, 10);
        System.out.println("Impuestos con ingresos y porcentaje: " + resultado2); 

        
        double resultado3 = calculadora.calcularImpuestos(5000, 20, 800);
        System.out.println("Impuestos con dividendos, porcentaje y exención: " + resultado3); 
    }
}

