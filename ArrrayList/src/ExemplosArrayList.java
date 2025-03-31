import java.util.ArrayList;
import java.util.Scanner;

public class ExemplosArrayList {
    /* Criando uma lista de frutas */
    static ArrayList<Fruta> frutas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    int numeroFrutas=0;

    public static void main(String[] args) {

        while(true) {

            System.out.printf("");

            /* Limpando a lista */
            frutas.clear();

            /* verificando se a lista está vazia */
            if (frutas.isEmpty()) {
                System.out.println("A lista esta vazia\n");
            }
        }
    }
    protected void ProcurarFruta(ArrayList<Fruta> frutas){
        boolean encontrouLaranja = false;
        System.out.printf("Digite o nome da fruta a ser buscada: ");
        String nomeFruta = scanner.nextLine();
        for (int i = 0; i < frutas.size(); i++){
            if (frutas.get(i).getNome().equalsIgnoreCase(nomeFruta)) {
                encontrouLaranja = true;
                System.out.printf("%s existe na Lista\n", nomeFruta);
                break;
            }
        }
        if (encontrouLaranja==false){
            System.out.printf("%s não existe na lista\n", nomeFruta);
        }
    }
    protected void AdicionarFruta(ArrayList<Fruta> frutas){

        if (numeroFrutas==4){
            System.out.printf("A lista esta Cheia!\n");
        }
        else {
            System.out.printf("Digite o nome da Fruta: ");
            String nome = scanner.nextLine();
            System.out.printf("Digite q QTD: ");
            int QTD = scanner.nextInt();
            frutas.add(new Fruta(nome, QTD));
            numeroFrutas++;
        }
    }

    protected void ListarFrutas(){
        if (frutas.isEmpty()){
            System.out.printf("A lista esta vazia!\n");
        }
        else {
            System.out.println("Elementos da lista:");
            for (int i = 0; i < frutas.size(); i++) {
                Fruta fruta = frutas.get(i);
                fruta.mostrarInformacoes();
            }
        }
    }
    protected void AlterarQTD(){
        if (frutas.isEmpty()){
            System.out.printf("A lista esta vazia!\n");
        }
        else {
            System.out.printf("Informe o nome da fruta q tera sua QTD alterada: ");
            String nomeFrutaBusca = scanner.nextLine();
            boolean encontrou = false;
            for (int i = 0; i < frutas.size(); i++) {
                if (frutas.get(i).getNome().equalsIgnoreCase(nomeFrutaBusca)) {
                    System.out.printf("Informe o novo valor da QTD:");
                    int qtd = scanner.nextInt();
                    frutas.get(i).setQuantidade(qtd);
                    encontrou = true;
                }
            }
            if (encontrou==false){
                System.out.printf("%s n foi encontrada na lista!\n", nomeFrutaBusca);
            }
        }
    }
    protected void RemoverFruta(){
        System.out.printf("Informe o nome da fruta q sera excluida: ");
        String nomeFrutaEx = scanner.nextLine();
        boolean encontrou = false;
        for (int i = 0; i < frutas.size(); i++){
            if (frutas.get(i).getNome().equalsIgnoreCase(nomeFrutaEx)){
                frutas.remove(i);
                encontrou = true;
            }
        }
        if (encontrou==false){
            System.out.printf("%s n foi encontrada na lista!\n", nomeFrutaEx);
        }
    }
}



class Fruta{
    private String nome;
    private int quantidade;

    Scanner scanner = new Scanner(System.in);

    public Fruta(String nome, int quantidade){
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void mostrarInformacoes(){
        System.out.println("Nome: " + nome + " / Quantidade: " + quantidade);
    }
}

