import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Contato[] contato = new Contato[5];

        int numContatos = 0;

        while(true){
            System.out.println("[1] Adicionar contato");
            System.out.println("[2] Buscar contato");
            System.out.println("[3] Editar contato");
            System.out.println("[4] Excluir contato");
            System.out.println("[5] Listar contatos");
            System.out.println("[6] Sair");
            int opcao = input.nextInt();

            /* Limpa o buffer do teclado */
            input.nextLine();

            switch(opcao){
                /* Adicionar contato */
                case 1:
                    if (contato[contato.length-1] != null){
                        System.out.printf("Lista de Contatos Cheia, exclua algum contato para poder adicionar outro\n");
                        break;
                    }

                    for (int i = 0; i < contato.length; i++) {
                        if (contato[i]==null){
                            System.out.print("Informe nome: ");
                            String nome = input.nextLine();
                            System.out.printf("Informe Telefone: ");
                            String telefone = input.nextLine();

                            contato[numContatos] = new Contato( nome , telefone);

                            System.out.println("Contato cadastrado com sucesso!\n");

                            numContatos++;
                            break;
                        }
                    }

                    break;

                /* Buscar contato */
                case 2:
                    if (numContatos==0){
                        System.out.printf("Nenhum contato existente, adicione contatos para poder usar a BUSCA.\n");
                    }
                    else {
                        System.out.printf("Informe o nome da busca: ");
                        String nomeBusca = input.nextLine();

                        int lidos=0;
                        for (int i = 0; i < numContatos; i++) {
                            if (contato[i].getNome().equalsIgnoreCase(nomeBusca)){
                                System.out.println("Contato " + (i + 1) + ":");
                                System.out.println("Nome: " + contato[i].getNome());
                                System.out.println("Telefone: " + contato[i].getTelefone());
                                System.out.printf("\n");
                                lidos++;
                                break;
                            }
                        }
                        if (lidos==0){
                            System.out.printf("Contado inexistente\n");
                        }
                    }
                    break;

                /* Editar contato */
                case 3:
                    if (numContatos==0){
                        System.out.printf("Nenhum contato existente!\n");
                        break;
                    }

                    System.out.printf("Digite o nome do contato para editar: \n");
                    String nomeEditar = input.nextLine();

                    int lidos=0;
                    for (int i = 0; i < numContatos; i++) {
                        if (contato[i].getNome().equalsIgnoreCase(nomeEditar)){
                            System.out.println("Contato " + (i + 1) + ":");
                            System.out.println("Nome: " + contato[i].getNome());
                            System.out.printf("Novo nome: ");
                            String novoNome = input.nextLine();
                            contato[i].setNome(novoNome);
                            System.out.printf("Telefone:\n " + contato[i].getTelefone());
                            System.out.printf("Novo telefone: ");
                            String novoTel = input.nextLine();
                            contato[i].setTelefone(novoTel);
                            System.out.printf("Contato Alterado com sucesso!\n");

                            lidos++;
                            break;
                        }
                    }
                    if (lidos==0){
                        System.out.printf("Contado inexistente\n");
                    }


                    break;

                /* Excluir contato */
                case 4:
                    if (numContatos==0){
                        System.out.printf("Nenhum contato existente!\n");
                        break;
                    }
                    System.out.printf("Digite o nome do contato para excluir: \n");
                    String nomeExcluir = input.nextLine();

                    int lidos2=0;
                    for (int i = 0; i < numContatos; i++) {
                        if (contato[i]==null){
                            continue;
                        }
                        if (contato[i].getNome().equalsIgnoreCase(nomeExcluir)){
                            contato[i]=null;

                            System.out.printf("Contato excluido com sucesso!\n");
                            numContatos--;
                            lidos2++;
                            break;
                        }
                    }
                    if (lidos2==0){
                        System.out.printf("Contado inexistente\n");
                    }
                    break;

                /* Listar contatos */
                case 5:

                    if (numContatos==0){
                        System.out.printf("Nenhum contato existente!\n");
                    }

                    int variavelNUll=0;
                    for(int i = 0; i < numContatos; i++){

                        if (contato[i]==null){
                            variavelNUll++;
                        }
                        if (contato[i] !=null){
                            System.out.println("Contato " + ((i -variavelNUll)+1) + ":");
                            System.out.println("Nome: " + contato[i].getNome());
                            System.out.println("Telefone: " + contato[i].getTelefone());
                            System.out.printf("\n");
                        }
                    }

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