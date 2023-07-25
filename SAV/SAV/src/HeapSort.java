import java.util.List;

// Implementación del algoritmo Heap sort
class HeapSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int n = valores.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapify(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapify(List<String> valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores.get(left).compareToIgnoreCase(valores.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && valores.get(right).compareToIgnoreCase(valores.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapify(valores, n, largest);
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int n = valores.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDescendente(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapifyDescendente(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapifyDescendente(List<String> valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores.get(left).compareToIgnoreCase(valores.get(largest)) < 0) {
            largest = left;
        }

        if (right < n && valores.get(right).compareToIgnoreCase(valores.get(largest)) < 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapifyDescendente(valores, n, largest);
        }
    }
}