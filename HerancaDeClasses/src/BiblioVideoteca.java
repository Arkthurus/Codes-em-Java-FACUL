import java.util.ArrayList;
import java.util.Scanner;

public class BiblioVideoteca {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<DVD> filmes = new ArrayList<>();

        while (true) {
            limparTela();  // Limpa a tela antes de mostrar o menu
            System.out.printf("+-----------BiblioVideoTeca----------+\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+ [1] Filmes                         +\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+ [2] Livros                         +\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+ [3] sair                           +\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+------------------------------------+\n");
            int escolha = sc.nextInt();
            if (escolha == 1) {
                MenuFilme(filmes, sc);
            }
            if (escolha == 2) {
                MenuLivros(livros, sc);
            }
            if(escolha==3) {break;}

        }
    }

    public static void MenuFilme(ArrayList<DVD> filmes, Scanner sc) {
        while (true) {
            limparTela();  // Limpa a tela antes de mostrar o menu
            System.out.println("+--------------------------------------+");
            System.out.printf("| %-36s |\n", "Menu - Filmes" );
            System.out.println("+--------------------------------------+");
            System.out.printf("| %-36s |\n", "[1] Adicionar Filme");
            System.out.printf("| %-36s |\n", "[2] Mostrar Filmes");
            System.out.printf("| %-36s |\n", "[3] Voltar");
            System.out.println("+--------------------------------------+");

            int escolha = lerInt(sc, "Escolha uma opção:");
            if (escolha == 1) {adicionarDVD(filmes, sc);} 
            if (escolha == 2) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("-----------------------------");
                for (int i = 0; i < filmes.size(); i++) {
                    filmes.get(i).mostrarInfo();
                    System.out.println("-----------------------------");
                }
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
            } else if (escolha == 3) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    public static void MenuLivros(ArrayList<Livro> livros, Scanner sc){
        while (true) {
            limparTela();  // Limpa a tela antes de mostrar o menu
            System.out.println("+--------------------------------------+");
            System.out.printf("| %-36s |\n", "Menu - Livros" );
            System.out.println("+--------------------------------------+");
            System.out.printf("| %-36s |\n", "[1] Adicionar Livro");
            System.out.printf("| %-36s |\n", "[2] Mostrar Livros");
            System.out.printf("| %-36s |\n", "[3] Voltar");
            System.out.println("+--------------------------------------+");

            int escolha = lerInt(sc, "Escolha uma opção:");
            if (escolha == 1) {adicionarLivro(livros, sc);} 
            if (escolha == 2) {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("-----------------------------");
                for (int i = 0; i < livros.size(); i++) {
                    livros.get(i).mostrarInfo();
                    System.out.println("-----------------------------");
                }
                System.out.println("Pressione ENTER para continuar...");
                sc.nextLine();
            }
            if (escolha == 3) {break;} 
            else {System.out.println("Opção inválida!");}
        }
    }

    public static void adicionarLivro(ArrayList<Livro> livro, Scanner sc) {
        System.out.println("Informe o Titulo: ");
        String titulo = sc.nextLine();
        int ano = lerInt(sc, "Informe o Ano de Publicação:");
        System.out.println("Informe o Autor:");
        String autor = sc.nextLine();
        int numPgs = lerInt(sc, "Informe o Número de Páginas:");
        livro.add(new Livro(titulo, ano, autor, numPgs));
   ;
    }

    public static void adicionarDVD(ArrayList<DVD> filme, Scanner sc) {
        System.out.println("Informe o Titulo: ");
        String titulo = sc.nextLine();
        int ano = lerInt(sc, "Informe o Ano de Publicação:");
        System.out.println("Informe a Categoria:");
        String categoria = sc.nextLine();
        int duracao = lerInt(sc, "Informe a Duração (em minutos):");
        filme.add(new DVD(titulo, ano, categoria, duracao));
    }

    // Função para ler um número inteiro com validação
    public static int lerInt(Scanner sc, String mensagem) {
        System.out.println(mensagem);
        while (!sc.hasNextInt()) {//While age como o "aguardo do input" do sistema(ao entrar na linha do while ja será exigido o input)
            System.out.println("Entrada inválida. Por favor, digite um número.");//mensagem de erro caso n seja um INT.
            sc.next(); // Descartar a entrada inválida
        }
        int numero = sc.nextInt();
        sc.nextLine(); // Consumir a nova linha após o número
        return numero;
    }

    // Função para limpar a tela
    public static void limparTela() {
        System.out.print("\033[H\033[2J");  // Limpa a tela
        System.out.flush();  // Garantir que o comando seja processado
    }
}

class itemBiblio {
    protected String titulo;
    protected int anoPublicacao;

    // CONSTRUCTOR
    public itemBiblio(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    // GETTERS
    public String getTitulo() {
        return titulo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    // SETTERS
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void mostrarInfo() {
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Ano Publicado: " + getAnoPublicacao());
    }
}

class Livro extends itemBiblio {
    private String autor;
    private int numPgs;

    // CONSTRUCTOR
    public Livro(String titulo, int anoPublicacao, String autor, int numPgs) {
        super(titulo, anoPublicacao);
        this.autor = autor;
        this.numPgs = numPgs;
    }

    // GETTERS
    public String getAutor() {
        return autor;
    }

    public int getNumPgs() {
        return numPgs;
    }

    // SETTERS
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setNumPgs(int numPgs) {
        this.numPgs = numPgs;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Autor: " + getAutor());
        System.out.println("Numero de Paginas: " + getNumPgs());
    }
}

class DVD extends itemBiblio {
    private String categoria;
    private int duracao;

    // CONSTRUCTOR
    public DVD(String titulo, int anoPublicacao, String categoria, int duracao) {
        super(titulo, anoPublicacao);
        this.categoria = categoria;
        this.duracao = duracao;
    }

    // GETTERS
    public String getCategoria() {
        return categoria;
    }

    public int getDuracao() {
        return duracao;
    }

    // SETTERS
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Categorias: " + getCategoria());
        System.out.println("Duração: " + getDuracao() + " Minutos");
    }
}
