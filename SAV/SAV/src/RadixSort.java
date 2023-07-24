// Implementación del algoritmo Radix sort
class RadixSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int maxLen = getMaxLen(valores);

        for (int i = maxLen - 1; i >= 0; i--) {
            countingSort(valores, i);
            imprimirPaso(valores);
        }
    }

    private int getMaxLen(String[] valores) {
        int maxLen = 0;
        for (String value : valores) {
            if (value.length() > maxLen) {
                maxLen = value.length();
            }
        }
        return maxLen;
    }

    private void countingSort(String[] valores, int pos) {
        int n = valores.length;
        String[] output = new String[n];

        // Since we are dealing with characters (letters), we use 256 as the range of possible values
        int[] count = new int[256];

        // Count the occurrences of each character at the specified position
        for (String value : valores) {
            int index = pos < value.length() ? value.charAt(value.length() - 1 - pos) : 0;
            count[index]++;
        }

        // Update count[i] to contain the actual position of the character in the output array
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = pos < valores[i].length() ? valores[i].charAt(valores[i].length() - 1 - pos) : 0;
            output[count[index] - 1] = valores[i];
            count[index]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, valores, 0, n);
    }

    public void ordenarDescendente(String[] valores) {
        int maxLen = getMaxLen(valores);

        for (int i = maxLen - 1; i >= 0; i--) {
            countingSortDescendente(valores, i);
            imprimirPaso(valores);
        }
    }

    private void countingSortDescendente(String[] valores, int pos) {
        int n = valores.length;
        String[] output = new String[n];

        // Since we are dealing with characters (letters), we use 256 as the range of possible values
        int[] count = new int[256];

        // Count the occurrences of each character at the specified position
        for (String value : valores) {
            int index = pos < value.length() ? value.charAt(value.length() - 1 - pos) : 0;
            count[index]++;
        }

        // Update count[i] to contain the actual position of the character in the output array
        for (int i = 254; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = pos < valores[i].length() ? valores[i].charAt(valores[i].length() - 1 - pos) : 0;
            output[count[index] - 1] = valores[i];
            count[index]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, valores, 0, n);
    }
}
