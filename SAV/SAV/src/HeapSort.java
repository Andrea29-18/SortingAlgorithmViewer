// Implementación del algoritmo Heap sort
class HeapSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapify(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapify(String[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left].compareToIgnoreCase(valores[largest]) > 0) {
            largest = left;
        }

        if (right < n && valores[right].compareToIgnoreCase(valores[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapify(valores, n, largest);
        }
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDescendente(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapifyDescendente(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapifyDescendente(String[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left].compareToIgnoreCase(valores[largest]) < 0) {
            largest = left;
        }

        if (right < n && valores[right].compareToIgnoreCase(valores[largest]) < 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapifyDescendente(valores, n, largest);
        }
    }
}