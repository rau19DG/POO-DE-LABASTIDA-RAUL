public class Stock {

    
    private int stock;

   
    public Stock(int stock) {
        setStock(stock);
    }

    
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }
        this.stock = stock;
    }

    
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        this.stock += cantidad;
    }

    
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero.");
        }
        if (cantidad > this.stock) {
            throw new IllegalArgumentException("La cantidad a reducir no puede ser mayor al stock actual.");
        }
        this.stock -= cantidad;
    }

    
    @Override
    public String toString() {
        return "Stock [cantidad=" + stock + "]";
    }
}


