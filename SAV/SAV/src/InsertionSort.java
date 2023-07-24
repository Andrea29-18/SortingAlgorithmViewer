// Implementación del algoritmo Insertion sort
class InsertionSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        for (int i = 1; i < n; i++) {
            String key = valores[i];
            int j = i - 1;
            while (j >= 0 && valores[j].compareToIgnoreCase(key) > 0) {
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = key;
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        for (int i = 1; i < n; i++) {
            String key = valores[i];
            int j = i - 1;
            while (j >= 0 && valores[j].compareToIgnoreCase(key) < 0) {
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = key;
            imprimirPaso(valores);
        }
    }
}