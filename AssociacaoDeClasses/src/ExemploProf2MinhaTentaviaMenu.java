import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploProf2MinhaTentaviaMenu{
   static int numPedido=0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList <Cliente> clientes = new ArrayList<>();

        ArrayList <Pedido> pedidos = new ArrayList<>();

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
                if (escolha==(i+2)){MenuCliente(clientes.get(i), pedidos);}
            }
            if (escolha==1){addCliente(clientes);}
        }
    }
    protected static void newPedido(Cliente cliente, ArrayList<Pedido> pedidos){

        Scanner sc = new Scanner(System.in);


        while(true){
            pedidos.add(new Pedido(numPedido, cliente));
            System.out.printf("Nome do produto: ");
            String nomeP= sc.nextLine();
            System.out.printf("Quantida comprada: ");
            int QTD = sc.nextInt();
            System.out.printf("Preço unitario: ");
            double precoUni= sc.nextDouble();
            pedidos.get(numPedido).itens.add(new ItemPedido( nomeP, QTD, precoUni));
            System.out.printf("Deseja adicionar mais um produto?\n");
            System.out.printf("[1]Sim [2]Não\n");
            int escolha = sc.nextInt();
            if (escolha==1){numPedido++;sc.nextLine();continue;};
            if (escolha==2){numPedido++;break;};

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

    protected static void MenuCliente(Cliente cliente, ArrayList<Pedido> pedidos){

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
            for (int i = 0; i < 3; i++) {
                if (escolha==i+1){newPedido(cliente, pedidos);}
            }

        }
    }
}

class Cliente {
    private String nome;
    private String email;
    private String endereco;

    /* Construtor da classe */
    public Cliente(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    /* Getters */
    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getEndereco(){
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

    /* Imprimindo o pedido */
    public void imprimirDetalhes() {

        System.out.println("Numero do pedido: " + numero);
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("Endereco: " + cliente.getEndereco());
        System.out.println();
        System.out.println("Itens do pedido:");
        System.out.println();

        /* Imprimindo os itens do pedido e calculando o total */
        double totalPedido = 0;

        for (ItemPedido item : itens) {
            System.out.println("Produto: " + item.nome);
            System.out.println("Quantidade: " + item.quantidade);
            System.out.println("Preco unitario: R$ " + item.precoUnitario);
            System.out.println();

            totalPedido += item.quantidade * item.precoUnitario;
        }

        System.out.printf("Valor total do pedido: R$ %.2f", totalPedido);
        System.out.println();
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