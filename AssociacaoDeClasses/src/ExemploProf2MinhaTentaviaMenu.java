import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploProf2MinhaTentaviaMenu{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList <Cliente> clientes = new ArrayList<>();


        while (true){
            System.out.printf("+-----------Clientes----------+\n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] adicionar cliente       +\n");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.printf("|                             |\n");
                System.out.printf("+ [%d] %s                      \n", i+2, clientes.get(i).getNome());
            }
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha= sc.nextInt();
            for (int i = 0; i < clientes.size(); i++) {
                if (escolha==(i+2)){MenuCliente(clientes.get(i));}
            }
            if (escolha==1){addCliente(clientes);}
        }
    }
    protected static void newPedido(Cliente cliente){

        Scanner sc = new Scanner(System.in);

        System.out.printf("Deseja  cadastrar um produto? [S/N]: ");
        String opcao = sc.nextLine();
        if (opcao.equalsIgnoreCase("N")) {return;}
        cliente.pedidos.add(new Pedido(cliente.pedidos.size(), cliente));
        while (true) {
            System.out.printf("Nome do produto: ");
            String nomeP = sc.nextLine();
            System.out.printf("Quantida comprada: ");
            int QTD = sc.nextInt();
            System.out.printf("Preço unitario: ");
            double precoUni = sc.nextDouble();
            cliente.pedidos.get(cliente.pedidos.size() - 1).itens.add(new ItemPedido(nomeP, QTD, precoUni));
            System.out.printf("Deseja adicionar mais um produto?\n");
            System.out.printf("[1]Sim [2]Não\n");
            int escolha = sc.nextInt();
            if (escolha == 1) {
                sc.nextLine();
                continue;
            }
            if (escolha == 2) {
                break;
            }

        }
    }

    protected static void addCliente(ArrayList<Cliente> clientes){

        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe o nome: ");
        String nome = sc.nextLine();
        System.out.printf("Informe o email: ");
        String email = sc.nextLine();
        System.out.printf("Informe o Endereço: ");
        String cep = sc.nextLine();
        clientes.add(new Cliente( nome, email, cep));
    }

    protected static void MenuCliente(Cliente cliente){

        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.printf("+-----------Cliente-----------+\n");
            System.out.printf("|                             |\n");
            System.out.printf("             %s                \n", cliente.getNome());
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] Novo pedido              \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [2] pedidos                  \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [3] voltar                  \n");
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha = sc.nextInt();
            if (escolha==1){newPedido(cliente);}
            if (escolha==2){

                if (cliente.pedidos.isEmpty()){System.out.printf("Nenhum Pedido atrelado ao Cliente!\n");continue;}

                System.out.println("----------------------------------------------------");
                for (int i = 0; i < cliente.pedidos.size(); i++) {

                    System.out.println("Numero do pedido: " + (i+1));
                    System.out.println("Cliente: " + cliente.getNome());
                    System.out.println("Email: " + cliente.getEmail());
                    System.out.println("Endereco: " + cliente.getEndereco());
                    System.out.println();
                    System.out.println("Itens do pedido:");
                    System.out.println();

                    /* Imprimindo os itens do pedido e calculando o total */
                    double totalPedido = 0;

                    for (ItemPedido item : cliente.pedidos.get(i).itens) {
                        System.out.println("Produto: " + item.nome);
                        System.out.println("Quantidade: " + item.quantidade);
                        System.out.println("Preco unitario: R$ " + item.precoUnitario);
                        System.out.println();

                        totalPedido += item.quantidade * item.precoUnitario;
                    }
                    System.out.printf("Valor total do pedido: R$ %.2f\n", totalPedido);
                    System.out.println("----------------------------------------------------");
                }

                System.out.printf("[1]voltar");
                int escolha2 = sc.nextInt();
            }
            if (escolha==3){break;}
        }
    }
}

class Cliente {
    private String nome;
    private String email;
    private String endereco;
    public ArrayList<Pedido> pedidos = new ArrayList<>();

    /* Construtor da classe */
    public Cliente(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }



    /* Getters */
    protected String getNome(){
        return this.nome;
    }

    protected String getEmail(){
        return this.email;
    }

    protected String getEndereco(){
        return this.endereco;
    }


}

class Pedido {
    private int numero;
    private Cliente cliente;
    public List<ItemPedido> itens = new ArrayList<>(); /* Lista de itens */

    /* Construtor da classe */
    public Pedido(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
    }

}

class ItemPedido {
    public String nome;
    public int quantidade;
    public double precoUnitario;

    /* Construtor da classe */
    public ItemPedido(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
}