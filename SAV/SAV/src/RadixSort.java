import java.util.ArrayList;
import java.util.List;

// Implementación del algoritmo Radix sort
class RadixSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int maxLen = getMaxLen(valores);

        for (int i = maxLen - 1; i >= 0; i--) {
            countingSort(valores, i);
            imprimirPaso(valores);
        }
    }

    private int getMaxLen(List<String> valores) {
        int maxLen = 0;
        for (String value : valores) {
            if (value.length() > maxLen) {
                maxLen = value.length();
            }
        }
        return maxLen;
    }

    private void countingSort(List<String> valores, int pos) {
        int n = valores.size();
        List<String> output = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            output.add("");
        }

        int[] count = new int[256];

        for (String value : valores) {
            int index = pos < value.length() ? value.charAt(value.length() - 1 - pos) : 0;
            count[index]++;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = pos < valores.get(i).length() ? valores.get(i).charAt(valores.get(i).length() - 1 - pos) : 0;
            output.set(count[index] - 1, valores.get(i));
            count[index]--;
        }

        for (int i = 0; i < n; ++i) {
            valores.set(i, output.get(i));
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int maxLen = getMaxLen(valores);

        for (int i = maxLen - 1; i >= 0; i--) {
            countingSortDescendente(valores, i);
            imprimirPaso(valores);
        }
    }

    private void countingSortDescendente(List<String> valores, int pos) {
        int n = valores.size();
        List<String> output = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            output.add("");
        }

        int[] count = new int[256];

        for (String value : valores) {
            int index = pos < value.length() ? value.charAt(value.length() - 1 - pos) : 0;
            count[index]++;
        }

        for (int i = 254; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = pos < valores.get(i).length() ? valores.get(i).charAt(valores.get(i).length() - 1 - pos) : 0;
            output.set(count[index] - 1, valores.get(i));
            count[index]--;
        }

        for (int i = 0; i < n; ++i) {
            valores.set(i, output.get(i));
        }
    }
}