import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ex08VetorMedia {
    public static void main(String[] args) {

        Scanner input = new Scanner (System.in);

        ArrayList<VETOR2> vetor = new ArrayList<>();

        PreencherVetor(vetor);
        Calc(vetor);
    }

    protected static void PreencherVetor(ArrayList<VETOR2> vetor){

        Random random= new Random();

        Scanner sc = new Scanner (System.in);

        System.out.printf("Defina o tamanho do ArrayList: ");
        int  tamanho = sc.nextInt();

        for (int i = 0; i < tamanho; i++) {
            vetor.add(new VETOR2(random.nextInt(100)));
            System.out.printf("[%s]", vetor.get(i).GetNumero());
        }
        System.out.println();
    }
    protected static void Calc(ArrayList<VETOR2> vetor){

        float soma = 0, media = 0;

        for (int i = 0; i < vetor.size(); i++) {

            soma+=vetor.get(i).GetNumero();
            if (i==vetor.size()-1){

                media = soma/vetor.size();
                System.out.printf("Media do Array: %.1f\n", media);
                System.out.printf("Valores Maiores ou iguais a Media:\n");
                for (int j = 0; j < vetor.size(); j++) {

                    if (vetor.get(j).GetNumero()==media || vetor.get(j).GetNumero()>media){

                        System.out.printf("[%s]",vetor.get(j).GetNumero());
                    }
                }
            }
        }
    }
}
class VETOR2{
    private int n;
    protected VETOR2(int n){this.n = n;}
    protected int GetNumero(){return n;}
    protected void SetNumero(int n){this.n = n;}
}
