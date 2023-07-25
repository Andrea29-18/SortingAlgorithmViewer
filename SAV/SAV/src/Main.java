import java.util.*;

class OrdenamientoMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Obtener la cantidad de valores
        System.out.print("Ingrese la cantidad de valores: ");
        int cantidadValores = scanner.nextInt();

        // Obtener los valores
        List<String> valores = new ArrayList<>();
        System.out.println("Ingrese los valores, uno por línea:");
        for (int i = 0; i < cantidadValores; i++) {
            valores.add(scanner.next());
        }

        // Eliminar duplicados
        eliminarDuplicados(valores);

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
        AlgoritmoOrdenamiento ordenamiento;
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
                throw new IllegalArgumentException("Algoritmo no válido.");
        }

        // Ordenar la lista de valores
        if (tipoOrdenamiento == 1) {
            ordenamiento.ordenarAscendente(valores);
        } else {
            ordenamiento.ordenarDescendente(valores);
        }

        // Mostrar la lista ordenada
        System.out.println("Lista ordenada: " + valores);
    }

    private static void eliminarDuplicados(List<String> valores) {
        Set<String> uniqueValues = new LinkedHashSet<>(valores);
        valores.clear();
        valores.addAll(uniqueValues);
    }
}