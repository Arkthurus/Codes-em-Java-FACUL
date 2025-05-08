public class BiblioVideoteca_vProf {
    public static void main(String[] args) {
        /* Criando instancias de diferentes tipos de itens */
        Livro livro = new Livro("O cavaleiro preso na armadura", 1993, "Robert Fisher", 128);
        DVD dvd = new DVD("Matrix", 1999, "Ficcao Cientifica", 136);
        
        /* Chamando o metodo mostrarDetalhes() para cada item */
        System.out.println("Detalhes do livro:");
        livro.mostrarDetalhes();
        
        System.out.println("\nDetalhes do DVD:");
        dvd.mostrarDetalhes();
    }
}
 
/* Classe base ou superclasse */
class ItemBiblioteca {
    private String titulo;
    private int anoPublicacao;
    
    /* Construtor */
    public ItemBiblioteca(String titulo, int anoPublicacao) {
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }
    
    /* Getters e setters */
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    
    /* Metodo para mostrar detalhes do item */
    public void mostrarDetalhes() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano de publicacao: " + anoPublicacao);
    }
}
 
/* Subclasse para livros */
class Livro extends ItemBiblioteca {
    private String autor;
    private int numPaginas;
    
    /* Construtor */
    public Livro(String titulo, int anoPublicacao, String autor, int numPaginas) {
        super(titulo, anoPublicacao);
        this.autor = autor;
        this.numPaginas = numPaginas;
    }
    
    /* Getters e setters */
    public String getAutor() {
        return autor;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getNumPaginas() {
        return numPaginas;
    }
    
    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }
    
    /* Sobrescrita do metodo mostrarDetalhes() */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Autor: " + autor);
        System.out.println("Numero de paginas: " + numPaginas);
    }
}
 
/* Subclasse para DVDs */
class DVD extends ItemBiblioteca {
    private String categoria;
    private int duracaoMinutos;
    
    /* Construtor */
    public DVD(String titulo, int anoPublicacao, String categoria, int duracaoMinutos) {
        super(titulo, anoPublicacao);
        this.categoria = categoria;
        this.duracaoMinutos = duracaoMinutos;
    }
    
    /* Getters e setters */
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }
    
    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
    
    /* Sobrescrita do metodo mostrarDetalhes() */
    @Override
    public void mostrarDetalhes() {
        super.mostrarDetalhes();
        System.out.println("Categoria: " + categoria);
        System.out.println("Duracao em minutos: " + duracaoMinutos);
    }
}
