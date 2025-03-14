import java.util.Scanner;

public class Ex01 {
    public static void Media(float nota1, float nota2, float nota3, String nome){
        float media=(nota1+nota2+nota3)/3f;
        System.out.printf("\n\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("+--------------NOME---------------+\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("+----        %s         ", nome);
        System.out.printf("----+\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("+-------------MEDIA---------------+\n");
        System.out.printf("+---------------------------------+\n");
        System.out.printf("+----         %.2f           ", media);
        System.out.printf("----+\n");
        System.out.printf("+---------------------------------+\n");
    }

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        float nota1, nota2, nota3;
        String nome;

        System.out.printf("+---------------------------------+\n");
        System.out.printf("+--Digite o nome do aluno: ");
        nome = scanner.next();
        System.out.printf("+                                 +\n");
        System.out.printf("+--Nota 1: ");
        nota1 = scanner.nextFloat();
        System.out.printf("+                                 +\n");
        System.out.printf("+--Nota 2: ");
        nota2 = scanner.nextFloat();
        System.out.printf("+                                 +\n");
        System.out.printf("+--Nota 3: ");
        nota3 = scanner.nextFloat();
        System.out.printf("+---------------------------------+\n");

        Media(nota1, nota2, nota3, nome);

    }
}