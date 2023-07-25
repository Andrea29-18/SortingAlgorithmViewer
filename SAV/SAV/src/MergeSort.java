import java.util.ArrayList;
import java.util.List;

// Implementación del algoritmo Merge sort
class MergeSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        mergeSort(valores, 0, valores.size() - 1);
    }

    private void mergeSort(List<String> valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(valores, l, m);
            mergeSort(valores, m + 1, r);

            merge(valores, l, m, r);
        }
    }

    private void merge(List<String> valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        List<String> L = new ArrayList<>(valores.subList(l, l + n1));
        List<String> R = new ArrayList<>(valores.subList(m + 1, m + 1 + n2));

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).compareToIgnoreCase(R.get(j)) <= 0) {
                valores.set(k, L.get(i));
                i++;
            } else {
                valores.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            valores.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            valores.set(k, R.get(j));
            j++;
            k++;
        }

        imprimirPaso(valores);
    }

    public void ordenarDescendente(List<String> valores) {
        mergeSortDescendente(valores, 0, valores.size() - 1);
    }

    private void mergeSortDescendente(List<String> valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSortDescendente(valores, l, m);
            mergeSortDescendente(valores, m + 1, r);

            mergeDescendente(valores, l, m, r);
        }
    }

    private void mergeDescendente(List<String> valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        List<String> L = new ArrayList<>(valores.subList(l, l + n1));
        List<String> R = new ArrayList<>(valores.subList(m + 1, m + 1 + n2));

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).compareToIgnoreCase(R.get(j)) >= 0) {
                valores.set(k, L.get(i));
                i++;
            } else {
                valores.set(k, R.get(j));
                j++;
            }
            k++;
        }

        while (i < n1) {
            valores.set(k, L.get(i));
            i++;
            k++;
        }

        while (j < n2) {
            valores.set(k, R.get(j));
            j++;
            k++;
        }

        imprimirPaso(valores);
    }
}