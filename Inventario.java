import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventario {
    public ArrayList<Producto> listaPoductos = new ArrayList();
    public ArrayList<Categoria> listaCategorias = new ArrayList();

    public Inventario() {
    }

    public void registrarProductos(Producto var1) {
        this.listaPoductos.add(var1);
        System.out.println("Se registro un nuevo Producto");
    }

    public void registrarCategoria(Categoria var1) {
        this.listaCategorias.add(var1);
    }

    public void ponerProductoEnCategoria(Producto var1) {
        Iterator var2 = this.listaCategorias.iterator();

        Categoria var3;
        do {
            if (!var2.hasNext()) {
                return;
            }

            var3 = (Categoria)var2.next();
        } while(var3.getId() != var1.getIdCategoria());

        var3.registrarProductoEnCategoria(var1);
    }

    public void eliminarProducto(int var1) {
        int var2 = this.listaPoductos.size();
        this.listaPoductos.removeIf((var1x) -> {
            return var1x.getId() == var1;
        });
        if (var2 != this.listaPoductos.size()) {
            System.out.println("\nSe elimino el producto con el ID: " + var1);
        } else {
            System.out.println("\nNo existe el producto con el ID: " + var1);
        }

    }

    public void mostrarProductos() {
        System.out.println("\n** PRODUCTOS EN EL SISTEMA **");
        if (this.listaPoductos.isEmpty()) {
            System.out.println("\nNo esxiste productos registrados");
        } else {
            Iterator var1 = this.listaPoductos.iterator();

            while(var1.hasNext()) {
                Producto var2 = (Producto)var1.next();
                System.out.println(var2.mostrarProductos());
            }
        }

    }

    public void mostrarCategorias() {
        System.out.println("\n** CATEGORIAS EN EL SISTEMA **");
        if (this.listaCategorias.isEmpty()) {
            System.out.println("\nNo esxiste productos registrados");
        } else {
            Iterator var1 = this.listaCategorias.iterator();

            while(var1.hasNext()) {
                Categoria var2 = (Categoria)var1.next();
                System.out.println(var2.mostrarCategorias());
            }
        }

    }

    public void mostrarCategoriasYProductos() {
        System.out.println("\n*** CATEGORIAS Y PRODUCTOS EN EL SISTEMA ***");
        if (this.listaCategorias.isEmpty()) {
            System.out.println("\nNo hay registros existentes");
        } else {
            Iterator var1 = this.listaCategorias.iterator();

            while(var1.hasNext()) {
                Categoria var2 = (Categoria)var1.next();
                PrintStream var10000 = System.out;
                int var10001 = var2.getId();
                var10000.println("" + var10001 + " | " + var2.getNombre());
                System.out.println("--------------------------------");
                Iterator var3 = this.listaPoductos.iterator();

                while(var3.hasNext()) {
                    Producto var4 = (Producto)var3.next();
                    if (var4.getIdCategoria() == var2.getId()) {
                        System.out.printf("Id: %d  |  Nombre: %s  |  Precio: %f  |  Descripcion: %s  |  ID Categoria: %d  |  Stock: %d%n", var4.getId(), var4.getNombre(), var4.getPrecio(), var4.getDescripcion(), var4.getIdCategoria(), var4.getStock());
                    }
                }

                System.out.println("\n");
            }
        }

    }

    public boolean validarExistenciaDeCategorias() {
        return !this.listaCategorias.isEmpty();
    }

    public boolean validarCategoria(int var1) {
        Iterator var2 = this.listaCategorias.iterator();

        Categoria var3;
        do {
            if (!var2.hasNext()) {
                return false;
            }

            var3 = (Categoria)var2.next();
        } while(var3.getId() != var1);

        return true;
    }
}
