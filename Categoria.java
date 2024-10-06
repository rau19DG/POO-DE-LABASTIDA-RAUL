import java.util.ArrayList;
import java.util.Random;

public class Categoria {
    public int id;
    public String nombre;
    public ArrayList<Producto> listaPoductos = new ArrayList();
    public Random random = new Random();

    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Categoria(String var1) {
        this.id = this.random.nextInt(1, 10001);
        this.nombre = var1;
    }

    public void registrarProductoEnCategoria(Producto var1) {
        this.listaPoductos.add(var1);
    }

    public String mostrarCategorias() {
        return String.format("ID: %d  |  Nombre: %s", this.getId(), this.getNombre());
    }
}
