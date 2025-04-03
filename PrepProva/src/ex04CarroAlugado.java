import java.util.Scanner;

public class ex04CarroAlugado {

    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int km, dia;
        float precoFinal;

        System.out.printf("Quantos dias do seu carro alugado? ");
        dia = sc.nextInt();
        System.out.printf("Quantos Km vc percorreu?");
        km = sc.nextInt();

        precoFinal=CalcPreco(dia , km);

        System.out.printf("Preco final: R$ %.2f", precoFinal);
    }

    protected static float CalcPreco(int dia, int km) {
        float diaria=dia*70.0f;
        float KmRodado=km*0.15f;
        float precoFinal=diaria+KmRodado;
        return precoFinal;
    }
}
