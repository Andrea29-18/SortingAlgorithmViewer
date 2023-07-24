// Implementación del algoritmo Counting sort
class CountingSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        int max = getMax(valores);

        String[] output = new String[n];
        int[] count = new int[max + 1];

        for (int i = 0; i < n; ++i) {
            count[getIndex(valores[i])]++; // Count the occurrences of each letter
        }

        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1]; // Update count[i] to contain the actual position of this character in the output array
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = getIndex(valores[i]);
            output[count[index] - 1] = valores[i];
            count[index]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, valores, 0, n);
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        int max = getMax(valores);

        String[] output = new String[n];
        int[] count = new int[max + 1];

        for (int i = 0; i < n; ++i) {
            count[getIndex(valores[i])]++; // Count the occurrences of each letter
        }

        for (int i = max - 1; i >= 0; --i) {
            count[i] += count[i + 1]; // Update count[i] to contain the actual position of this character in the output array
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int index = getIndex(valores[i]);
            output[count[index] - 1] = valores[i];
            count[index]--;
        }

        // Copy the output array to the original array
        System.arraycopy(output, 0, valores, 0, n);
    }

    private int getMax(String[] valores) {
        int max = 0;
        for (String value : valores) {
            int index = getIndex(value);
            if (index > max) {
                max = index;
            }
        }
        return max;
    }

    private int getIndex(String value) {
        if (value == null || value.isEmpty()) {
            return 0;
        }

        char firstChar = Character.toLowerCase(value.charAt(0));
        return firstChar - 'a' + 1;
    }
}
