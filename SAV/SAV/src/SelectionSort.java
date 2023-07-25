import java.util.List;

// Implementación del algoritmo Selection sort
class SelectionSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int n = valores.size();

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores.get(j).compareToIgnoreCase(valores.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            intercambiar(valores, i, minIndex);
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int n = valores.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores.get(j).compareToIgnoreCase(valores.get(maxIndex)) > 0) {
                    maxIndex = j;
                }
            }
            intercambiar(valores, i, maxIndex);
            imprimirPaso(valores);
        }
    }
}