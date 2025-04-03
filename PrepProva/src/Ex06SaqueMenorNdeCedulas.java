import java.util.Scanner;

public class Ex06SaqueMenorNdeCedulas {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe o valor para saque: ");
        int saque = sc.nextInt();

        QtdCedulas(saque);

        sc.close();
    }

    protected  static void QtdCedulas(int saque){
        System.out.printf("Cedulas de 100: %d\n", saque/100);
        saque = saque % 100;
        System.out.printf("Cedulas de 50: %d\n", saque/50);
        saque = saque % 50;
        System.out.printf("Cedulas de 20: %d\n", saque/20);
        saque = saque % 20;
        System.out.printf("Cedulas de 10: %d\n", saque/10);
        saque = saque % 10;
        System.out.printf("Cedulas de 5: %d\n", saque/5);
        saque = saque % 5;
    }
}
