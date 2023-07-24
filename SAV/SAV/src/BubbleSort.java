class BubbleSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores[j].compareToIgnoreCase(valores[j + 1]) > 0) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores[j].compareToIgnoreCase(valores[j + 1]) < 0) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }
}