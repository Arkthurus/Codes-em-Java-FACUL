class Exemplo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
 
        try {
            /* Tenta realizar a divisão de 'a' por 'b' */
            int resultado = a / b;
            /* Se não houver erro, imprime o resultado */
            System.out.println("Resultado: " + resultado);
        } 
        catch (ArithmeticException e) {
            /* Captura o erro de divisão por zero e imprime uma mensagem amigável */
            System.out.println("Erro: nao e possivel dividir por zero!");
        }
    }
}