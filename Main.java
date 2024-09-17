public class Main {

    public static void main(String[] args) {
       
        Producto producto = new Producto("Laptop", 1500.99);
        System.out.println(producto.toString());

        
        Stock stock = new Stock(10);
        System.out.println(stock.toString());

        
        aumentarStock(stock, 5);
        System.out.println("Stock después de aumentar: " + stock.toString());

       
        reducirStock(stock, 3);
        System.out.println("Stock después de reducir: " + stock.toString());

        
        try {
            reducirStock(stock, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

   
    public static void aumentarStock(Stock stock, int cantidad) {
        stock.aumentarStock(cantidad);
    }

    
    public static void reducirStock(Stock stock, int cantidad) {
        stock.reducirStock(cantidad);
    }
}
