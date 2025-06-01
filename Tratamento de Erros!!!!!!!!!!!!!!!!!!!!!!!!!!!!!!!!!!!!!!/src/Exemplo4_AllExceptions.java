public class Exemplo4_AllExceptions {
    public static void main(String[] args) {
        
        /* StringBuilder é uma classe do Java que é utilizada para construir strings */
        StringBuilder erros = new StringBuilder();
        
        try {
            int[] numeros = {10, 20, 30};
            
            /* Tenta realizar a divisão por zero */
            try {
                int resultado = numeros[2] / 0;
                System.out.println("Resultado: " + resultado);
            }
            catch (ArithmeticException e) {
                erros.append("Erro matematico: " + e.getMessage() + "\n");
            }
            
            /* Tenta acessar um índice fora dos limites do array */
            try {
                System.out.println("Numero: " + numeros[5]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                erros.append("Erro de indice de array: " + e.getMessage() + "\n");
            }
        }
        finally {
            /* Exibe todas as mensagens de erro acumuladas */
            if (erros.length() > 0) {
                System.out.println("Erros encontrados:");
                System.out.println(erros.toString());
            }
            System.out.println("Bloco finally sempre sera executado.");
        }
    }
}

