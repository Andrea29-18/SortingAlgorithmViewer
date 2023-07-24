import java.util.Arrays;
import java.util.Scanner;

class OrdenamientoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la cantidad de valores
        System.out.print("Ingrese la cantidad de valores: ");
        int cantidadValores = scanner.nextInt();

        // Obtener los valores
        String[] valores = new String[cantidadValores];
        System.out.println("Ingrese los valores, uno por línea:");
        for (int i = 0; i < cantidadValores; i++) {
            valores[i] = scanner.next();
        }

        // Obtener el tipo de ordenamiento
        System.out.print("¿Desea ordenar de menor a mayor (1) o de mayor a menor (2)? ");
        int tipoOrdenamiento = scanner.nextInt();

        // Obtener el algoritmo de ordenamiento
        System.out.println("Seleccione el algoritmo de ordenamiento:");
        System.out.println("1. Selection sort");
        System.out.println("2. Bubble sort");
        System.out.println("3. Insertion sort");
        System.out.println("4. Merge sort");
        System.out.println("5. Quick sort");
        System.out.println("6. Heap sort");
        System.out.println("7. Counting sort");
        System.out.println("8. Radix sort");
        System.out.print("Ingrese el número correspondiente al algoritmo: ");
        int algoritmo = scanner.nextInt();

        // Crear el objeto de ordenamiento según el algoritmo seleccionado
        Ordenamiento ordenamiento;
        switch (algoritmo) {
            case 1:
                ordenamiento = new SelectionSort();
                break;
            case 2:
                ordenamiento = new BubbleSort();
                break;
            case 3:
                ordenamiento = new InsertionSort();
                break;
            case 4:
                ordenamiento = new MergeSort();
                break;
            case 5:
                ordenamiento = new QuickSort();
                break;
            case 6:
                ordenamiento = new HeapSort();
                break;
            case 7:
                ordenamiento = new CountingSort();
                break;
            case 8:
                ordenamiento = new RadixSort();
                break;
            default:
                System.out.println("Algoritmo no válido. Se utilizará el Bubble sort por defecto.");
                ordenamiento = new BubbleSort();
                break;
        }

        // Ordenar la lista de valores
        if (tipoOrdenamiento == 1) {
            ordenamiento.ordenarAscendente(valores);
        } else {
            ordenamiento.ordenarDescendente(valores);
        }

        // Mostrar la lista ordenada
        System.out.println("Lista ordenada: " + Arrays.toString(valores));
    }
}

// Clase abstracta para los algoritmos de ordenamiento
abstract class Ordenamiento {
    public abstract void ordenarAscendente(String[] valores);

    public abstract void ordenarDescendente(String[] valores);

    protected void intercambiar(String[] arreglo, int i, int j) {
        String temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    protected void imprimirPaso(String[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }
}

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

// Implementación del algoritmo Bubble sort
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

// Implementación del algoritmo Quick sort
class QuickSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        quickSort(valores, 0, valores.length - 1);
    }

    private void quickSort(String[] valores, int low, int high) {
        if (low < high) {
            int pi = partition(valores, low, high);

            quickSort(valores, low, pi - 1);
            quickSort(valores, pi + 1, high);
        }
    }

    private int partition(String[] valores, int low, int high) {
        String pivot = valores[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores[j].compareToIgnoreCase(pivot) < 0) {
                i++;
                intercambiar(valores, i, j);
            }
        }

        intercambiar(valores, i + 1, high);
        imprimirPaso(valores);

        return i + 1;
    }

    public void ordenarDescendente(String[] valores) {
        quickSortDescendente(valores, 0, valores.length - 1);
    }

    private void quickSortDescendente(String[] valores, int low, int high) {
        if (low < high) {
            int pi = partitionDescendente(valores, low, high);

            quickSortDescendente(valores, low, pi - 1);
            quickSortDescendente(valores, pi + 1, high);
        }
    }

    private int partitionDescendente(String[] valores, int low, int high) {
        String pivot = valores[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores[j].compareToIgnoreCase(pivot) > 0) {
                i++;
                intercambiar(valores, i, j);
            }
        }

        intercambiar(valores, i + 1, high);
        imprimirPaso(valores);

        return i + 1;
    }
}

// Implementación del algoritmo Heap sort
class HeapSort extends Ordenamiento {
    public void ordenarAscendente(String[] valores) {
        int n = valores.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapify(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapify(String[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left].compareToIgnoreCase(valores[largest]) > 0) {
            largest = left;
        }

        if (right < n && valores[right].compareToIgnoreCase(valores[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapify(valores, n, largest);
        }
    }

    public void ordenarDescendente(String[] valores) {
        int n = valores.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapifyDescendente(valores, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            intercambiar(valores, 0, i);
            heapifyDescendente(valores, i, 0);
            imprimirPaso(valores);
        }
    }

    private void heapifyDescendente(String[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left].compareToIgnoreCase(valores[largest]) < 0) {
            largest = left;
        }

        if (right < n && valores[right].compareToIgnoreCase(valores[largest]) < 0) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapifyDescendente(valores, n, largest);
        }
    }
}

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