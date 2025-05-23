    import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
 
public class AgendaProf {
 
    private static final Path CAMINHO_ARQUIVO = Paths.get("agenda.txt"); /* Caminho constante para o arquivo */
 
    public static void main(String[] args){
        /* Adicionando contatos manualmente */
        adicionarContato("Marcelo", "1111-1111");
        adicionarContato("Pedro", "2222-2222");
 
        /* Editando telefone do Marcelo */
        editarContato("Marcelo", "9999-9999");
 
        /* Excluindo o contato Pedro */
        excluirContato("Pedro");
 
        /* Listando contatos */
        listarContatos();
    }
 
    private static void adicionarContato(String nome, String telefone) {
        String linha = nome + ";" + telefone; /* Formata os dados */
 
        try {
            /* Escreve a linha no arquivo:
               CREATE: cria o arquivo se não existir
               APPEND: adiciona ao final do arquivo
               System.lineSeparator(): adiciona quebra de linha correta para o sistema operacional */
            Files.write(CAMINHO_ARQUIVO,
                        (linha + System.lineSeparator()).getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);
            System.out.println("Contato adicionado: " + nome);
        } catch (IOException e) {
            System.out.println("Erro ao adicionar contato: " + e.getMessage());
        }
    }
 
    private static void editarContato(String nomeParaEditar, String novoTelefone) {
 
        try {
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("Arquivo ainda nao existe.");
                return;
            }
 
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            boolean encontrado = false;
 
            for (int i = 0; i < linhas.size(); i++) {
                String[] partes = linhas.get(i).split(";");
                if (partes[0].equalsIgnoreCase(nomeParaEditar)) {
                    linhas.set(i, partes[0] + ";" + novoTelefone); /* Substitui o telefone */
                    encontrado = true;
                    break; /* Interrompe quando o contato é encontrado */
                }
            }
 
            if (encontrado) {
                /* Sobrescreve o arquivo com os dados atualizados */
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Telefone de " + nomeParaEditar + " atualizado para " + novoTelefone);
            } else {
                System.out.println("Contato " + nomeParaEditar + " nao encontrado.");
            }
 
        } catch (IOException e) {
            System.out.println("Erro ao editar contato: " + e.getMessage());
        }
    }
 
    private static void excluirContato(String nomeParaExcluir) {
 
        try {
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("Arquivo ainda nao existe.");
                return;
            }
 
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            boolean encontrado = false;
 
            /* Itera sobre a lista e remove o contato com o nome correspondente */
            for (int i = 0; i < linhas.size(); i++) {
                String[] partes = linhas.get(i).split(";");
                if (partes[0].equalsIgnoreCase(nomeParaExcluir)) {
                    linhas.remove(i); /* Remove o contato */
                    encontrado = true;
                    break; /* Interrompe quando o contato é encontrado */
                }
            }
 
            if (encontrado) {
                /* Sobrescreve o arquivo com os dados atualizados */
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Contato removido: " + nomeParaExcluir);
            } else {
                System.out.println("Contato " + nomeParaExcluir + " nao encontrado.");
            }
 
        } catch (IOException e) {
            System.out.println("Erro ao excluir contato: " + e.getMessage());
        }
    }
 
    private static void listarContatos() {
 
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
                System.out.printf("%-20s | %-15s\n", "Nome", "Telefone");
 
                for (String linha : linhas) {
                    String[] partes = linha.split(";");
                    System.out.printf("%-20s | %-15s\n", partes[0], partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler contatos: " + e.getMessage());
        }
    }
}