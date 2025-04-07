import java.util.Map;
import java.util.TreeMap;

public class ConjuntoMaps {
    public static void main(String[] args) {

        var alunos = new TreeMap<Integer , ALUNOS>();

        alunos.put(1 , new ALUNOS( "Arthur", "ADS", 8));
        alunos.put(2 , new ALUNOS( "Thiago", "ADS", 8));
        alunos.put(3 , new ALUNOS( "João", "ADS", 8));
        alunos.put(4 , new ALUNOS( "Bruna", "ADS", 8));
        alunos.put(5 , new ALUNOS( "Janny", "ADS", 8));

        System.out.println(alunos.toString());

        for (Map.Entry<Integer , ALUNOS> entry : alunos.entrySet()){
            System.out.println("Aluno: " + alunos.get(entry.getKey()).getNome() +
                               " Diciplina; " + alunos.get(entry.getKey()).getDiciplina() +
                               " Nota: " + alunos.get(entry.getKey()).getNota() );
        }

        alunos.get(1).setNota(10);

        alunos.remove(3);

        for (Map.Entry<Integer , ALUNOS> entry : alunos.entrySet()){
            System.out.println("Aluno: " + alunos.get(entry.getKey()).getNome() + " Diciplina; " + alunos.get(entry.getKey()).getDiciplina() + " Nota: " + alunos.get(entry.getKey()).getNota() );
        }

        alunos.clear();

    }
}
class ALUNOS{
    String nome;
    String diciplina;
    int nota;

    //CONSTRUCTOR
    protected ALUNOS(String nome, String diciplina, int nota){
        this.nome = nome;
        this.diciplina = diciplina;
        this.nota = nota;
    }
    //GETTERS
    String getNome(){return this.nome;}
    String getDiciplina(){return this.diciplina;}
    int getNota(){return this.nota;}
    //SETTERS
    void setNome(String nome){this.nome=nome;}
    void setDiciplina(String diciplina){this.diciplina=diciplina;}
    void setNota(int nota){this.nota=nota;}

    @Override
    public String toString() {
        return this.nome + " " + this.diciplina + " " + this.nota;
    }
}