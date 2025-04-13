import java.util.ArrayList;
import java.util.List;

public class ExemploProf2 {
    public static void main(String[] args) {

        /* Criando um cliente */
        Cliente2 cliente1 = new Cliente2("Joao", "joao@exemplo.com", "Rua A, 123");

        /* Criando um pedido associado ao cliente */
        Pedido2 pedido1 = new Pedido2(1, cliente1);


        /* Adicionando itens à lista de itens do pedido */
        pedido1.itens.add(new ItemPedido("Produto A", 1, 50.75));
        pedido1.itens.add(new ItemPedido("Produto B", 2, 80.00));

        /* Imprimindo os detalhes do pedido */
        pedido1.imprimirDetalhes();
    }
}

class Cliente2 {
    private String nome;
    private String email;
    private String endereco;

    /* Construtor da classe */
    public Cliente2(String nome, String email, String endereco) {
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

class Pedido2 {
    private int numero;
    private Cliente2 cliente;
    public List<ItemPedido> itens = new ArrayList<>(); /* Lista de itens */

    /* Construtor da classe */
    public Pedido2(int numero, Cliente2 cliente) {
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

class ItemPedido2 {
    public String nome;
    public int quantidade;
    public double precoUnitario;

    /* Construtor da classe */
    public ItemPedido2(String nome, int quantidade, double precoUnitario) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }
}

