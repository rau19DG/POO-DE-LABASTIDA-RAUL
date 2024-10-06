import java.util.Random;

public class Producto {
    public int id;
    public String nombre;
    public Double precio;
    public String descripcion;
    public int idCategoria;
    public int stock;
    public Random random = new Random();

    public Producto(String var1, Double var2, String var3, int var4, int var5) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = var1;
        this.precio = var2;
        this.descripcion = var3;
        this.idCategoria = var4;
        this.stock = var5;
    }

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getIdCategoria() {
        return this.idCategoria;
    }

    public int getStock() {
        return this.stock;
    }

    public String mostrarProductos() {
        return String.format("Id: %d  |  Nombre: %s  |  Precio: %f  |  Descripcion: %s  |  ID Categoria: %d  |  Stock: %d", this.getId(), this.getNombre(), this.getPrecio(), this.getDescripcion(), this.getIdCategoria(), this.getStock());
    }
}
