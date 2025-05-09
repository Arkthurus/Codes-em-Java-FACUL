public class App {
    public static void main(String[] args) throws Exception {
        
        CURSO c1 = new CURSO("Biologia Mecanica", 120);
        CURSO c2 = new CURSO("Biologia Espacial", 220);

        ALUNO a1 = new ALUNO("Arthur Padilha", 20, "A1239", c2, 7.2, 6.9);
        ALUNO a2 = new ALUNO("Lincoln Matos", 22, "L9871", c1, 6.9, 6.9);

        a1.exibirInformacoes();
        a2.exibirInformacoes();
    }
}

abstract class PESSOA {//abstract torna a class "não instanciavel", utilizado para criar um-
                       //class molde para as SubClasses
    public String nome;
    public int idade;
 
    public PESSOA(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    
    public abstract void exibirInformacoes();//Só é possivel criar função "abstract's" em classes "abstrac's"-
                                             //-uma function abstract obriga as SUbClasses a terem essa function
}
class CURSO{
    public String nomeCurso;
    public int cargaHr;

    //CONSTRUCTOR
    public CURSO(String nomeCurso, int cargaHr) {
        this.nomeCurso = nomeCurso;
        this.cargaHr = cargaHr;
    }


    public void exibirInformacoes() {
        System.out.println("Curso: " + nomeCurso);
        System.out.println("Carga horaria: " + cargaHr);
    }

    public String getNomeCurso() {return nomeCurso;}

    public void setNomeCurso(String nomeCurso) {this.nomeCurso = nomeCurso;}

    public int getCargaHr(){return cargaHr;}

    public void setCargaHr(int cargaHr) {this.cargaHr = cargaHr;}
}
class ALUNO extends PESSOA{
    public String matricula;
    public CURSO curso;
    public double nota1;
    public double nota2;

    //CONSTRUCTOR
    public ALUNO(String nome, int idade, String matricula, CURSO curso, double nota1, double nota2){
        super(nome, idade);
        this.matricula=matricula;
        this.curso=curso;
        this.nota1=nota1;
        this.nota2=nota2;
    }

    public double calcAproved(){
        double media=(nota1+nota2)/2;
        return media;
    }

    @Override
    public void exibirInformacoes() {
        double media=calcAproved();
        System.out.println("----------------------------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Matricula: "+matricula);
        System.out.println("Curso: "+ curso.getNomeCurso());
        System.out.println("Carga horaria: "+ curso.getCargaHr()+" Horas");
        System.out.printf("Media: %.1f\n", media);
        System.out.println(media>=7?"Aprovado":"Reprovado");
        System.out.println("----------------------------");
    }
}
