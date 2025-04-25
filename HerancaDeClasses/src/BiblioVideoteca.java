import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class BiblioVideoteca {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        ArrayList<Livro>livros=new ArrayList<>();

        ArrayList<DVD>filmes=new ArrayList<>();

        while (true){
            System.out.printf("+-----------BiblioVideoTeca----------+\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+ [1] Filmes                         +\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+ [2] Livros                         +\n");
            System.out.printf("|                                    |\n");
            System.out.printf("+------------------------------------+\n");
            int escolha= sc.nextInt();
            if (escolha==1){MainMENU(filmes, escolha);}
            if (escolha==2){MainMENU(livros, escolha);}
        }

    }

    public static void MainMENU(ArrayList<? extends itemBiblio> item, int escolhaRecebida){

        Scanner sc=new Scanner(System.in);

        while (true){
            System.out.printf("+--------------%s-------------+\n",item.getClass().getCanonicalName());
            System.out.printf("|                             |\n");
            System.out.printf("+ [1] Adicionar %s             \n", item.getClass().getCanonicalName());
            System.out.printf("|                             |\n");
            System.out.printf("+ [2] Mostrar %s               \n", item.getClass().getCanonicalName());
            System.out.printf("|                             |\n");
            System.out.printf("+ [3] voltar                   \n");
            System.out.printf("|                             |\n");
            System.out.printf("+-----------------------------+\n");
            int escolha = sc.nextInt();
            if (escolha==1){
                if (escolhaRecebida==2){
                    addItem((ArrayList<Livro>) (item));
                }else addItemDVD((ArrayList<DVD>) (item));
            }
            if (escolha==2){
                for (int i = 0; i < item.size(); i++) {
                    item.get(i).mostrarInfo();
                }
                System.out.println();
            }
            if (escolha==3){break;}
        }
    }
    public static void addItem(ArrayList<Livro> livro){

        Scanner sc=new Scanner(System.in);

        System.out.println("Informe o Titulo: ");
        String titulo=sc.nextLine();
        System.out.println("informe o Ano de Publicação");
        int ano=sc.nextInt();
        sc.nextLine();
        System.out.println("Informe o Autor:");
        String autor= sc.nextLine();
        System.out.println("Informe o Numero de Pgs: ");
        int numpgs= sc.nextInt();
        sc.nextLine();
        livro.add(new Livro(titulo, ano, autor, numpgs));
    }
    public static void addItemDVD(ArrayList<DVD> filme){

        Scanner sc=new Scanner(System.in);

        System.out.println("Informe o Titulo: ");
        String titulo=sc.nextLine();
        System.out.println("informe o Ano de Publicação");
        int ano=sc.nextInt();
        sc.nextLine();
        System.out.println("Informe a Categoria:");
        String categoria= sc.nextLine();
        System.out.println("Informe a Duração: ");
        int duração= sc.nextInt();
        sc.nextLine();
        filme.add(new DVD(titulo, ano, categoria, duração));
    }
}
class itemBiblio{
    protected String titulo;
    protected int anoPublicacao;

    //CONSTRUCTOR
    public itemBiblio(String titulo, int anoPublicacao){
        this.titulo=titulo;
        this.anoPublicacao=anoPublicacao;
    }
    //GETTERS
    public String getTitulo(){return titulo;}
    public int getAnoPublicacao(){return anoPublicacao;}
    //SETTERS
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAnoPublicacao(int anoPublicacao) {this.anoPublicacao = anoPublicacao;}

    public void mostrarInfo(){
        System.out.println("Titulo: "+getTitulo());
        System.out.println("Ano Publicado: "+getAnoPublicacao());
    }
}
class Livro extends itemBiblio{
    private String autor;
    private int numPgs;

    //CONSTRUCTOR
    public Livro(String titulo, int anoPublicacao, String autor, int numPgs){
        super(titulo, anoPublicacao);
        this.autor=autor;
        this.numPgs=numPgs;
    }
    //GETTERS
    public String getAutor(){return autor;}
    public int getNumPgs(){return numPgs;}
    //SETTERS
    public void setAutor(String autor) {this.autor = autor;}
    public void setNumPgs(int numPgs) {this.numPgs = numPgs;}

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Autor: "+getAutor());
        System.out.println("Numero de Paginas: "+getNumPgs());
    }
}
class DVD extends itemBiblio{
    private String categoria;
    private int duracao;

    //CONSTRUCTOR
    public DVD(String titulo, int anoPublicacao, String categoria, int duracao){
        super(titulo, anoPublicacao);
        this.categoria=categoria;
        this.duracao=duracao;
    }
    //GETTERS
    public String getCategoria() {return categoria;}
    public int getDuracao() {return duracao;}
    //SETTERS
    public void setCategoria(String categoria){this.categoria=categoria;}
    public void setDuracao(int duracao) {this.duracao = duracao;}

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Categorias: "+getCategoria());
        System.out.println("Duração: "+getDuracao()+" Minutos");
    }
}