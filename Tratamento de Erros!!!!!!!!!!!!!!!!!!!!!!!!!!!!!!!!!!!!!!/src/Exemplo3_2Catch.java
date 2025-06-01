public class Exemplo3_2Catch {
    public static void main(String[] args) {
        try {
            int[] numeros = {10, 20, 30};
 
            /* Gera uma ArithmeticException: divisão por zero */
            int resultado = numeros[2] / 0; 
            System.out.println("Resultado: " + resultado);
 
            /* Este código não será executado, pois a exceção acima interrompe o fluxo */
            System.out.println("Numero: " + numeros[5]); 
        } 
        /* Captura e trata o erro de divisão por zero */
        catch (ArithmeticException e) {
            System.out.println("Erro de matematico: " + e.getMessage());
        } 
        /* Captura e trata o erro de acesso a um índice inválido do array */
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro de indice de array: " + e.getMessage());
        } 
        /* Sempre será executado, mesmo se uma exceção for lançada */
        finally {
            System.out.println("Bloco finally sempre sera executado.");
        }
    }
}