import java.util.Scanner;
 
public class Exemplo5_illegalExceptions {
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        try {
            System.out.print("Digite um numero nao negativo: ");
            int numero = scanner.nextInt();
 
            /* Lança uma exceção se o número for negativo */
            if (numero < 0) {
                throw new IllegalArgumentException("Numero nao pode ser negativo.");
            }
 
            System.out.println("Voce digitou o numero " + numero + ".");
        }
        /* Captura a exceção e exibe a mensagem de erro */
        catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        finally {
            scanner.close();
        }
    }
}