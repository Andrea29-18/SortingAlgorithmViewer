import java.util.ArrayList;
import java.util.List;

// Implementación del algoritmo Counting sort
class CountingSort extends Ordenamiento {
    public void ordenarAscendente(List<String> valores) {
        int n = valores.size();

        int max = getMax(valores);

        List<String> output = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            output.add("");
        }

        int[] count = new int[max + 1];

        for (String value : valores) {
            count[getIndex(value)]++;
        }

        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = getIndex(valores.get(i));
            output.set(count[index] - 1, valores.get(i));
            count[index]--;
        }

        for (int i = 0; i < n; ++i) {
            valores.set(i, output.get(i));
        }
    }

    public void ordenarDescendente(List<String> valores) {
        int n = valores.size();

        int max = getMax(valores);

        List<String> output = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            output.add("");
        }

        int[] count = new int[max + 1];

        for (String value : valores) {
            count[getIndex(value)]++;
        }

        for (int i = max - 1; i >= 0; --i) {
            count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int index = getIndex(valores.get(i));
            output.set(count[index] - 1, valores.get(i));
            count[index]--;
        }

        for (int i = 0; i < n; ++i) {
            valores.set(i, output.get(i));
        }
    }

    private int getMax(List<String> valores) {
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