import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class AgendaContatos {
 
    private static final Path CAMINHO_ARQUIVO = Paths.get("agenda.txt"); /* Caminho constante para o arquivo */
 
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList <CONTATO> contatos = new ArrayList<>();

        while (true) {
            System.out.println("|====================|");
            System.out.println("[1] Adicionar contato|");
            System.out.println("[2] Editar contato   |");
            System.out.println("[3] Excluir contato  |");
            System.out.println("[4] Listar contatos  |");
            System.out.println("[5] Sair             |");
            System.out.println("|====================|");
            int escolha = sc.nextInt();
            sc.nextLine();
            if (escolha==1) {adicionarContato(contatos, sc);}
            if (escolha==2) {editarContato(contatos, sc);}
            if (escolha==3) {excluirContato(contatos, sc);}
            if (escolha==4) {listarContatos();}
            if (escolha==5) {System.exit(0);}
        }


    }
 
    private static void adicionarContato(ArrayList<CONTATO> contatos, Scanner sc) {
        while (true) {
            
            System.out.println("Nome: ");
            String nome = sc.nextLine();
            System.out.println("Telefone: ");
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
                            contatos.add(new CONTATO(nome, telefone));
                System.out.println("Contato adicionado: " + nome);
            } catch (IOException e) {
                System.out.println("Erro ao adicionar contato: " + e.getMessage());
            }
            break;
        }
    }
 
    private static void editarContato(ArrayList<CONTATO> contatos, Scanner sc) {
 
        while (true) {
            try {
                if (!Files.exists(CAMINHO_ARQUIVO)) {
                    System.out.println("Arquivo ainda nao existe.");
                    break;
                }

                System.out.println("Nome a ser buscado:");
                String nomeBusca = sc.nextLine();
     
                List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
                boolean encontrado = false;
     
                for (int i = 0; i < linhas.size(); i++) {
                    String[] partes = linhas.get(i).split(";");
                    if (partes[0].equalsIgnoreCase(nomeBusca)) {
                        System.out.println("Novo Nome:");
                        String nome = sc.nextLine();
                        System.out.println("Novo Telefone:");
                        String telefone = sc.nextLine();
                        contatos.get(i).setNome(nome);
                        contatos.get(i).setTelefone(telefone);
                        linhas.set(i, nome + ";" + telefone); /* Substitui o telefone */
                        encontrado = true;
                        break; /* Interrompe quando o contato é encontrado */
                    }
                }
     
                if (encontrado) {
                    /* Sobrescreve o arquivo com os dados atualizados */
                    Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                    for (int i = 0; i < contatos.size(); i++) {
                        if (contatos.get(i).getNome().equalsIgnoreCase(nomeBusca)) {
                            System.out.println("Telefone de " + nomeBusca + " atualizado para " + contatos.get(i).getTelefone());    
                        }
                        
                    }
                    break;
                } else {
                    System.out.println("Contato " + nomeBusca + " nao encontrado.");
                    break;
                }
     
            } catch (IOException e) {
                System.out.println("Erro ao editar contato: " + e.getMessage());
                break;
            }
        }
    }
 
    private static void excluirContato(ArrayList<CONTATO> contatos, Scanner sc) {
        while (true) {
            try {
                if (!Files.exists(CAMINHO_ARQUIVO)) {
                    System.out.println("Arquivo ainda nao existe.");
                    break;
                }

                System.out.println("Nome para excluir: ");
                String nomeEx = sc.nextLine();
     
                List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
                boolean encontrado = false;
     
                /* Itera sobre a lista e remove o contato com o nome correspondente */
                for (int i = 0; i < linhas.size(); i++) {
                    String[] partes = linhas.get(i).split(";");
                    if (partes[0].equalsIgnoreCase(nomeEx)) {
                        linhas.remove(i); /* Remove o contato */
                        encontrado = true;
                        break; /* Interrompe quando o contato é encontrado */
                    }
                }
     
                if (encontrado) {
                    /* Sobreescreve o arquivo com os dados atualizados */
                    Files.write(CAMINHO_ARQUIVO, linhas, StandardOpenOption.TRUNCATE_EXISTING);
                    System.out.println("Contato removido: " + nomeEx);
                    break;
                } else {
                    System.out.println("Contato " + nomeEx + " nao encontrado.");
                    break;
                }
     
            } catch (IOException e) {
                System.out.println("Erro ao excluir contato: " + e.getMessage());
                break;
            }
        }
    }
 
    private static void listarContatos() {
        System.out.println("\nListagem de Contatos\n");
 
        try {
            List<String> linhas = Files.readAllLines(CAMINHO_ARQUIVO);
 
            /* Verifica se há contatos */
            if (linhas.isEmpty()) {
                System.out.println("Nenhum contato salvo.");
            } else {
                /* Exibe os contatos formatados */
                for (String linha : linhas) {
                    String[] partes = linha.split(";");
                    System.out.println("Nome: " + partes[0]);
                    System.out.println("Telefone: " + partes[1]);
                    System.out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler contatos: " + e.getMessage() + " não existe");
        }
    }
}
class CONTATO{
    private String nome;
    private String telefone;

    public CONTATO(String nome, String telefone){
        this.nome=nome;
        this.telefone=telefone;
    }

    public String getNome(){return nome;}
    public String getTelefone(){return telefone;}

    public void setNome(String nome){this.nome=nome;}
    public void setTelefone(String telefone){this.telefone=telefone;}
}