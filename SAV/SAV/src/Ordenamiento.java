import java.util.List;

// Clase abstracta para los algoritmos de ordenamiento
abstract class Ordenamiento implements AlgoritmoOrdenamiento {
    protected void intercambiar(List<String> lista, int i, int j) {
        String temp = lista.get(i);
        lista.set(i, lista.get(j));
        lista.set(j, temp);
    }

    protected void imprimirPaso(List<String> lista) {
        System.out.println(lista);
    }
}