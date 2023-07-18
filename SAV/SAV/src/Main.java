import java.util.Arrays;
import java.util.Scanner;

class OrdenamientoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la cantidad de valores
        System.out.print("Ingrese la cantidad de valores: ");
        int cantidadValores = scanner.nextInt();

        // Obtener los valores
        int[] valores = new int[cantidadValores];
        System.out.println("Ingrese los valores, uno por línea:");
        for (int i = 0; i < cantidadValores; i++) {
            valores[i] = scanner.nextInt();
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
    public abstract void ordenarAscendente(int[] valores);

    public abstract void ordenarDescendente(int[] valores);

    protected void intercambiar(int[] arreglo, int i, int j) {
        int temp = arreglo[i];
        arreglo[i] = arreglo[j];
        arreglo[j] = temp;
    }

    protected void imprimirPaso(int[] arreglo) {
        System.out.println(Arrays.toString(arreglo));
    }
}

// Implementación del algoritmo Selection sort
class SelectionSort extends Ordenamiento {
    public void ordenarAscendente(int[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores[j] < valores[minIndex]) {
                    minIndex = j;
                }
            }
            intercambiar(valores, i, minIndex);
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(int[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (valores[j] > valores[maxIndex]) {
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
    public void ordenarAscendente(int[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores[j] > valores[j + 1]) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }

    public void ordenarDescendente(int[] valores) {
        int n = valores.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores[j] < valores[j + 1]) {
                    intercambiar(valores, j, j + 1);
                    imprimirPaso(valores);
                }
            }
        }
    }
}

// Implementación del algoritmo Insertion sort
class InsertionSort extends Ordenamiento {
    public void ordenarAscendente(int[] valores) {
        int n = valores.length;

        for (int i = 1; i < n; i++) {
            int key = valores[i];
            int j = i - 1;
            while (j >= 0 && valores[j] > key) {
                valores[j + 1] = valores[j];
                j--;
            }
            valores[j + 1] = key;
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(int[] valores) {
        int n = valores.length;

        for (int i = 1; i < n; i++) {
            int key = valores[i];
            int j = i - 1;
            while (j >= 0 && valores[j] < key) {
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
    public void ordenarAscendente(int[] valores) {
        mergeSort(valores, 0, valores.length - 1);
    }

    private void mergeSort(int[] valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSort(valores, l, m);
            mergeSort(valores, m + 1, r);

            merge(valores, l, m, r);
        }
    }

    private void merge(int[] valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = valores[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = valores[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
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

    public void ordenarDescendente(int[] valores) {
        mergeSortDescendente(valores, 0, valores.length - 1);
    }

    private void mergeSortDescendente(int[] valores, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            mergeSortDescendente(valores, l, m);
            mergeSortDescendente(valores, m + 1, r);

            mergeDescendente(valores, l, m, r);
        }
    }

    private void mergeDescendente(int[] valores, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i) {
            L[i] = valores[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = valores[m + 1 + j];
        }

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] >= R[j]) {
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
    public void ordenarAscendente(int[] valores) {
        quickSort(valores, 0, valores.length - 1);
    }

    private void quickSort(int[] valores, int low, int high) {
        if (low < high) {
            int pi = partition(valores, low, high);

            quickSort(valores, low, pi - 1);
            quickSort(valores, pi + 1, high);
        }
    }

    private int partition(int[] valores, int low, int high) {
        int pivot = valores[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores[j] < pivot) {
                i++;
                intercambiar(valores, i, j);
            }
        }

        intercambiar(valores, i + 1, high);
        imprimirPaso(valores);

        return i + 1;
    }

    public void ordenarDescendente(int[] valores) {
        quickSortDescendente(valores, 0, valores.length - 1);
    }

    private void quickSortDescendente(int[] valores, int low, int high) {
        if (low < high) {
            int pi = partitionDescendente(valores, low, high);

            quickSortDescendente(valores, low, pi - 1);
            quickSortDescendente(valores, pi + 1, high);
        }
    }

    private int partitionDescendente(int[] valores, int low, int high) {
        int pivot = valores[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (valores[j] > pivot) {
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
    public void ordenarAscendente(int[] valores) {
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

    private void heapify(int[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left] > valores[largest]) {
            largest = left;
        }

        if (right < n && valores[right] > valores[largest]) {
            largest = right;
        }

        if (largest != i) {
            intercambiar(valores, i, largest);
            heapify(valores, n, largest);
        }
    }

    public void ordenarDescendente(int[] valores) {
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

    private void heapifyDescendente(int[] valores, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && valores[left] < valores[largest]) {
            largest = left;
        }

        if (right < n && valores[right] < valores[largest]) {
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
    public void ordenarAscendente(int[] valores) {
        int n = valores.length;

        int max = valores[0];
        for (int i = 1; i < n; i++) {
            if (valores[i] > max) {
                max = valores[i];
            }
        }

        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; ++i) {
            count[valores[i]]++;
        }

        for (int i = 1; i <= max; ++i) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[valores[i]] - 1] = valores[i];
            count[valores[i]]--;
        }

        for (int i = 0; i < n; i++) {
            valores[i] = output[i];
            imprimirPaso(valores);
        }
    }

    public void ordenarDescendente(int[] valores) {
        int n = valores.length;

        int max = valores[0];
        for (int i = 1; i < n; i++) {
            if (valores[i] > max) {
                max = valores[i];
            }
        }

        int[] count = new int[max + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; ++i) {
            count[valores[i]]++;
        }

        for (int i = max - 1; i >= 0; --i) {
            count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[valores[i]] - 1] = valores[i];
            count[valores[i]]--;
        }

        for (int i = 0; i < n; i++) {
            valores[i] = output[i];
            imprimirPaso(valores);
        }
    }
}

// Implementación del algoritmo Radix sort
class RadixSort extends Ordenamiento {
    public void ordenarAscendente(int[] valores) {
        int max = getMax(valores);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(valores, exp);
            imprimirPaso(valores);
        }
    }

    private int getMax(int[] valores) {
        int max = valores[0];
        int n = valores.length;
        for (int i = 1; i < n; i++) {
            if (valores[i] > max) {
                max = valores[i];
            }
        }
        return max;
    }

    private void countingSort(int[] valores, int exp) {
        int n = valores.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(valores[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(valores[i] / exp) % 10] - 1] = valores[i];
            count[(valores[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            valores[i] = output[i];
        }
    }

    public void ordenarDescendente(int[] valores) {
        int max = getMax(valores);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortDescendente(valores, exp);
            imprimirPaso(valores);
        }
    }

    private void countingSortDescendente(int[] valores, int exp) {
        int n = valores.length;
        int[] output = new int[n];
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(valores[i] / exp) % 10]++;
        }

        for (int i = 8; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(valores[i] / exp) % 10] - 1] = valores[i];
            count[(valores[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++) {
            valores[i] = output[i];
        }
    }
}
