import java.util.ArrayList;
import java.util.Scanner;

public class Ex07ArrayInvert {

    public static void main(String[] args) {

        ArrayList<VETOR> vetor = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.printf("Defina o tamanho do vetor: ");
        int tnhoVetor= sc.nextInt();
        preencheVet(vetor, tnhoVetor);
        MostrarArrayInvert(vetor ,  tnhoVetor);

    }

    protected static void preencheVet(ArrayList<VETOR> vetor, int limitador){

        Scanner sc = new Scanner(System.in);

        int n;

        for (int i = 0; i<limitador; i++){
            System.out.printf("Preencha o VETOR %d:\n", i+1);
             n= sc.nextInt();
            vetor.add(new VETOR(n));
            if (i==limitador-1){
                System.out.printf("Imprimindo o VETOR:\n");
                for (int j = 0; j < limitador; j++) {
                    System.out.printf("[%d]", vetor.get(j).GetVETOR());
                }
                System.out.println();
            }

        }
    }

    protected static void MostrarArrayInvert(ArrayList<VETOR> vetor, int limitador) {
        System.out.printf("Imprimindo o VETOR inverted:\n");

        for (int j=limitador-1; j >= 0; j--) {
            System.out.printf("[%d]", vetor.get(j).GetVETOR());
        }
    }
}
class VETOR{
    private int n;

    protected VETOR(int n ){this.n = n;}
    protected void SetVETOR(int n){this.n = 0;}
    protected int GetVETOR(){return n;}
}
