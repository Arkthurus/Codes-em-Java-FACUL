import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Att_Gerenciamento_de_Produtos {
    public static void main(String[] args) {
        Produto p1 = new Produto("RTX 4090 ti SUPER", 7.888, 55);
        Produto p2 = new Produto("Sabonete", 4.55, 274);
        Produto p3 = new Produto("PS8 PRO", 5.999, 31);

        Scanner scanner = new Scanner(System.in);

        int escolha;

        System.out.printf("+---------------------------------+\n");
        System.out.printf("|       Selecione um Protudo      |\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("| 1- RTX 4090 ti SUPER            |\n");
        System.out.printf("| 2- Sabonete                     |\n");
        System.out.printf("| 3- PS8 PRO                      |\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("|           4- Encerrar           |\n");
        System.out.printf("+---------------------------------+\n");
        while (true){

            escolha = scanner.nextInt();
            if (escolha==1){p1.mostrarInfos(p1.getNome(), p1.getPreco(), p1.getQtd());}
            if (escolha==2){p2.mostrarInfos(p2.getNome(), p2.getPreco(), p2.getQtd());}
            if (escolha==3){p3.mostrarInfos(p3.getNome(), p3.getPreco(), p3.getQtd());}
            if (escolha==4){break;}
        }
    }
}
class Produto{
    private String nome;
    private double preco;
    private int qtd;

    Scanner  scanner = new Scanner(System.in);

    //Contructor
    protected Produto(String nome, double preco, int qtd){
        this.nome = nome;
        this.preco = preco;
        this.qtd = qtd;
    }

    //setters
    protected void nome(String nome){
        this.nome = nome;
    }
    protected void setPreco(double preco) {
        this.preco = preco;
    }

    protected void setQtd(int qtd) {
        this.qtd = qtd;
    }

    //Getters
    protected String getNome(){
            return nome;
    }
    protected double getPreco() {
        return preco;
    }
    protected int getQtd() {
        return qtd;
    }

    //Metodos/Funções
    protected void atualizarEstoque(int qtd){
        int novoQTD;
        while(true) {
            System.out.printf("informe o valor da modificação para o estoque(+ = Lote novo/- = vendas): ");
            novoQTD = scanner.nextInt();
            if (novoQTD<0){
                if ((this.qtd-novoQTD)<0){
                    System.out.printf("Quantidade infoma negativa o estoque, insira os dados novamente\n");
                }
                if ((this.qtd-novoQTD)>=0){
                    this.qtd+=novoQTD;
                    System.out.printf("nova QTD atribuida com sucesso!\n");
                    break;
                }
            }
            if (novoQTD>0){
                this.qtd+=novoQTD;
                System.out.printf("nova QTD atribuida com sucesso!\n");

                break;
            }
        }
    }
    protected void atualizarPreco(Double preco){
        System.out.printf("informe o novo preço: ");
        this.preco= scanner.nextDouble();
        System.out.printf("novo valor alterado com sucesso!\n");
    }
    protected void mostrarInfos(String nome, double preco, int qtd){
        System.out.printf("+---------------------------------+\n");
        System.out.printf("|                                 |\n");
        System.out.printf("|Produto: %s                      \n", this.nome);
        System.out.printf("|                                 |\n");
        System.out.printf("|Preço: %s                        \n", this.preco);
        System.out.printf("|                                 |\n");
        System.out.printf("|Quantidade em Estoque: %s         \n", this.qtd);
        System.out.printf("|                                 |\n");
        System.out.printf("+-------------ALterar-------------+\n");
        System.out.printf("|       1- Preço  2- Estoque      |\n");
        System.out.printf("+---------------------------------+\n");

        int escolhaInterna= scanner.nextInt();
        if (escolhaInterna==1){this.atualizarPreco(this.preco);}
        if (escolhaInterna==2){this.atualizarEstoque(this.qtd);};
        if (escolhaInterna==3){this.mostrarInfos(this.nome, this.preco, this.qtd);}
    }
}