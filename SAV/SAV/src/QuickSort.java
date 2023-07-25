import java.util.List;

// Implementación del algoritmo Quick sort
class QuickSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        quickSort(valores, 0, valores.size() - 1);
    }

    private void quickSort(List<String> valores, int low, int high) {
        if (low < high) {
            int pi = partition(valores, low, high);

            quickSort(valores, low, pi - 1);
            quickSort(valores, pi + 1, high);
        }
    }

    private int partition(List<String> valores, int low, int high) {
        String pivot = valores.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores.get(j).compareToIgnoreCase(pivot) < 0) {
                i++;
                intercambiar(valores, i, j);
            }
        }

        intercambiar(valores, i + 1, high);
        imprimirPaso(valores);

        return i + 1;
    }

    public void ordenarDescendente(List<String> valores) {
        quickSortDescendente(valores, 0, valores.size() - 1);
    }

    private void quickSortDescendente(List<String> valores, int low, int high) {
        if (low < high) {
            int pi = partitionDescendente(valores, low, high);

            quickSortDescendente(valores, low, pi - 1);
            quickSortDescendente(valores, pi + 1, high);
        }
    }

    private int partitionDescendente(List<String> valores, int low, int high) {
        String pivot = valores.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores.get(j).compareToIgnoreCase(pivot) > 0) {
                i++;
                intercambiar(valores, i, j);
            }
        }

        intercambiar(valores, i + 1, high);
        imprimirPaso(valores);

        return i + 1;
    }
}