import java.util.List;

// Implementación del algoritmo Bubble sort
class BubbleSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int n = valores.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores.get(j).compareToIgnoreCase(valores.get(j + 1)) > 0) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int n = valores.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores.get(j).compareToIgnoreCase(valores.get(j + 1)) < 0) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }
}