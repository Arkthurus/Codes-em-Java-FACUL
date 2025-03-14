import java.util.Scanner;

public class Ex04 {
    public static void main(String[]args){
        CalculoTroco();
    }
    public static void CalculoTroco(){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Insira o Nome do produto: ");
        String nomeProduto = scanner.next();
        System.out.printf("informe o preço do mesmo");
        float preco = scanner.nextFloat();
        System.out.printf("Quanto em dindin vc entregou?");
        float pagamento = scanner.nextFloat();

        float troco=pagamento-preco;
        System.out.printf("Voce comprou um %s no valor de R$%.2f e pagou com R$%.2f\n", nomeProduto, preco, pagamento);
        if (troco>0){System.out.printf("Seu troco sera de R$%.2f", troco);}
        else System.out.printf("NÃO TEM TROCOOOOO!!!");
    }
}
