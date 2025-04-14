import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ExLivraria {
    public static void main(String[] args) {

        ArrayList<CLIENTE> cliente = new ArrayList<CLIENTE>();

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.printf("+-----------Clientes----------+\n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] adicionar cliente       +\n");
            for (int i = 0; i < cliente.size(); i++) {
                System.out.printf("|                             |\n");
                System.out.printf("+ [%d] %s                      \n", i+2, cliente.get(i).getNome());
            }
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha= sc.nextInt();
            for (int i = 0; i < cliente.size(); i++) {
                if (escolha==(i+2)){MenuCliente(cliente.get(i));}
            }
            if (escolha==1){novoCliente(cliente);}
        }
    }
    protected static void novoCliente(ArrayList<CLIENTE> cliente){

        Scanner sc = new Scanner(System.in);

        System.out.printf("Informe o nome: ");
        String nome = sc.nextLine();
        System.out.printf("Informe a Idade: ");
        int idade = sc.nextInt();
        cliente.add(new CLIENTE(nome, idade));
        sc.nextLine();
    }

    protected static void newEmprestimo(CLIENTE cliente){

        LocalDate hoje = LocalDate.now();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);

        System.out.printf("Deseja  inserir um novo emprestimo?[S/N]\n");
        String escolha = sc.nextLine();
        if (escolha.equalsIgnoreCase("N")){return;}
        cliente.emprestimos.add(new EMPRESTIMO(cliente.emprestimos.size(), cliente, hoje.format(formato)));
        while (true){
            System.out.printf("Informe o Titulo: ");
            String titulo = sc.nextLine();
            System.out.printf("Informe  o Autor: ");
            String autor = sc.nextLine();

            cliente.emprestimos.get(cliente.emprestimos.size()-1).livros.add(new LIVRO(titulo, autor));
            System.out.printf("Deseja  inserir outro livro?[S/N]\n");
            String escolha2  = sc.nextLine();
            if (escolha2.equalsIgnoreCase("S")){ continue;}
            if (escolha2.equalsIgnoreCase("N")){break;}
        }
    }

    protected static void MenuCliente(CLIENTE cliente){

        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.printf("+-----------Cliente-----------+\n");
            System.out.printf("|                             |\n");
            System.out.printf("             %s                \n", cliente.getNome());
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] Novo Emprestimo              \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [2] Emprestimos                 \n");
            System.out.printf("|                             |\n");
            System.out.printf("+ [3] voltar                  \n");
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha = sc.nextInt();
            sc.nextLine();
            if (escolha==1){ newEmprestimo(cliente);}
            if (escolha==2){

                if (cliente.emprestimos.isEmpty()){System.out.printf("Nenhum Emprestimo atrelado ao Cliente!\n");continue;}

                System.out.println("----------------------------------------------------");
                System.out.println("Cliente: " + cliente.getNome());
                System.out.println("Idade: " + cliente.getIdade());
                System.out.println("----------------------------------------------------");
                for (int i = 0; i < cliente.emprestimos.size(); i++) {

                    System.out.println("Numero do Emprestimo: " + (i+1));
                    System.out.println("Data: " + cliente.emprestimos.get(i).getDATA());
                    System.out.println();
                    System.out.println("Livros Emprestados: ");
                    System.out.println();


                    for (LIVRO livros : cliente.emprestimos.get(i).livros) {
                        System.out.println("Nome: " + livros.getTitulo());
                        System.out.println("Autor: " + livros.getAutor());
                        System.out.println();
                    }

                    System.out.println("----------------------------------------------------");
                }
                System.out.printf("[1]voltar");
                int escolha2 = sc.nextInt();
                sc.nextLine();
            }
            if (escolha==3){break;}
        }
    }
}
class CLIENTE{
    private String nome;
    private int idade;
    public ArrayList <EMPRESTIMO> emprestimos = new ArrayList();

    //Constructor
    public CLIENTE(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    //getters
    public String getNome() {return nome;}
    public int getIdade() {return idade;}
    //setters
    public void setNome(String nome) {this.nome = nome;}
    public void setIdade(int idade) {this.idade = idade;}

}
class LIVRO{
    private String titulo;
    private String autor;

    //Constructor
    public LIVRO(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    //getters
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    //setters
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
}
class EMPRESTIMO{
    private int numEmprestimo;
    private CLIENTE cliente;
    public ArrayList<LIVRO> livros =  new ArrayList<>();
    private String DATA;

    //Constructor
    public EMPRESTIMO(int numEmprestimo, CLIENTE cliente, String DATA) {
        this.numEmprestimo = numEmprestimo;
        this.cliente = cliente;
        this.DATA = DATA;
    }
    //getters
    public int getNumEmprestimo() {return numEmprestimo;}
    public CLIENTE getCliente() {return cliente;}
    public String getDATA() {return DATA;}

}