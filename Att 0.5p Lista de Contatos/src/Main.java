import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
;

public class Main {

    private static final Path CAMINHO_ARQUIVO = Paths.get("agenda.txt");
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Contato[] contato = new Contato[5];

        int numContatos = 0;

        while(true){
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("|====================|");
            System.out.println("[1] Adicionar contato|");
            System.out.println("[2] Buscar contato   |");
            System.out.println("[3] Editar contato   |");
            System.out.println("[4] Excluir contato  |");
            System.out.println("[5] Listar contatos  |");
            System.out.println("[6] Sair             |");
            System.out.println("|====================|");
            System.out.println();
            int opcao = input.nextInt();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            /* Limpa o buffer do teclado */
            input.nextLine();

            switch(opcao){
                /* Adicionar contato */
                case 1:
                    if (contato[contato.length-1] != null){
                        System.out.printf("/_____________________________________\\ \n");
                        System.out.printf("|=====================================|\n");
                        System.out.printf("|       Lista de Contatos Cheia       |\n");
                        System.out.printf("|=====================================|\n");
                        System.out.printf("\\-------------------------------------/\n");;
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();

                        break;
                    }

                    for (int i = 0; i < contato.length; i++) {
                        if (contato[i]==null){
                            System.out.println();
                            System.out.printf(" ________________________________________\n");
                            System.out.printf("/                                        \\ \n");
                            System.out.print("| Informe nome: ");
                            String nome = input.nextLine();
                            System.out.printf("|                                        |\n");
                            System.out.printf("| Informe Telefone: ");
                            String telefone = input.nextLine();
                            System.out.printf("\\________________________________________/\n");;
                            System.out.println();

                            contato[numContatos] = new Contato( nome , telefone);
                            System.out.println();
                            System.out.println();
                            System.out.printf(" _____________________________________\n");
                            System.out.printf("/                                     \\ \n");
                            System.out.printf("|=====================================|\n");
                            System.out.printf("|   Contato cadastrado com sucesso!   |\n");
                            System.out.printf("|=====================================|\n");
                            System.out.printf("\\_____________________________________/\n");

                            String linha = nome + ";" + telefone;

                            try {
                                Files.write(CAMINHO_ARQUIVO,
                                            (linha + System.lineSeparator()).getBytes(), 
                                            StandardOpenOption.CREATE, 
                                            StandardOpenOption.APPEND);
                            } catch (IOException e) {
                            System.out.printf(" _____________________________________\n");
                            System.out.printf("/                                     \\ \n");
                            System.out.printf("|=====================================|\n");
                            System.out.printf("|   Erro ao add Contato: \n"+ e.getMessage() + "|");
                            System.out.printf("|=====================================|\n");
                            System.out.printf("\\_____________________________________/\n");
                            break;
                            }

                            numContatos++;
                            break;
                        }
                    }

                    break;

                /* Buscar contato */
                case 2:
                    if (numContatos==0){
                        System.out.printf(" _____________________________________\n");
                        System.out.printf("/                                     \\ \n");
                        System.out.printf("|=====================================|\n");
                        System.out.printf("|      Nenhum contato existente       |\n");
                        System.out.printf("|=====================================|\n");
                        System.out.printf("\\_____________________________________/\n");;

                    }
                    else {
                        System.out.printf(" ________________________________________\n");
                        System.out.printf("/                                        \\ \n");
                        System.out.printf("|Informe o nome da busca: ");
                        String nomeBusca = input.nextLine();
                        System.out.printf("\\________________________________________/\n");;


                        boolean encontrou = false;
                        for (int i = 0; i < numContatos; i++) {
                            if (contato[i].getNome().equalsIgnoreCase(nomeBusca)){
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.println();
                                System.out.printf(" ______________________________________\n");
                                System.out.println("/______________________________________\\");
                                System.out.println("| Contato " + (i + 1) + ":");
                                System.out.println("|                                      |");
                                System.out.println("| Nome: " + contato[i].getNome());
                                System.out.println("|                                      |");
                                System.out.println("| Telefone: " + contato[i].getTelefone());
                                System.out.println("\\______________________________________/");;
                                encontrou = true;
                                break;
                            }
                        }
                        if (encontrou == false){
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.printf(" ___________________________\n");
                            System.out.printf("/___________________________\\ \n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("|    contato inexistente!   |\n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("\\___________________________/\n");;
                        }
                    }
                    break;

                /* Editar contato */
                case 3:
                    try {
                        if (numContatos==0){
                            System.out.println();
                            System.out.println();
                            System.out.println();
                            System.out.printf(" ___________________________\n");
                            System.out.printf("/                           \\ \n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("| Nenhum contato existente! |\n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("\\___________________________/\n");
                            break;
                        }
                        if (!Files.exists(CAMINHO_ARQUIVO)) {
                            System.out.printf(" ___________________________\n");
                            System.out.printf("/                           \\ \n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("|   Arquivo não existente!  |\n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("\\___________________________/\n");
                            break;
                        }
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.println();
                        System.out.printf(" _____________________________________________________ \n");
                        System.out.printf("/                                                     \\ \n");
                        System.out.printf("|=====================================================|\n");
                        System.out.printf("|Digite o nome do contato para editar: \n");
                        String nomeEditar = input.nextLine();
                        System.out.printf("|=====================================================|\n");
                        System.out.printf("\\_____________________________________________________/\n");
    
                        
    
                        boolean encontradoEdit=false;
                        for (int i = 0; i < numContatos; i++) {
                            if (contato[i].getNome().equalsIgnoreCase(nomeEditar)){
                                System.out.println();
                                System.out.println();
                                System.out.printf(" ________________________________________\n");
                                System.out.printf("/                                        \\ \n");
                                System.out.printf("|                                        |\n");
                                System.out.println("|Contato " + (i + 1));
                                System.out.printf("|                                        |\n");
                                System.out.println("|Nome: " + contato[i].getNome());
                                System.out.printf("|Novo nome: ");
                                String novoNome = input.nextLine();
                                System.out.printf("|                                        |\n");
                                contato[i].setNome(novoNome);
                                System.out.printf("|----------------------------------------|\n");
                                System.out.printf("|                                        |\n");
                                System.out.println("|Telefone: " + contato[i].getTelefone() + "\n");
                                System.out.printf("|Novo telefone: ");
                                String novoTel = input.nextLine();
                                contato[i].setTelefone(novoTel);
                                System.out.printf("|----------------------------------------|\n");
                                System.out.printf("|    Contato Alterado com sucesso!       |\n");
                                System.out.printf("\\________________________________________/ \n");
    
                                encontradoEdit=true;
                                break;
                            }
                        }
                        if (encontradoEdit==false){
                            System.out.println();
                            System.out.println();
                            System.out.printf(" ___________________________\n");
                            System.out.printf("/                           \\ \n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("|    Contato inexistente!   |\n");
                            System.out.printf("|===========================|\n");
                            System.out.printf("\\___________________________/\n");
    
                        }
                    } catch (Exception e) {
                    }
                    break;

                /* Excluir contato */
                case 4:
                    if (numContatos==0){
                        System.out.println();
                        System.out.println();
                        System.out.printf(" ___________________________\n");
                        System.out.printf("/___________________________\\ \n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("| Nenhum contato existente! |\n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("\\___________________________/\n");;
                        break;
                    }
                    System.out.println();
                    System.out.println();
                    System.out.printf(" ____________________________________________________\n");
                    System.out.printf("/                                                    \\ \n");
                    System.out.printf("|====================================================|\n");
                    System.out.printf("|Digite o nome do contato para excluir: \n");
                    String nomeExcluir = input.nextLine();
                    System.out.printf("|====================================================|\n");
                    System.out.printf("\\____________________________________________________/\n");;


                    boolean encontradoEx = false;
                    for (int i = 0; i < numContatos; i++) {
                        if (contato[i]==null){
                            continue;
                        }
                        if (contato[i].getNome().equalsIgnoreCase(nomeExcluir)){
                            contato[i]=null;
                            System.out.println();
                            System.out.println();
                            System.out.printf(" _________________________________\n");
                            System.out.printf("/_________________________________\\ \n");
                            System.out.printf("|=================================|\n");
                            System.out.printf("|  Contato excluido com sucesso!  |\n");
                            System.out.printf("|=================================|\n");
                            System.out.printf("\\_________________________________/\n");;


                            for (int j = i; j < numContatos-1; j++) {
                                contato[j]=contato[j+1];
                            }
                            contato[numContatos-1]=null;
                            numContatos--;
                            encontradoEx = true;
                            break;
                        }
                    }
                    if (encontradoEx==false){
                        System.out.println();
                        System.out.println();
                        System.out.printf(" ___________________________\n");
                        System.out.printf("/___________________________\\ \n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("|    contato inexistente!   |\n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("\\___________________________/\n");

                    }
                    break;

                /* Listar contatos */
                case 5:

                    if (numContatos==0){
                        System.out.printf(" ___________________________\n");
                        System.out.printf("/___________________________\\ \n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("| Nenhum contato existente! |\n");
                        System.out.printf("|===========================|\n");
                        System.out.printf("\\___________________________/\n");
                        break;
                    }

                    int variavelNUll=0;
                    System.out.printf(" ________________________________________ \n");
                    System.out.printf("/                                        \\ \n");
                    for(int i = 0; i < numContatos; i++){

                        if (contato[i]==null){
                            variavelNUll++;
                        }
                        if (contato[i] !=null){
                            System.out.printf("+----------------------------------------+ \n");
                            System.out.printf("|                                        | \n");
                            System.out.println("|Contato " + ((i -variavelNUll)+1) + ":");
                            System.out.println("|Nome: " + contato[i].getNome());
                            System.out.println("|Telefone: " + contato[i].getTelefone());
                            System.out.printf("|                                        | \n");

                        }
                    }
                    System.out.printf("+----------------------------------------+ \n");
                    System.out.printf("\\________________________________________/ \n");

                    break;

                /* Sair */
                case 6:
                    input.close();
                    System.exit(0);

                default:
                    System.out.println("Opcao invalida!\n");
            }
        }
    }
}

class Contato{
    private String nome;
    private String telefone;

    protected Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    protected void setTelefone(String telefone){
        this.telefone = telefone;
    }

    protected void setNome(String nome){
        this.nome = nome;
    }

    protected String getTelefone(){
        return telefone;
    }

    protected String getNome(){
        return nome;
    }
}