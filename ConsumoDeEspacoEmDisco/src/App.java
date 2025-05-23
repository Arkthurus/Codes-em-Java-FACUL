import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class App {

    private static final Path CAMINHO_ARQUIVO = Paths.get("consumo.txt");
    public static void main(String[] args){
        if (!Files.exists(CAMINHO_ARQUIVO)) {
            System.out.println("Arquivo ainda nao existe.");
            return;
        }

    try {
        List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

        /* Verifica se há contatos */
        if (linhas.isEmpty()) {
            System.out.println("Nenhum contato salvo.");
        } else {
            /* Ordena os contatos alfabeticamente */
            Collections.sort(linhas);

            /* Exibe os contatos formatados */
            System.out.println("\nListagem de Contatos\n");

            /* Exibe os títulos, com o mesmo espaçamento (20 espaços para o nome e 15 para o telefone */
            System.out.printf("%-5s | %-15s | %-15s | %-5s\n", "Nr.", "User", "Espaço utilizado", "% de uso" );
            System.out.println("------------------------------------------------------");
            int i = 0;
            double soma=0;
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                soma += Double.parseDouble(partes[1]);

            }
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                String nome = partes[0];
                double Mb = (Double.parseDouble(partes[1]))/(1024*1024);
                double porcent = (Mb/(soma/(1024*1024)))*100;
                System.out.printf("%-5s | %-15s | %-16.2f | %-5.2f \n", i+1, nome, Mb, porcent);
                System.out.println("------------------------------------------------------");
                i++;
            }
            System.out.printf("Espaço Total Ocupado: %.2f\n", ((soma)/(1024*1024)));
            System.out.printf("Espaço Médio Ocupado: %.2f\n", ((soma)/(1024*1024))/i);
            


        }
    } catch (IOException e) {
        System.out.println("Erro ao ler contatos: " + e.getMessage());
    }
}
}
