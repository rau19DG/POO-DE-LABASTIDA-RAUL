import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {
        Scanner var1 = new Scanner(System.in);
        Inventario var2 = new Inventario();
        boolean var3 = false;

        while(true) {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("1.- Registrar Productos");
            System.out.println("2.- Eliminar Producto");
            System.out.println("3.- Mostrar Productos");
            System.out.println("4.- Mostrar Categor\u00c3\u00adas");
            System.out.println("5.- Mostrar Categor\u00c3\u00adas Con Productos");
            System.out.println("6.- Registrar Categor\u00c3\u00ada");
            System.out.println("7.- Salir");
            System.out.print("Selecciona una opci\u00c3\u00b3n: ");
            int var14 = var1.nextInt();
            var1.nextLine();
            switch (var14) {
                case 1:
                    if (!var2.validarExistenciaDeCategorias()) {
                        System.out.println("\nNo existen categorias en el sistema");
                        break;
                    }

                    System.out.println("\nSeleccionaste la opci\u00c3\u00b3n para registrar un producto");
                    System.out.print("\nIngresa el Nombre del producto: ");
                    String var4 = var1.nextLine();
                    var1.nextLine();
                    System.out.print("\nIngresa el Precio del producto: ");
                    Double var5 = var1.nextDouble();
                    var1.nextLine();
                    System.out.print("\nIngresa la Descrippci\u00c3\u00b3n del producto: ");
                    String var6 = var1.nextLine();
                    var1.nextLine();
                    int var7 = 0;
                    boolean var8 = true;

                    while(var8) {
                        System.out.print("\nIngresa el ID de la Categor\u00c3\u00ada en la cual registraras el producto: ");
                        var7 = var1.nextInt();
                        if (var2.validarCategoria(var7)) {
                            var8 = false;
                        } else {
                            System.out.println("El ID de la categor\u00c3\u00ada no es correctos");
                        }
                    }

                    var1.nextLine();
                    System.out.print("\nIngresa el Stock del producto: ");
                    int var9 = var1.nextInt();
                    Producto var10 = new Producto(var4, var5, var6, var7, var9);
                    var2.registrarProductos(var10);
                    var2.ponerProductoEnCategoria(var10);
                    break;
                case 2:
                    System.out.println("\nSeleccionaste la opci\u00c3\u00b3n para eliminar un producto");
                    System.out.print("\nIngresa el ID del producto:");
                    int var11 = var1.nextInt();
                    var2.eliminarProducto(var11);
                    break;
                case 3:
                    var2.mostrarProductos();
                    break;
                case 4:
                    var2.mostrarCategorias();
                    break;
                case 5:
                    var2.mostrarCategoriasYProductos();
                    break;
                case 6:
                    System.out.println("\nSeleccionaste la opci\u00c3\u00b3n para registrar una categoria");
                    System.out.print("Ingresa el nombre de la categor\u00c3\u00ada: ");
                    String var12 = var1.next();
                    Categoria var13 = new Categoria(var12);
                    var2.registrarCategoria(var13);
                    System.out.println("\nCategoria registrada correctamente");
                    break;
                case 7:
                    System.out.println("\nHata luego");
                    return;
            }
        }
    }
}
