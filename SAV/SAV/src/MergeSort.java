// Implementación del algoritmo Merge sort
class MergeSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        mergeSort(valores, 0, valores.length - 1);
    }

    private void mergeSort(String[] valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(valores, l, m);
            mergeSort(valores, m + 1, r);

            merge(valores, l, m, r);
        }
    }

    private void merge(String[] valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = valores[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = valores[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareToIgnoreCase(R[j]) <= 0) {
                valores[k] = L[i];
                i++;
            } else {
                valores[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            valores[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            valores[k] = R[j];
            j++;
            k++;
        }

        imprimirPaso(valores);
    }

    public void ordenarDescendente(String[] valores) {
        mergeSortDescendente(valores, 0, valores.length - 1);
    }

    private void mergeSortDescendente(String[] valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSortDescendente(valores, l, m);
            mergeSortDescendente(valores, m + 1, r);

            mergeDescendente(valores, l, m, r);
        }
    }

    private void mergeDescendente(String[] valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        String[] L = new String[n1];
        String[] R = new String[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = valores[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = valores[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].compareToIgnoreCase(R[j]) >= 0) {
                valores[k] = L[i];
                i++;
            } else {
                valores[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            valores[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            valores[k] = R[j];
            j++;
            k++;
        }

        imprimirPaso(valores);
    }
}