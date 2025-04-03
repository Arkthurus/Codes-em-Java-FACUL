import java.util.Scanner;

public class Ex02AntecessorAndSucessor {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe um numero: ");
        int n = sc.nextInt();
        mostrarAntESuc(n);
    }

    public static void mostrarAntESuc(int n) {
        System.out.printf("Numero informado: %d\n", n);
        System.out.printf("Antecessor: %d\n", n-1);
        System.out.printf("Sucessor: %d\n", n+1);
    }
}
