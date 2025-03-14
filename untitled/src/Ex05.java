import java.util.Scanner;

public class Ex05 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Insira o Nome do produto: ");
        String nomeProduto = scanner.next();
        System.out.printf("informe o preço do produto: ");
        float preco = scanner.nextFloat();

        DescontoProduto(nomeProduto, preco);
    }
    public static void DescontoProduto(String nomeProduto, float preco){
        System.out.printf("Voce comprou um %s por R$%.2f e acaba de ganhar um desconto de 10%% NO TOTAL DA COMPRAAAA!!!\n", nomeProduto, preco);
        float precoFinal=preco-(preco*0.10f);
        System.out.printf("Assim voce vai pagar apenas R$%.2f", precoFinal);
    }
}
