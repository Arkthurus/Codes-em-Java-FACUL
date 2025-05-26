import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

public class App {

    private static final Path CAMINHO_ARQUIVO = Paths.get("carros.txt");
    private static final Path CAMINHO_ARQUIVO_RESULT = Paths.get("relatorio.txt");
    public static void main(String[] args) throws IOException{
        if (!Files.exists(CAMINHO_ARQUIVO_RESULT)) {
            Files.createFile(CAMINHO_ARQUIVO_RESULT);
        }

    try {
        List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);

        /* Verifica se há contatos */
        if (linhas.isEmpty()) {
            System.out.println("Nenhum carro salvo.");
        } else {
            /* Ordena os contatos alfabeticamente */
            Collections.sort(linhas);   
           
            double valorGas = 6.29;

            var OutPadrao = System.out;

            var ArqOut = Files.newOutputStream(CAMINHO_ARQUIVO_RESULT, StandardOpenOption.APPEND);

            for (String linha : linhas) {
                System.setOut(new PrintStream(Files.newOutputStream(CAMINHO_ARQUIVO_RESULT, StandardOpenOption.APPEND)));
                String[] partes       = linha.split(";");
                String   marca        = partes[0];
                String   modelo       = partes[1];
                double   mediaConsumo = Double.parseDouble(partes[2]);
                double   combGasto    = 1000f / mediaConsumo;
                double   valorGasto   = combGasto * valorGas;
             
                String linhaRegistro = marca + ";" + modelo + ";" + "%.2f".formatted(mediaConsumo) + ";" + "%.2f".formatted(combGasto) + ";" + "%.2f".formatted(valorGasto);
                try {
                    System.out.println("-------------------------------------------------------------------------------------------------------");
                    System.out.printf("| Marca: %-10s | Modelo: %-7s | Km/l: %6.2f | QTD Gasta: %6.2f L  | Valor Gasto: %8.2f R$\n", marca, modelo, mediaConsumo, combGasto, valorGasto);
                    System.setOut(OutPadrao);
                    System.out.println(modelo+ " salvo!");
                } catch (Exception e) {
                    System.out.println("Erro ao Salvar Calculo!");
                }
            }

            ArqOut.close();
            
            
        }
    } catch (IOException e) {
        System.out.println("Erro ao lercarros: " + e.getMessage());
    }
}
}
