class Exemplo2Finally {
    public static void main(String[] args) {
        try {
            int[] numeros = {1, 2, 3};
 
            /* Tentativa de acessar o índice 5, que não existe (gera exceção) */
            System.out.println(numeros[5]);
        } 
        /* Captura a exceção de acesso a um índice inexistente do array */
        catch (ArrayIndexOutOfBoundsException e) {
            
            System.out.println("Erro: indice fora dos limites do array.");
        } 
        /* Este bloco será executado independentemente de erro ocorrer ou não */
        finally {
            System.out.println("Bloco finally sempre sera executado.");
        }
    }
}
