public class Exemplo7_inClasses {
    public static void main(String[] args) {
        try {
            /* Criação de um objeto Aluno com dados iniciais */
            Aluno aluno = new Aluno("Carla", 11, 75);
            aluno.exibirResumo();
        } catch (IllegalArgumentException e) {
            /* Trata os erros de validação lançados pela classe Aluno */
            System.out.println("Erro(s) no cadastro do aluno:");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Processo finalizado.");
        }
    }
}
 
public class Aluno {
    private String nome;
    private double notaFinal;
    private double frequencia;
 
    /* Construtor com validações */
    public Aluno(String nome, double notaFinal, double frequencia) {
        
        StringBuilder erros = new StringBuilder();
 
        if (notaFinal < 0 || notaFinal > 10) {
            erros.append("Nota invalida!\n");
        }
 
        if (frequencia < 75) {
            erros.append("Frequencia insuficiente!\n");
        }
 
        if (erros.length() > 0) {
            throw new IllegalArgumentException(erros.toString());
        }
 
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.frequencia = frequencia;
    }
 
    public void exibirResumo() {
        System.out.println("Aluno: " + nome);
        System.out.printf("Nota final: %.1f\n", notaFinal);
        System.out.printf("Frequencia: %.1f%%\n", frequencia);
    }
}

