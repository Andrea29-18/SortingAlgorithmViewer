import java.util.Scanner;

class Ordenador {

    private int[] numeros;
    private int tamanyo;
    private String orden;

    public Ordenador() {
        this.numeros = new int[0];
        this.tamanyo = 0;
        this.orden = "ascendente";
    }

    public void pedirNumeros() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cuántos números quieres ingresar?");
        this.tamanyo = scanner.nextInt();

        this.numeros = new int[this.tamanyo];

        for (int i = 0; i < this.tamanyo; i++) {
            System.out.println("Ingresa el número " + (i + 1));
            this.numeros[i] = scanner.nextInt();
        }
    }


    public void pedirOrden() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Cómo quieres ordenar los números? (ascendente/descendente)");
        this.orden = scanner.next();
    }

    public void ordenar() {
        if (this.orden.equals("ascendente")) {
            selectionSort();
        } else {
            selectionSort();
        }
    }

    public void mostrarNumeros() {
        System.out.println("Los números ordenados son: ");
        for (int i = 0; i < this.tamanyo; i++) {
            System.out.print(this.numeros[i] + " ");
        }
        System.out.println();
    }

    private void selectionSort() {
        for (int i = 0; i < this.tamanyo - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < this.tamanyo; j++) {
                if (this.numeros[j] < this.numeros[minimo]) {
                    minimo = j;
                }
            }
            int temp = this.numeros[i];
            this.numeros[i] = this.numeros[minimo];
            this.numeros[minimo] = temp;
        }
    }

    public static void main(String[] args) {
        Ordenador ordenador = new Ordenador();

        ordenador.pedirNumeros();
        ordenador.pedirOrden();
        ordenador.ordenar();
        ordenador.mostrarNumeros();
    }
}