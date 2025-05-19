import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
 
public class AgendaContatosATT {
 
    private static final Path CAMINHO_ARQUIVO = Paths.get("C:\\Users\\ARTHURJOAOPADILHACON\\Desktop\\Codes-em-Java-FACUL\\ATT3\\agenda.txt"); /* Caminho constante para o arquivo */
    private static final Scanner sc = new Scanner(System.in); /* Scanner para ler a entrada do usuário */
 
    public static void main(String[] args) {
        int opcao;
        
        do {
            /* Exibe o menu e lê a opção do usuário */
            System.out.println("\n-- Agenda de contatos --\n");
            System.out.println("[1] Adicionar contato");
            System.out.println("[2] Editar contato");
            System.out.println("[3] Excluir contato");
            System.out.println("[4] Listar contatos");
            System.out.println("[5] Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); /* Consumir a nova linha após a leitura do número */
    
            switch (opcao) {
                case 1:
                    sc.nextLine();
                    adicionarContato(sc);
                    break;
                case 2:
                    /* Editando um contato */
                    sc.nextLine();
                    editarContato(sc);
                    break;
                case 3:
                    /* Excluindo um contato */
                    sc.nextLine();
                    excluirContato(sc);
                    break;
                case 4:
                    /* Listando todos os contatos */
                    sc.nextLine();
                    listarContatos();
                    break;
                case 5:
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
 
    private static void adicionarContato(Scanner sc) {
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.println("Digite o Numero: ");
        String telefone = sc.nextLine();

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
 
    private static void editarContato(Scanner sc) {
        try {
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("Arquivo ainda nao existe.");
                return;
            }
            System.out.println("Digite o NumIdentificador do CTT a ser editado: ");
            int numbusca = sc.nextInt();
            sc.nextLine();

            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            /* Verifica se há contatos */
            if (linhas.isEmpty()) {
                System.out.println("Nenhum contato salvo.");
            } else {
                /* Ordena os contatos alfabeticamente */
                Collections.sort(linhas);
            }
            boolean encontrado = false;
            if (linhas.get(numbusca-1) == null) {
                System.out.println("Contado correspondente ao numero n existe!");
            }else{
            System.out.println("Digite o novo Nome: ");
            String nome = sc.nextLine();
            System.out.println("Digite o novo Telefone: ");
            String telefone = sc.nextLine();
            linhas.set(numbusca-1, nome + ";" + telefone); /* Substitui o telefone */
            encontrado = true;
            if (encontrado) {
                /* Sobrescreve o arquivo com os dados atualizados */
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Telefone de " + nome + " atualizado para " + telefone);
            } else {
                System.out.println("Contato " + nome + " nao encontrado.");
            }
        }                    
        } catch (IOException e) {
            System.out.println("Erro ao editar contato: " + e.getMessage());
        }catch( IndexOutOfBoundsException e){System.out.println("Numero indentificador informado n existe!");}
    }
    
    private static void excluirContato(Scanner sc) {
 
        try {
            if (!Files.exists(CAMINHO_ARQUIVO)) {
                System.out.println("Arquivo ainda nao existe.");
                return;
            }
            System.out.println("Digite o NumIdentificador do CTT a ser excluido: ");
            int numbusca = sc.nextInt();

            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
            /* Verifica se há contatos */
            if (linhas.isEmpty()) {
                System.out.println("Nenhum contato salvo.");
            } else {
                /* Ordena os contatos alfabeticamente */
                Collections.sort(linhas);
            }
            boolean encontrado = false;
            if (linhas.get(numbusca-1) == null) {
                System.out.println("Contado correspondente ao numero n existe!");
            }else{
            encontrado = true;
            linhas.remove(numbusca-1);
            }
            if (encontrado) {
                /* Sobrescreve o arquivo com os dados atualizados */
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Contato removido! ");
            } else {
                System.out.println("Contato nao encontrado.");
            }
 
        } catch (IOException e) {
            System.out.println("Erro ao excluir contato: " + e.getMessage());
        }catch( IndexOutOfBoundsException e){System.out.println("Numero indentificador informado n existe!");}
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
 
                /* Exibe os títulos e os contatos formatados */
                System.out.println("\n-- Listagem de Contatos --\n");
 
                System.out.printf("%-4s %-20s %-15s\n", "N.", "Nome", "Telefone");
 
                for (int i = 0; i < linhas.size(); i++) {
                    String[] partes = linhas.get(i).split(";");
                    System.out.printf("%-4s %-20s %-15s\n", i+1, partes[0], partes[1]);
                }
 
                /* Sobrescreve o arquivo com os dados ordenados */
                Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler contatos: " + e.getMessage());
        }
    }
}