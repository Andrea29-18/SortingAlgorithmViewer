import java.util.Arrays;

abstract class Ordenamiento {
    public abstract void ordenarAscendente(String[] valores);

    public abstract void ordenarDescendente(String[] valores);

    protected void intercambiar(String[] arreglo, int i, int j) {
        String temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    protected void imprimirPaso(String[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }
}
