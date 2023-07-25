import java.util.List;

// Implementación del algoritmo Insertion sort
class InsertionSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int n = valores.size();

        for (int i = 1; i < n; i++) {
            String key = valores.get(i);
            int j = i - 1;
            while (j >= 0 && valores.get(j).compareToIgnoreCase(key) > 0) {
                valores.set(j + 1, valores.get(j));
                j--;
            }
            valores.set(j + 1, key);
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int n = valores.size();

        for (int i = 1; i < n; i++) {
            String key = valores.get(i);
            int j = i - 1;
            while (j >= 0 && valores.get(j).compareToIgnoreCase(key) < 0) {
                valores.set(j + 1, valores.get(j));
                j--;
            }
            valores.set(j + 1, key);
            imprimirPaso(valores);
        }
    }
}