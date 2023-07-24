// Implementación del algoritmo Selection sort
class SelectionSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores[j].compareToIgnoreCase(valores[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            intercambiar(valores, i, minIndex);
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores[j].compareToIgnoreCase(valores[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            intercambiar(valores, i, maxIndex);
            imprimirPaso(valores);
        }
    }
}